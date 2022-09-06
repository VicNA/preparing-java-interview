package ru.geekbrains.lesson7.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.geekbrains.lesson7.services.StudentService;

@Controller
@Setter
public class StudentController {
    @Autowired
    private StudentService studentService;
}
