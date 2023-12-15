package com.example.demo.repository;


import com.example.demo.domain.StudentTable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<StudentTable> findByLastName(String name) {
        return null;
    }

    @Override
    public StudentTable findById(long id) {
        return null;
    }


    @Override
    public <S extends StudentTable> S save(S entity) {
        return null;
    }

    @Override
    public <S extends StudentTable> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<StudentTable> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<StudentTable> findAll() {
        return findAll();
    }

    @Override
    public Iterable<StudentTable> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(StudentTable entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends StudentTable> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
