package cn.aesop.generator.extend.plugin;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 生成扩展Dao文件，用于扩展Mapper的操作。
 * 每个表分别对应生成两个文件 xxxDao.java、xxxDao.xml。 该插件通过生成的xxxDao.java，继承了原来生成的xxxMapper.java文件，已经包含默认的sql操作，
 * 项目中可以直接使用xxxDao.java进行开发，无需对xxxMapper.java文件进行更改，而且原所有由mybatis generator生成的文件（包括model、mapper、example），每次生成都会被重新覆盖，
 * 不应该再修改这些文件，与数据库表建立了固定联系， 后续开发只需要集中于xxxDao.xml 和 xxxDao.xml 文件即可。
 * 总体开发步骤：数据库表添加或变更->运行Mybatis Generator生成->model、mapper、example文件重新覆盖更新，扩展文件已存在的不覆盖—>根据需要对扩展的xxxDao进行开发
 *
 *
 * 使用方法：
 * 在generatorConfig.xml中的Content内添加该插件 ，四个属性值必传，如：
 * <content ...>
 *  <extend type="cn.aesop.generator.extend.plugin.AddExtendServicePlugin">
 *      <property name="baseDir" value="${basedir}"/> POM所在目录
 *      <property name="targetProject" value="src/main/java"/> 根包位置
 *      <property name="targetProjectXml" value="src/main/resources"/> xml资源位置
 *      <property name="targetServicePackage" value="cn.issuetracker.group.dao"/> 根包位置
 *  </extend>
 *  ...
 * </content>
 *
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/18 16:28
 */
public class AddExtendServicePlugin extends PluginAdapter {
    private String fileTitle="《由Mybatis Generator extend插件自动生成》";
    private String targetServicePackage;
    private String targetControllerPackage;
    private String targetProject;
    // private String baseDir;

