package com.yzn.Student.Repository;

import com.yzn.Student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstName(String firstname);

}
