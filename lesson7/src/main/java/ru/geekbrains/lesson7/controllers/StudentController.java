package ru.geekbrains.lesson7.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.lesson7.entities.Student;
import ru.geekbrains.lesson7.services.StudentService;

import java.util.List;

@Controller
@Setter
@RequestMapping(path = "/stud")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
