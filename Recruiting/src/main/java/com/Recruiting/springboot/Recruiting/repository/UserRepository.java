package com.Recruiting.springboot.Recruiting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Recruiting.springboot.Recruiting.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findById(long id);
    List<User> findByVorname(String vorname);
    
}