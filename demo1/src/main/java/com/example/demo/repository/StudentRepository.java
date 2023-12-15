package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentTable;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentTable, Long> {

    List<StudentTable> findByLastName(String name);

    StudentTable findById(long id);

}
