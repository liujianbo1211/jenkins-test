package com.jianbo.jenkinstest.test;

import lombok.Data;

import java.util.Objects;
import java.util.Random;

@Data
public class User2 {

    private String userName;
    private String password;

    public User2(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User2 user2 = (User2) o;
        return Objects.equals(userName, user2.userName) &&
                Objects.equals(password, user2.password);
    }

    @Override
    public int hashCode() {
        Random random = new Random();

        return random.nextInt(1000);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收执行");
        super.finalize();
    }
}
