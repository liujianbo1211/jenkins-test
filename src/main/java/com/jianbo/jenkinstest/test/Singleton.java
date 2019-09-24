package com.jianbo.jenkinstest.test;

public class Singleton {

    public int number = 0;
    public static Singleton SINGLETON ;

    private Singleton()   {
        System.out.println("初始化...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number=100;
        System.out.println("初始化完成");
    }

    public static Singleton getInstance(){
        if(SINGLETON==null){
            synchronized(Singleton.class){
                if(SINGLETON==null)
                    SINGLETON= new Singleton();
            }
        }
        return SINGLETON;
    }

    public static void print(){

    }

}
