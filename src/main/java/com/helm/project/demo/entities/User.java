package com.helm.project.demo.entities;

public class User {
    private String name;
    private String lastname;


    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    public String greeting(String environment){
        return "Hello "+name+" "+ lastname+ " with environment "+ environment;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
