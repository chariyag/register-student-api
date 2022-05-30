package com.studentregistrationapi.registerstudent.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.studentregistrationapi.registerstudent.security.ApplicationUserPermision.*;

public enum ApplicationUserRole {
    APP_USER(Sets.newHashSet(COURSE_READ)),
    STUDENT(Sets.newHashSet(STUDENT_READ,COURSE_READ)),
    ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_READ,COURSE_WRITE)),
    TEACHER(Sets.newHashSet(COURSE_READ,STUDENT_READ));

    private final Set<ApplicationUserPermision> permisions;

    ApplicationUserRole(Set<ApplicationUserPermision> permisions){
        this.permisions = permisions;
    }

}
