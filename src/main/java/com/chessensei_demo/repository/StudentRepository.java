package com.chessensei_demo.repository;

import com.chessensei_demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
