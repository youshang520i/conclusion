package com.youshang520i.demo.springlifecycle.bean;

public class RelyOn {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RelyOn{" +
                "name='" + name + '\'' +
                '}';
    }
}
