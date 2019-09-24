package com.jianbo.jenkinstest.test2;

import lombok.Data;

@Data
public class User1 {

    static {
        System.out.println("静态代码块");
    }

    public static User1 user1 = new User1();

    private String userName;

    private Long date;



    {
        System.out.println("代码快。。。。");
    }

    public User1(){
        System.out.println("构造方法");
    }

}
