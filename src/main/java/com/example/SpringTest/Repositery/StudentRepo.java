package com.example.SpringTest.Repositery;

import com.example.SpringTest.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student , Integer> {
}
