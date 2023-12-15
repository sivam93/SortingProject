package com.example.demo.service;


import com.example.demo.domain.Student;
import com.example.demo.domain.StudentTable;
import com.example.demo.factory.SortingAdapterFactor;
import com.example.demo.repository.StudentRepositoryImpl;
import com.example.demo.view.SortingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@ComponentScan
public class SortService  {

  // private DefaultSortService d;
  @Autowired
  private SortingAdapterFactor sortAdapterFactory;

  @Autowired
  private StudentRepositoryImpl studentRepository;

    public List<Student> studentList;
    public SortService() {

    }


    public List<Student> getAllStudents() {
        List<Student> s =new ArrayList<>();
        Student s1= new Student();
        s1.setId("s");
        s1.setName("sample");
        s1.setPerformance(2.5);
        Student s2= new Student();
        s2.setId("s");
        s2.setName("sample");
        s2.setPerformance(7.5);
        Student s3= new Student();
        s3.setId("s");
        s3.setName("sample");
        s3.setPerformance(6.5);
        s.add(s1);
        s.add(s3);
        s.add(s2);
        SortingTechnique algorithm = sortAdapterFactory.getAdapter(SortingType.mergeSort.name()+"Service");
        return algorithm.sort(s);
       // return s;
    }


    public List<Student> sortAndSave(MultipartFile file, String sortType,boolean save) throws IOException {
     //   List<String[]> csvData = new ObjectMapper().readValue(file.getInputStream(), List.class);

        // Convert CSV data to your desired list format
        List<Student> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma and map to Student object
                String[] tokens = line.split(",");
                Double value = Double.parseDouble(tokens[2]);
                Student student = new Student(tokens[0], tokens[1],value); // Modify based on your data structure
                dataList.add(student);
            }
        }
       studentList= sortAdapterFactory.getAdapter(SortingType.valueOf(sortType).name()+"Service").sort(dataList);
       if(save)writeToFileCSV(studentList);
        return studentList;

    }

    private void writeToFileCSV(List<Student> studentList) {
        try (PrintWriter writer = new PrintWriter(new File("C://Users/Sandhya/Documents/demo/sample.csv"))) {
            writer.println("name,id,perf");
            studentList.stream().map(Student::toString).forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() throws IOException {


        List<Student> s =new ArrayList<>();
        Student s1= new Student();
        s1.setId("s");
        s1.setName("sample");
        s1.setPerformance(2.5);
        Student s2= new Student();
        s2.setId("s");
        s2.setName("sample");
        s2.setPerformance(7.5);
        Student s3= new Student();
        s3.setId("s");
        s3.setName("sample");
        s3.setPerformance(6.5);
        s.add(s1);
        s.add(s3);
        s.add(s2);
       // SortingTechnique algorithm = sortAdapterFactory.getAdapter(SortingType.mergeSort.name()+"Service");

        //String collect = studentList.stream().collect(Collectors.joining(","));

    }

    public List<StudentTable> getAll(){
       return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        //return  ;
    }
}
