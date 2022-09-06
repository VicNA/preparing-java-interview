package ru.geekbrains.lesson7.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter
public class StudentService {
    @Autowired
    private StudentService studentService;
}
