package ru.geekbrains.lesson7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson7.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
