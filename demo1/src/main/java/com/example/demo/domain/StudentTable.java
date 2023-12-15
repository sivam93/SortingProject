package com.example.demo.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentTable {

    protected StudentTable(){

    }

    @Id
    private Long id;

    public StudentTable(String ids,String name,Double performance){
        this.ids=ids;
        this.name=name;
        this.performance=performance;
    }


    private String ids;

    private String name;

    private Double performance;
}
