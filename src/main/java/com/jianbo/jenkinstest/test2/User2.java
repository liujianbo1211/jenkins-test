package com.jianbo.jenkinstest.test2;

import lombok.Data;

@Data
public class User2 {

    public static User2 user = new User2();

    private String userName;

    private String date;

    public User2(){
        System.out.println("初始化");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.userName="username";
        System.out.println("初始化完成");
    }
}