    @Override
    public boolean validate(List<String> list) {
        targetServicePackage = properties.getProperty("targetServicePackage");
        targetControllerPackage = properties.getProperty("targetControllerPackage");
        targetProject = properties.getProperty("targetProject");
        if(targetServicePackage==null || targetServicePackage.trim().isEmpty()
                ||targetControllerPackage==null || targetControllerPackage.trim().isEmpty()
                ||targetProject==null || targetProject.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    // @Override
    // public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
    //     daoBaseName = introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "Dao";
    //
    //     try {
    //         Field field = sqlMap.getClass().getDeclaredField("isMergeable");
    //         field.setAccessible(true);
    //         field.setBoolean(sqlMap, false);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return true;
    // }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        List<GeneratedJavaFile> files = new ArrayList<>();
        GeneratedJavaFile service = generateService(introspectedTable);
        if(service!=null) {
            files.add(service);
        }

        GeneratedJavaFile serviceImpl = generateServiceImpl(introspectedTable);
        if(serviceImpl!=null) {
            files.add(serviceImpl);
        }

        //获取Service接口类路径
        GeneratedJavaFile controller = generateController(introspectedTable, service);
        if(controller!=null) {
            files.add(controller);
        }
        return files;
    }

    private GeneratedJavaFile generateController(IntrospectedTable introspectedTable, GeneratedJavaFile serviceInterface) {
        String baseName = introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "Controller";
        String domainObjectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        String serviceFullyQualifiedName = serviceInterface.getCompilationUnit().getType().getFullyQualifiedNameWithoutTypeParameters();
        String serviceName = serviceInterface.getCompilationUnit().getType().getShortNameWithoutTypeArguments();

        boolean hasCreateTime=false;
        boolean hasCreateUser=false;
        boolean hasUpdateUser=false;
        boolean hasUpdateTime=false;

        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
        for (IntrospectedColumn column : allColumns) {
            if("create_time".equals(column.getActualColumnName())) {
                hasCreateTime = true;
            }
            if("create_user".equals(column.getActualColumnName())) {
                hasCreateUser = true;
            }
            if("update_user".equals(column.getActualColumnName())) {
                hasUpdateUser = true;
            }
            if("update_time".equals(column.getActualColumnName())) {
                hasUpdateTime = true;
            }
        }

        // String targetPackagePath = targetServicePackage.replaceAll("\\.", "/");
        // StringBuilder filePath = new StringBuilder();
        // filePath.append(baseDir)
        //         .append(File.separator)
        //         .append(targetProject)
        //         .append(File.separator)
        //         .append(targetPackagePath)
        //         .append(File.separator)
        //         .append("impl")
        //         .append(File.separator)
        //         .append(baseName)
        //         .append(".java");
        // if(new File(filePath.toString()).exists()) {
        //     System.out.println(filePath+"文件存在，不生成");
        //     return null;
        // }

        TopLevelClass javaObject = new TopLevelClass(targetControllerPackage +"."+baseName);
        javaObject.setVisibility(JavaVisibility.PUBLIC);

        //导包
        javaObject.addImportedType(new FullyQualifiedJavaType("org.springframework.web.bind.annotation.*"));
        javaObject.addImportedType(new FullyQualifiedJavaType("org.springframework.beans.factory.annotation.Autowired"));
        javaObject.addImportedType(new FullyQualifiedJavaType("lombok.extern.slf4j.Slf4j"));
        javaObject.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.ApiOperation"));
        javaObject.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.Api"));
        javaObject.addImportedType(new FullyQualifiedJavaType("com.github.pagehelper.PageInfo"));
        javaObject.addImportedType(new FullyQualifiedJavaType("cn.kspshare.config.userinfo.UserInfoManager"));
        javaObject.addImportedType(new FullyQualifiedJavaType("cn.kspshare.config.userinfo.UserInfo"));
        javaObject.addImportedType(new FullyQualifiedJavaType("cn.kspshare.common.restful.ResultBean"));
        javaObject.addImportedType(new FullyQualifiedJavaType("cn.kspshare.annotation.UserLoginToken"));

        javaObject.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
        javaObject.addImportedType(new FullyQualifiedJavaType(serviceFullyQualifiedName));

        //添加类注释
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        javaObject.addJavaDocLine("/**\n" +
                " * " +fileTitle+"\n"+
                " * \n" +
                " * @author Mybatis Generator\n" +
                " * @date " + dateFormatter.format(new Date()) +"\n"+
                " */");

        //添加类注解
        javaObject.addAnnotation("@RestController");
        javaObject.addAnnotation("@UserLoginToken");
        javaObject.addAnnotation("@Slf4j");
        javaObject.addAnnotation("@Api(tags = \""+introspectedTable.getRemarks()+"\")");

        //添加字段：依赖注入
        Field field1 = new Field("userInfoManager", new FullyQualifiedJavaType("UserInfoManager"));
        field1.addAnnotation("@Autowired");
        field1.setVisibility(JavaVisibility.PRIVATE);
        javaObject.addField(field1);

        Field field2 = new Field("service", new FullyQualifiedJavaType(serviceName));
        field2.addAnnotation("@Autowired");
        field2.setVisibility(JavaVisibility.PRIVATE);
        javaObject.addField(field2);


        String table_name = introspectedTable.getFullyQualifiedTable().getIntrospectedTableName();
        if(table_name!=null && table_name.trim().length()>0) {
            table_name = table_name.replaceAll("_", "/");
        }

        //添加接口方法1
        Method method1 = new Method("add");
        method1.addAnnotation("@ApiOperation(\"添加\")");
        method1.addAnnotation("@PostMapping(\"/"+table_name+"\")");
        method1.setVisibility(JavaVisibility.PUBLIC);
        method1.setReturnType(new FullyQualifiedJavaType("ResultBean"));
        method1.addParameter(new Parameter(new FullyQualifiedJavaType("@RequestBody "+domainObjectName), "po"));
        method1.addJavaDocLine("/**\n" +
                "     * 添加\n" +
                "     * @param po\n" +
                "     * @return\n" +
                "     */");
        method1.addBodyLine("UserInfo userInfo = userInfoManager.getUserInfo();\n" +
                        (hasCreateUser ? "        po.setCreateUser(userInfo.getOid());\n" : "" ) +
                "        service.add(po);\n" +
                "        return ResultBean.SUCCESS();");
        javaObject.addMethod(method1);

        //添加接口方法2
        Method method2 = new Method("update");
        method2.addAnnotation("@ApiOperation(\"修改\")");
        method2.addAnnotation("@PutMapping(\"/"+table_name+"\")");
        method2.setVisibility(JavaVisibility.PUBLIC);
        method2.setReturnType(new FullyQualifiedJavaType("ResultBean"));
        method2.addParameter(new Parameter(new FullyQualifiedJavaType("@RequestBody "+domainObjectName), "po"));
        method2.addJavaDocLine("/**\n" +
                "     * 修改\n" +
                "     * @param po\n" +
                "     * @return\n" +
                "     */");
        method2.addBodyLine("UserInfo userInfo = userInfoManager.getUserInfo();\n" +
                        (hasUpdateUser ? "        po.setUpdateUser(userInfo.getOid());\n" : "" )+
                "        service.update(po);\n" +
                "        return ResultBean.SUCCESS();");
        javaObject.addMethod(method2);

        //添加接口方法3
        Method method3 = new Method("delete");
        method3.addAnnotation("@ApiOperation(\"删除\")");
        method3.addAnnotation("@DeleteMapping(\"/"+table_name+"/{oid}\")");
        method3.setVisibility(JavaVisibility.PUBLIC);
        method3.setReturnType(new FullyQualifiedJavaType("ResultBean"));
        method3.addParameter(new Parameter(new FullyQualifiedJavaType("@PathVariable Long"), "oid"));
        method3.addJavaDocLine("/**\n" +
                "     * 删除\n" +
                "     * @param oid\n" +
                "     * @return\n" +
                "     */");
        method3.addBodyLine("service.delete(oid);\n" +
                "        return ResultBean.SUCCESS();");
        javaObject.addMethod(method3);

        //添加接口方法4
        Method method4 = new Method("queryCondition");
        method4.addAnnotation("@ApiOperation(\"基本条件查询\")");
        method4.addAnnotation("@GetMapping(\"/"+table_name+"\")");
        method4.setVisibility(JavaVisibility.PUBLIC);
        method4.setReturnType(new FullyQualifiedJavaType("ResultBean"));
        method4.addParameter(new Parameter(new FullyQualifiedJavaType("Integer"), "pageNum"));
        method4.addParameter(new Parameter(new FullyQualifiedJavaType("Integer"), "pageSize"));
        method4.addJavaDocLine("/**\n" +
                "     * 基本条件查询\n" +
                "     * @param pageNum 当前页码\n" +
                "     * @param pageSize 每页显示数量\n" +
                "     * @return\n" +
                "     */");
        method4.addBodyLine("if(pageNum==null) pageNum=1;\n" +
                "        if(pageSize==null) pageSize=10;\n" +
                "        PageInfo<"+domainObjectName+"> pageInfo = service.queryCondition(pageNum, pageSize);\n" +
                "        return ResultBean.SUCCESS(pageInfo);");
        javaObject.addMethod(method4);

        GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(javaObject, targetProject, "utf-8", this.context.getJavaFormatter());
        return generatedJavaFile;

    }

    private GeneratedJavaFile generateServiceImpl(IntrospectedTable introspectedTable) {
        String baseName = introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "ServiceImpl";
        String domainObjectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        boolean hasCreateTime=false;
        boolean hasCreateUser=false;
        boolean hasUpdateUser=false;
        boolean hasUpdateTime=false;

        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
        for (IntrospectedColumn column : allColumns) {
            if("create_time".equals(column.getActualColumnName())) {
                hasCreateTime = true;
            }
            if("create_user".equals(column.getActualColumnName())) {
                hasCreateUser = true;
            }
            if("update_user".equals(column.getActualColumnName())) {
                hasUpdateUser = true;
            }
            if("update_time".equals(column.getActualColumnName())) {
                hasUpdateTime = true;
            }
        }

        // String targetPackagePath = targetServicePackage.replaceAll("\\.", "/");
        // StringBuilder filePath = new StringBuilder();
        // filePath.append(baseDir)
        //         .append(File.separator)
        //         .append(targetProject)
        //         .append(File.separator)
        //         .append(targetPackagePath)
        //         .append(File.separator)
        //         .append("impl")
        //         .append(File.separator)
        //         .append(baseName)
        //         .append(".java");
        // if(new File(filePath.toString()).exists()) {
        //     System.out.println(filePath+"文件存在，不生成");
        //     return null;
        // }


        TopLevelClass javaObject = new TopLevelClass(targetServicePackage +".impl."+baseName);
        javaObject.setVisibility(JavaVisibility.PUBLIC);

        // 继承接口
        StringBuilder builder = new StringBuilder();
        FullyQualifiedJavaType superClassType = new FullyQualifiedJavaType(
                builder.append(domainObjectName)
                        .append("Service").toString()
        );
        javaObject.addSuperInterface(superClassType);
        javaObject.addImportedType(new FullyQualifiedJavaType(targetServicePackage +"."+builder.toString()));

        //导包
        javaObject.addImportedType(new FullyQualifiedJavaType("java.time.LocalDateTime"));
        javaObject.addImportedType(new FullyQualifiedJavaType("java.util.List"));
        javaObject.addImportedType(new FullyQualifiedJavaType("com.github.pagehelper.PageHelper"));
        javaObject.addImportedType(new FullyQualifiedJavaType("com.github.pagehelper.PageInfo"));
        javaObject.addImportedType(new FullyQualifiedJavaType("cn.kspshare.common.id.IDGenerator"));
        javaObject.addImportedType(new FullyQualifiedJavaType("org.springframework.beans.factory.annotation.Autowired"));
        javaObject.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Service"));
        javaObject.addImportedType(new FullyQualifiedJavaType("org.springframework.transaction.annotation.Transactional"));
        javaObject.addImportedType(new FullyQualifiedJavaType("org.mybatis.dynamic.sql.SqlBuilder"));
        javaObject.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
        javaObject.addImportedType(new FullyQualifiedJavaType(introspectedTable.getMyBatisDynamicSqlSupportType()));
        javaObject.addImportedType(new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType()));

        //添加类注释
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        javaObject.addJavaDocLine("/**\n" +
                " * " +fileTitle+"\n"+
                " * \n" +
                " * @author Mybatis Generator\n" +
                " * @date " + dateFormatter.format(new Date()) +"\n"+
                " */");

        //添加类注解
        javaObject.addAnnotation("@Service");

        //添加字段：依赖注入
        Field field = new Field("mapper", new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType()));
        field.addAnnotation("@Autowired");
        field.setVisibility(JavaVisibility.PRIVATE);
        javaObject.addField(field);

