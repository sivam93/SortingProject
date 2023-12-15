package com.example.demo.service;

import com.example.demo.domain.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ComponentScan
public class MergeSortService implements SortingTechnique {

public MergeSortService(){
}


@Override
public List<Student> sort(List<Student> studentList){

        return mergeSort(studentList);

     /*   Student temp;
        boolean sorted=false;
        while(!sorted){
            sorted=true;
            for(int i=0;i<studentList.size()-1;i++){
                if(studentList.get(i).compareTo(studentList.get(i+1))>0){
                    temp=studentList.get(i);
                    studentList.set(i, studentList.get(i + 1));
                    studentList.set(i + 1, temp);
                    sorted = false;
                }
            }
        }*/
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
    //return  studentList;
}

    private List<Student> mergeSort(List<Student> studentList) {
        if (studentList.size() <= 1) {
            return studentList; // Already sorted
        }

        // Find the middle point
        int middle = studentList.size() / 2;

        // Split the list into two halves
        List<Student> left = new ArrayList<>(studentList.subList(0, middle));
        List<Student> right = new ArrayList<>(studentList.subList(middle, studentList.size()));

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves
        return mergeSortList(left, right);

    }

    private List<Student> mergeSortList(List<Student> left, List<Student> right) {

        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        // Merge the two halves
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getPerformance() <= right.get(j).getPerformance()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Copy the remaining elements of left, if any
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        // Copy the remaining elements of right, if any
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}


