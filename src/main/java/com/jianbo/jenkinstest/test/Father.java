package com.jianbo.jenkinstest.test;

public class Father {

    private static Demo demo = new Demo();

    static {
        System.out.println(demo==null);
        System.out.println("父静态代码块");
    }



}
