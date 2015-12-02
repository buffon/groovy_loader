package com.harry.spring.base;

import groovy.lang.GroovyClassLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * @author chenyehui
 */
@Component
public class GroovyLoadManager implements IGroovyLoadManager, ApplicationContextAware, InitializingBean {

    private ConfigurableWebApplicationContext ac;

    private DefaultListableBeanFactory beanFactory;

    GroovyClassLoader loader = new GroovyClassLoader();

    public static final String BEAN_NAME = "BEAN_NAME";

    private static final String GROOVY_CONTENT = "package com.harry.spring.groovy\n" +
            "\n" +
            "import com.harry.spring.base.BaseGroovy\n" +
            "import com.harry.spring.service.ShootService\n" +
            "import org.springframework.beans.factory.annotation.Autowired\n" +
            "\n" +
            "/**\n" +
            " *\n" +
            " * @author chenyehui\n" +
            " */\n" +
            "class Shoot extends BaseGroovy {\n" +
            "    @Autowired\n" +
            "    private ShootService shootService;\n" +
            "\n" +
            "    @Override\n" +
            "    void say() {\n" +
            "        shootService.hello()\n" +
            "        println(\"==========\")\n" +
            "    }\n" +
            "}\n";


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = (ConfigurableWebApplicationContext) applicationContext;
        beanFactory = (DefaultListableBeanFactory) ac.getBeanFactory();
    }

    @Override
    public void reload(String beanName) {
        Class clazz = loader.parseClass(GROOVY_CONTENT);
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        beanFactory.registerBeanDefinition(BEAN_NAME, builder.getBeanDefinition());
    }

    @Override
    public <T extends BaseGroovy> T get(String name) {
        return (T) beanFactory.getBean(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        reload("");
    }
}
