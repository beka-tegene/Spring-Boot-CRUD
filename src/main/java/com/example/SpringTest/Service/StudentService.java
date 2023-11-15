package com.example.SpringTest.Service;

import com.example.SpringTest.Model.Student;
import com.example.SpringTest.Repositery.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo StudentRepo;

    public List<Student> getAllStudent(){
        return StudentRepo.findAll();
    }
}
