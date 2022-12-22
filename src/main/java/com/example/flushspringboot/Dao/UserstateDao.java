package com.example.flushspringboot.Dao;


import com.example.flushspringboot.Utils.Userstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserstateDao extends JpaRepository<Userstate,Long> {

    Userstate findById(Integer id);

}
