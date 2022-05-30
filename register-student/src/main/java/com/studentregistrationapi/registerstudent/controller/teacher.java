package com.studentregistrationapi.registerstudent.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/teacher")
public class teacher {

  @GetMapping("/myteacher")
  @PreAuthorize("hasAnyRole('TEACHER')")
    public String getStudent(){
        return "teacher";
    }
}