        //添加接口方法1
        Method method1 = new Method("add");
        method1.addAnnotation("@Transactional(rollbackFor = Exception.class)");
        method1.setVisibility(JavaVisibility.PUBLIC);
        method1.setReturnType(new FullyQualifiedJavaType("int"));
        method1.addParameter(new Parameter(new FullyQualifiedJavaType(domainObjectName), "po"));
        method1.addJavaDocLine("/**\n" +
                "     * 添加\n" +
                "     * @param po\n" +
                "     * @return\n" +
                "     */");
        method1.addBodyLine("po.setOid(IDGenerator.id());\n" +
                (hasCreateTime ? "        po.setCreateTime(LocalDateTime.now());\n" : "") +
                (hasUpdateUser ? "        po.setUpdateUser(null);\n" : "" ) +
                (hasUpdateTime ? "        po.setUpdateTime(null);\n" : "" ) +
                "        return mapper.insertSelective(po);");
        javaObject.addMethod(method1);

        //添加接口方法2
        Method method2 = new Method("update");
        method2.addAnnotation("@Transactional(rollbackFor = Exception.class)");
        method2.setVisibility(JavaVisibility.PUBLIC);
        method2.setReturnType(new FullyQualifiedJavaType("int"));
        method2.addParameter(new Parameter(new FullyQualifiedJavaType(domainObjectName), "po"));
        method2.addJavaDocLine("/**\n" +
                "     * 修改\n" +
                "     * @param po\n" +
                "     * @return\n" +
                "     */");
        method2.addBodyLine("if(po.getOid()==null) {\n" +
                "            throw new RuntimeException(\"主键不能为空！\");\n" +
                "        }\n" +
                        (hasCreateTime ? "        po.setCreateTime(null);\n" : "" ) +
                        (hasCreateUser ? "        po.setCreateUser(null);\n" : "" ) +
                        (hasUpdateTime ? "        po.setUpdateTime(LocalDateTime.now());\n" : "" ) +
                "        return mapper.updateByPrimaryKeySelective(po);");
        javaObject.addMethod(method2);

