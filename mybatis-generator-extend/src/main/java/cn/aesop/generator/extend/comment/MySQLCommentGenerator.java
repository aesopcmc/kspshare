package cn.aesop.generator.extend.comment;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.kotlin.KotlinFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * 自定义注解，加载数据库comment注解，去除默认生成的无用的注释
 *
 * 使用方法：
 * 在generatorConfig.xml中的Content内添加该插件，属性addRemarkComments 必须设置为true才能生效，如下：
 * <content ...>
 *     ...
 *     <commentGenerator type="cn.aesop.generator.extend.comment.MySQLCommentGenerator">
 *      <property name="addRemarkComments" value="true"/>
 *     </commentGenerator
 *     ...
 * </content>
 *
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/21 16:50
 */
public class MySQLCommentGenerator extends EmptyCommentGenerator {

    private Properties properties;

    public MySQLCommentGenerator() {
        properties = new Properties();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        // 获取自定义的 properties
        this.properties.putAll(properties);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = "Mybatis Generator";
        // String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        // SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks);
        topLevelClass.addJavaDocLine(" * " + tableName);
        topLevelClass.addJavaDocLine(" * ");
        topLevelClass.addJavaDocLine(" * @author " + author);
        // topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");

        System.out.println("=====tableName:"+tableName);

        // 添加日期格式化注解JsonFormat
        boolean localDateTimeTypeFlag = false;
        for (IntrospectedColumn baseColumn : introspectedTable.getBaseColumns()) {
            if("java.time.LocalDateTime".equals(baseColumn.getFullyQualifiedJavaType().getFullyQualifiedName())) {
                localDateTimeTypeFlag = true;
            }
            if("java.time.LocalDate".equals(baseColumn.getFullyQualifiedJavaType().getFullyQualifiedName())) {
                localDateTimeTypeFlag = true;
            }
        }
        if(localDateTimeTypeFlag) {
            FullyQualifiedJavaType importType = new FullyQualifiedJavaType("com.fasterxml.jackson.annotation.JsonFormat");
            topLevelClass.addImportedType(importType);
        }
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
        //添加字段注释
        String remarks = introspectedColumn.getRemarks();
        String columnName = introspectedColumn.getActualColumnName();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + remarks);
        field.addJavaDocLine(" * " + columnName);
        field.addJavaDocLine(" */");

        // 添加日期格式化注解JsonFormat
        if("java.time.LocalDateTime".equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
        }
        if("java.time.LocalDate".equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@JsonFormat(pattern = \"yyyy-MM-dd\")");
        }
    }
}
