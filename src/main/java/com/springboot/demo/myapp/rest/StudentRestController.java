package com.springboot.demo.myapp.rest;

import com.springboot.demo.myapp.dao.StudentDAO;
import com.springboot.demo.myapp.entity.Student;
import com.springboot.demo.myapp.errorhandling.StudentErrorResponse;
import com.springboot.demo.myapp.errorhandling.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    StudentDAO studentDAO;
    @Autowired
    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return queryForStudents(studentDAO);
    }


    private List<Student> queryForStudents(StudentDAO studentDAO) {

         List<Student> theStudents = studentDAO.findAll();
         return theStudents;
    }

    @GetMapping("students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {
        if (studentID > studentDAO.findAll().size() || studentID < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentID);
        }
        return studentDAO.findById(studentID);
    }

}
