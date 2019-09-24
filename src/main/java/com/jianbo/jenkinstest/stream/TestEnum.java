package com.jianbo.jenkinstest.stream;

public enum TestEnum {

    ONE(1),
    TWO(2);

    private TestEnum(Integer value){
        this.num = value;
    }

    private Integer num;

    public void getValue(){
        System.out.println(num);
    }
}
