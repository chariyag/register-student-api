package com.studentregistrationapi.registerstudent.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitor")
public class visitor {
    @GetMapping("/openday")
    @PreAuthorize("hasAnyRole('APP_USER')")
    public String getStudent(){
        return "visitor";
    }
}