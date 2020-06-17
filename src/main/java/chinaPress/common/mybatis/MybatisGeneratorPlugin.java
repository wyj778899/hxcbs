package chinaPress.common.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

public class MybatisGeneratorPlugin extends PluginAdapter {
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	/**
	 * 是否生成类
	 * 
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// 添加domain的import
//        topLevelClass.addImportedType("lombok.Data");

		// 添加domain的注解
//        topLevelClass.addAnnotation("@Data");

		topLevelClass.addJavaDocLine("/**");

		String remarks = introspectedTable.getRemarks();
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));
			for (String remarkLine : remarkLines) {
				topLevelClass.addJavaDocLine(" * " + remarkLine);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(" * ").append(introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(sb.toString());
		sb.setLength(0);
		sb.append(" * @author ").append(System.getProperties().getProperty("user.name"));
		topLevelClass.addJavaDocLine(sb.toString());
		sb.setLength(0);
		sb.append(" * @date ");
		sb.append(getDateString());
		topLevelClass.addJavaDocLine(sb.toString());
		topLevelClass.addJavaDocLine(" */");
		return true;
	}

	/**
	 * 是否生成属性
	 * 
	 * @param field
	 * @param topLevelClass
	 * @param introspectedColumn
	 * @param introspectedTable
	 * @param modelClassType
	 * @return
	 */
	@Override
	public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		field.addJavaDocLine("/**");
		String remarks = introspectedColumn.getRemarks();
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));
			for (String remarkLine : remarkLines) {
				field.addJavaDocLine(" * " + remarkLine);
			}
		}
		field.addJavaDocLine(" */");
		return true;
	}

	/**
	 * 是否生成dao接口
	 * 
	 * @param interfaze
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// 添加Mapper的import
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
		interfaze.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
		// 添加Mapper的注解
		interfaze.addAnnotation("@Mapper");
		interfaze.addAnnotation("@Repository");
		return true;
	}

	/**
	 * 是否生成setter
	 * 
	 * @param method
	 * @param topLevelClass
	 * @param introspectedColumn
	 * @param introspectedTable
	 * @param modelClassType
	 * @return
	 */
	@Override
	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		method.addJavaDocLine("/**");
		String remarks = introspectedColumn.getRemarks();
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));
			for (String remarkLine : remarkLines) {
				method.addJavaDocLine(" * " + remarkLine);
			}
		}
		method.addJavaDocLine(
				" * @param " + topLevelClass.getFields().get(topLevelClass.getFields().size() - 1).getName());
		method.addJavaDocLine(" */");
		return true;
	}

	/**
	 * 是否生成getter
	 * 
	 * @param method
	 * @param topLevelClass
	 * @param introspectedColumn
	 * @param introspectedTable
	 * @param modelClassType
	 * @return
	 */
	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		method.addJavaDocLine("/**");
		String remarks = introspectedColumn.getRemarks();
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));
			for (String remarkLine : remarkLines) {
				method.addJavaDocLine(" * " + remarkLine);
			}
		}
		method.addJavaDocLine(
				" * @return " + topLevelClass.getFields().get(topLevelClass.getFields().size() - 1).getName());
		method.addJavaDocLine(" */");
		return true;
	}

	protected String getDateString() {
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
}
