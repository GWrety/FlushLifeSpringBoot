package com.example.flushspringboot.Dao;

import com.example.flushspringboot.Utils.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Long> {

    User findByUseremail(String email);
    User findById(Integer id);
}
