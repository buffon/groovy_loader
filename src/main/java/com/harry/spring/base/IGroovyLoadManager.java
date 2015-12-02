package com.harry.spring.base;

/**
 * @author chenyehui
 */
public interface IGroovyLoadManager {

    public void reload(String beanName);

    public<T extends BaseGroovy> T get(String name);
}
