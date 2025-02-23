package com.giaphi.humans;

public class People {
    // attributes, variables, fields --> truong
    public String name;
    public int age;

    // ham dung --> constructor
    public People() { }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // methods, functions, actions...
    public void eat() { // private, public, protected --> modifier
        System.out.println("Eating...");
    }

    public void sleep() {
        System.out.println("Sleeping...");
    }
}
