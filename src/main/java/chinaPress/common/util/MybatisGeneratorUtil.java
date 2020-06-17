package chinaPress.common.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorUtil {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(new File("src/main/resources/generator/generatorConfig.xml"));
        Context context = config.getContexts().get(0);
        context.getJavaModelGeneratorConfiguration().setTargetProject(context.getJavaModelGeneratorConfiguration().getTargetProject());
        context.getSqlMapGeneratorConfiguration().setTargetProject(context.getSqlMapGeneratorConfiguration().getTargetProject());
        context.getJavaClientGeneratorConfiguration().setTargetProject(context.getJavaClientGeneratorConfiguration().getTargetProject());
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
