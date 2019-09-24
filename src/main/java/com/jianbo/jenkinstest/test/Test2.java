package com.jianbo.jenkinstest.test;


import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {

    public static void main(String[] args){




    }

    private static void test2() {
        new Thread(()->{
            Singleton.getInstance();
        }).start();

        new Thread(()->{
            System.out.println("线程2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Singleton.SINGLETON == null);
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.number);
        }).start();
    }

    public static void test1(){
        HashMap<User2,String> hashMap = new HashMap<>();

        User2 user2 =new User2("zhangsan","123456");
        hashMap.put(user2,"aaa");

        System.out.println(hashMap);
        System.out.println(hashMap.get(user2));

        Hashtable hashtable = new Hashtable();
        hashtable.put(null,11);
        //hashtable.get()


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(111,111);
       // concurrentHashMap.get()
    }

}

