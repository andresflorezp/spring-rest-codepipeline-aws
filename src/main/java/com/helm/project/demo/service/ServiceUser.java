package com.helm.project.demo.service;

import com.helm.project.demo.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {
    @Value("${environment}")
    private String environment;
    public String getDefaultUser(){
        return new User("Andres", "Florez").greeting(environment);
    }
}
