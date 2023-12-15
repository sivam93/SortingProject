package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.view.SortingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public interface    SortingTechnique {
    List<Student> sort(List<Student> studentList);

}
