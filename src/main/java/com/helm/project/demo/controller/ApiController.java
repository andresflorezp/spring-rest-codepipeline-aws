package com.helm.project.demo.controller;

import com.helm.project.demo.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ApiController {
    final ServiceUser serviceUser;

    public ApiController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }


    @GetMapping()
    public ResponseEntity<?> getGreeting() {
        return new ResponseEntity<>(serviceUser.getDefaultUser(), HttpStatus.ACCEPTED);

    }
}
