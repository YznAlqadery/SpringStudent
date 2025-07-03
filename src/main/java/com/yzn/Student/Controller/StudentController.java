package com.yzn.Student.Controller;

import com.yzn.Student.Model.Student;
import com.yzn.Student.Repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    public final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student postStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentRepository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/search/{name}")
    public List<Student> findStudentByName(@PathVariable String name){
        return studentRepository.findAllByFirstName(name);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable Integer id){
        studentRepository.deleteById(id);
    }
}
