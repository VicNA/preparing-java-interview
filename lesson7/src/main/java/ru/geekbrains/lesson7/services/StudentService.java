package ru.geekbrains.lesson7.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.lesson7.entities.Student;
import ru.geekbrains.lesson7.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Setter
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentbyId(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
