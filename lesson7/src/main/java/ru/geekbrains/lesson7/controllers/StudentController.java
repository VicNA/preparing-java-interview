package ru.geekbrains.lesson7.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson7.entities.Student;
import ru.geekbrains.lesson7.services.StudentService;

import java.util.List;

@RestController
@Setter
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentbyId(id).get();
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
