package com.example.demo.service;

import com.example.demo.domain.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan
public class DefaultSortService implements SortingTechnique {

    public DefaultSortService() {
    }

   /* List<Student> bubbleSort(List<Student> studentList) {
        int size = studentList.size();
        int end = size;

        Student temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < studentList.size() - 1; i++) {
                if (studentList.get(i).compareTo(studentList.get(i + 1)) > 0) {
                    temp = studentList.get(i);
                    studentList.set(i, studentList.get(i + 1));
                    studentList.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
     *//*  for(int i=0;i<end-1;i++){
            sorted=false;
            for(int j=1;j<end-i-1;j++){

                if(studentList.get(j).compareTo(studentList.get(j+1))>0){
                Student temp=studentList.get(j);
                studentList.set(j,studentList.get(j+1));
                studentList.set(j+1,temp);
                sorted=true;
                }
            }
            if(sorted)break;
        }*//*
        return studentList;
    }*/

    @Override
    public List<Student> sort(List<Student> studentList) {
        int size = studentList.size();
        int end = size;

        Student temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < studentList.size() - 1; i++) {
                if (studentList.get(i).compareTo(studentList.get(i + 1)) > 0) {
                    temp = studentList.get(i);
                    studentList.set(i, studentList.get(i + 1));
                    studentList.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
     /*  for(int i=0;i<end-1;i++){
            sorted=false;
            for(int j=1;j<end-i-1;j++){

                if(studentList.get(j).compareTo(studentList.get(j+1))>0){
                Student temp=studentList.get(j);
                studentList.set(j,studentList.get(j+1));
                studentList.set(j+1,temp);
                sorted=true;
                }
            }
            if(sorted)break;
        }*/
        return studentList;
    }
}


