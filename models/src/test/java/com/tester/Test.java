package com.tester;

import org.springframework.util.StringUtils;

/**
 * @description: 测试类
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-24 15:04
 */
public class Test {
    public static void main(String[] args) {
        String s = "null";
        Object object = null;
        System.out.println(StringUtils.isEmpty(object));
        System.out.println(StringUtils.isEmpty(s));
    }
}
