package com.example.demo.controllers;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FirstController {
    @RequestMapping("/welcome")
    public String doWelcome() {
        return "Welcome to Spring Rest Example";
    }
    @RequestMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("ABC", "T"));
        students.add(new Student("PQR", "JP"));
        return students;
    }
}
