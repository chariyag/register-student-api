package com.studentregistrationapi.registerstudent.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class student {

    @GetMapping("/mystudent")
    public String getStudent(){
        return "student";
    }
}
