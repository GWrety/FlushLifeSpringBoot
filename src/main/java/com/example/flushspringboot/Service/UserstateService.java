package com.example.flushspringboot.Service;

import com.example.flushspringboot.Dao.UserstateDao;
import com.example.flushspringboot.Utils.Userstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserstateService {
    @Autowired
    UserstateDao userstateDao;
    //这里注册的含义为 如果指定了id 就用有的id  如果没有就自增
    //在本项目的环境下，注册时id有user的id指定，但是不存在所以是新增
    //在跟新是，有user id的指定，但是已经存在所以是更新
    public Userstate enrolluserstate(Userstate userstate){
        return userstateDao.save(userstate);
    }

    public Userstate findUserstateById(Integer id){
        return userstateDao.findById(id);
    }
}
