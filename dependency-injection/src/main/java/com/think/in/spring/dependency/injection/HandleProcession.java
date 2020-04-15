package com.think.in.spring.dependency.injection;

import bean.People;

/**
 * @description: 依赖注入的处理过程，源码分析
 * 入口：DefaultListableBeanFactory {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency}
 * 依赖描述符{@link org.springframework.beans.factory.config.DependencyDescriptor}
 * 自动绑定候选对象处理器 {@link org.springframework.beans.factory.support.AutowireCandidateResolver}
 *
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-15 13:09
 */
public class HandleProcession {
    private People people;
}
