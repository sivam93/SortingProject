package com.example.demo.controller;


import com.example.demo.domain.Student;
import com.example.demo.service.SortService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@ComponentScan
@RestController
@CrossOrigin
public class StudentsController {


    private final SortService sortService;


    public StudentsController(SortService sortService) {
        this.sortService = sortService;
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return sortService.getAllStudents();
    }

    @PostMapping("/upload-sort")
    public List<Student> sortAndSave(@RequestBody MultipartFile file, @RequestParam("sortType") @DefaultValue("defaultSort") String sortType, @RequestParam("save") boolean save) throws IOException {
        return sortService.sortAndSave(file, sortType, save);
    }

    @PostMapping("/write-to-file")
    public void writeToFile() throws IOException {
        sortService.writeToFile();
    }


}
