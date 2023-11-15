package com.example.SpringTest.Controller;

import com.example.SpringTest.Model.Student;
import com.example.SpringTest.Repositery.StudentRepo;
import com.example.SpringTest.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    public StudentRepo StudentRepo;
    @Autowired
    public StudentService StudentService;
    @PostMapping("/student")
    public void PutStudent(@RequestBody Student Student){
        StudentRepo.save(Student);
    }
    @GetMapping("/getstudent")
    public ResponseEntity<List<Student>> getStudent(){
        return new ResponseEntity<List<Student>>(StudentService.getAllStudent() , HttpStatus.OK);
    }

    @GetMapping("/getstudent/{sid}")
    public Student getStudentById(@PathVariable Integer sid){
        return StudentRepo.findById(sid).get();
    }

    @PostMapping("/updatestudent")
    public Student UpdateStudentName(@RequestBody Student Student){
        Optional<Student> Stud = StudentRepo.findById(Student.getSid());
        if (!Stud.isEmpty()){
            Stud.get().setSid(Student.getSid());
            Stud.get().setName(Student.getName());
            Stud.get().setGrade(Student.getGrade());
            StudentRepo.save(Stud.get());
        }
        return StudentRepo.save(Student);
    }
    @GetMapping("/deletebyid/{sid}")
    public String deleteStudentById(@PathVariable Integer sid){
        StudentRepo.deleteById(sid);
        return "Student Delete Successful";
    }
}