        //添加接口方法3
        Method method3 = new Method("delete");
        method3.addAnnotation("@Transactional(rollbackFor = Exception.class)");
        method3.setVisibility(JavaVisibility.PUBLIC);
        method3.setReturnType(new FullyQualifiedJavaType("int"));
        method3.addParameter(new Parameter(new FullyQualifiedJavaType("Long"), "oid"));
        method3.addJavaDocLine("/**\n" +
                "     * 删除\n" +
                "     * @param oid\n" +
                "     * @return\n" +
                "     */");
        method3.addBodyLine("return mapper.deleteByPrimaryKey(oid);");
        javaObject.addMethod(method3);

        //添加接口方法4
        Method method4 = new Method("queryCondition");
        method4.setVisibility(JavaVisibility.PUBLIC);
        method4.setReturnType(new FullyQualifiedJavaType("PageInfo<"+domainObjectName+">"));
        method4.addParameter(new Parameter(new FullyQualifiedJavaType("int"), "pageNum"));
        method4.addParameter(new Parameter(new FullyQualifiedJavaType("int"), "pageSize"));
        method4.addJavaDocLine("/**\n" +
                "     * 基本条件查询\n" +
                "     * @param pageNum 当前页码\n" +
                "     * @param pageSize 每页显示数量\n" +
                "     * @return\n" +
                "     */");
        method4.addBodyLine("PageHelper.startPage(pageNum,pageSize);\n" +
                "        List<"+domainObjectName+"> select = mapper.select(c -> c);\n" +
                "        return new PageInfo<>(select);");
        javaObject.addMethod(method4);


        GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(javaObject, targetProject, "utf-8", this.context.getJavaFormatter());
        return generatedJavaFile;

    }

    private GeneratedJavaFile generateService(IntrospectedTable introspectedTable) {
        String baseName = introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "Service";
        String domainObjectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        // String targetPackagePath = targetServicePackage.replaceAll("\\.", "/");
        // StringBuilder filePath = new StringBuilder();
        // filePath.append(baseDir)
        //         .append(File.separator)
        //         .append(targetProject)
        //         .append(File.separator)
        //         .append(targetPackagePath)
        //         .append(File.separator)
        //         .append(baseName)
        //         .append(".java");
        // if(new File(filePath.toString()).exists()) {
        //     System.out.println(filePath+"文件存在，不生成");
        //     return null;
        // }

        Interface javaObject = new Interface(targetServicePackage +"."+baseName);
        javaObject.setVisibility(JavaVisibility.PUBLIC);

        //导包
        String domainObject = introspectedTable.getBaseRecordType();
        FullyQualifiedJavaType domainObjectJavaType = new FullyQualifiedJavaType(domainObject);
        javaObject.addImportedType(domainObjectJavaType);

        FullyQualifiedJavaType pageHelpJavaType = new FullyQualifiedJavaType("com.github.pagehelper.PageInfo");
        javaObject.addImportedType(pageHelpJavaType);


        //添加类注释
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        javaObject.addJavaDocLine("/**\n" +
                " * " +fileTitle+"\n"+
                " * \n" +
                " * @author Mybatis Generator\n" +
                " * @date " + dateFormatter.format(new Date()) +"\n"+
                " */");

        //添加接口方法1
        Method method1 = new Method("add");
        method1.setAbstract(true);
        method1.setReturnType(new FullyQualifiedJavaType("int"));
        method1.addParameter(new Parameter(new FullyQualifiedJavaType(domainObjectName), "po"));
        method1.addJavaDocLine("/**\n" +
                "     * 添加\n" +
                "     * @param po\n" +
                "     * @return\n" +
                "     */");
        javaObject.addMethod(method1);

        //添加接口方法2
        Method method2 = new Method("update");
        method2.setAbstract(true);
        method2.setReturnType(new FullyQualifiedJavaType("int"));
        method2.addParameter(new Parameter(new FullyQualifiedJavaType(domainObjectName), "po"));
        method2.addJavaDocLine("/**\n" +
                "     * 修改\n" +
                "     * @param po\n" +
                "     * @return\n" +
                "     */");
        javaObject.addMethod(method2);

        //添加接口方法3
        Method method3 = new Method("delete");
        method3.setAbstract(true);
        method3.setReturnType(new FullyQualifiedJavaType("int"));
        method3.addParameter(new Parameter(new FullyQualifiedJavaType("Long"), "oid"));
        method3.addJavaDocLine("/**\n" +
                "     * 删除\n" +
                "     * @param oid\n" +
                "     * @return\n" +
                "     */");
        javaObject.addMethod(method3);

        //添加接口方法4
        Method method4 = new Method("queryCondition");
        method4.setAbstract(true);
        method4.setReturnType(new FullyQualifiedJavaType("PageInfo<"+domainObjectName+">"));
        method4.addParameter(new Parameter(new FullyQualifiedJavaType("int"), "pageNum"));
        method4.addParameter(new Parameter(new FullyQualifiedJavaType("int"), "pageSize"));
        method4.addJavaDocLine("/**\n" +
                "     * 基本条件查询\n" +
                "     * @param pageNum 当前页码\n" +
                "     * @param pageSize 每页显示数量\n" +
                "     * @return\n" +
                "     */");
        javaObject.addMethod(method4);

        // this.context.getProperty("javaFileEncoding")
        GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(javaObject, targetProject, "utf-8", this.context.getJavaFormatter());
        return generatedJavaFile;
    }

}
