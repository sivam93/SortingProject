package com.example.demo.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    String name;

    String id;

    Double  performance;

    public Student(String name, String id, Double performance){
        this.name=name;
        this.id=id;
        this.performance=performance;
    }

    public int compareTo(Student z){
        int res=0;
        if(this.performance>z.performance) return 1;
        if(this.performance<z.performance) return -1;

        return res;
    }

    @Override
    public String toString(){
        return String.format("%s,%s,%f", name, id,performance);

    }
}
