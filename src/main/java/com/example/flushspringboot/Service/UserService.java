package com.example.flushspringboot.Service;

import com.example.flushspringboot.Utils.User;
import com.example.flushspringboot.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;



    public User enrollUser(User user) {
        return userDao.save(user);
    }
    public  User findUserByEmail(String email){
        return userDao.findByUseremail(email);
    }

    public  User findUserById(Integer id){
        return userDao.findById(id);
    }
}
