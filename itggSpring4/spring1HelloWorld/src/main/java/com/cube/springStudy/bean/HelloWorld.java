package com.cube.springStudy.bean;

/**
 * Created by z003MWVR on 11/2/2016.
 */
public class HelloWorld {
    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void say(){
        System.out.println("Hello, my name is " + name + ",my age is " + age);
    }
}
