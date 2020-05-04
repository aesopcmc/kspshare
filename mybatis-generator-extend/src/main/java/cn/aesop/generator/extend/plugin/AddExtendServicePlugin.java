package cn.aesop.generator.extend.plugin;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.XmlConstants;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
 *      <property name="targetPackage" value="cn.issuetracker.group.dao"/> 根包位置
 *  </extend>
 *  ...
 * </content>
 *
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/18 16:28
 */
public class AddExtendServicePlugin extends PluginAdapter {
    private String fileTitle="《扩展Dao操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》";
    private String targetPackage;
    private String targetProject;
    private String daoBaseName;
    private String baseDir;

    @Override
    public boolean validate(List<String> list) {
        baseDir = properties.getProperty("baseDir");
        targetPackage = properties.getProperty("targetPackage");
        targetProject = properties.getProperty("targetProject");
        if(baseDir==null || baseDir.trim().isEmpty()
            ||targetPackage==null || targetPackage.trim().isEmpty()
            ||targetProject==null || targetProject.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        daoBaseName = introspectedTable.getFullyQualifiedTable().getDomainObjectName() + "Dao";

        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        String targetPackagePath = targetPackage.replaceAll("\\.", "/");
        StringBuilder filePath = new StringBuilder();
        filePath.append(baseDir)
            .append(File.separator)
                .append(targetProject)
                .append(File.separator)
                .append(targetPackagePath)
                .append(File.separator)
                .append(daoBaseName)
                .append(".java");
        if(new File(filePath.toString()).exists()) {
            System.out.println(filePath+"文件存在，不生成");
            return null;
        }

        CompilationUnit unit = generateUnit(introspectedTable);
        // this.context.getProperty("javaFileEncoding")
        GeneratedJavaFile gf = new GeneratedJavaFile(unit, targetProject, "utf-8", this.context.getJavaFormatter());
        return Arrays.asList(gf);
    }

    private CompilationUnit generateUnit(IntrospectedTable introspectedTable) {
        //实体类类型
        // String entityClazzType = introspectedTable.getBaseRecordType();
        // xxxMapper类类型
        String mapperInterfaceType = introspectedTable.getMyBatis3JavaMapperType();

        String domainObjectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        StringBuilder builder = new StringBuilder();

        //继承接口 xxxMapper.java
        FullyQualifiedJavaType superClassType = new FullyQualifiedJavaType(
                builder.append(domainObjectName)
                        .append("Mapper").toString()
        );
        Interface dto = new Interface(targetPackage +"."+daoBaseName);
        dto.addSuperInterface(superClassType);
        dto.setVisibility(JavaVisibility.PUBLIC);

        //导入xxxMapper类所在的包
        FullyQualifiedJavaType modelJavaType = new FullyQualifiedJavaType(mapperInterfaceType);
        dto.addImportedType(modelJavaType);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dto.addJavaDocLine("/**\n" +
                " * " +fileTitle+"\n"+
                " * \n" +
                " * @author Mybatis Generator\n" +
                " * @date " + dateFormatter.format(new Date()) +"\n"+
                " */");

        return dto;
    }

}
