package com.example.flushspringboot.Controller;

import com.example.flushspringboot.Service.UserstateService;
import com.example.flushspringboot.Utils.Result;
import com.example.flushspringboot.Utils.User;
import com.example.flushspringboot.Utils.Userstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserstateConroller {
    @Autowired
    UserstateService userstateService;

    //请求使用时间
    @ResponseBody
    @RequestMapping("/getEnrollTime")
    Result getEnrollTime(User user){
        Userstate userstate=userstateService.findUserstateById(user.getId());
        Result result=new Result(200);
        result.setData(userstate.getEnrolltime());
        return result;
    }


    //请求感受记录
    @ResponseBody
    @RequestMapping("/getFeelTimes")
    Result getFeelTimes(User user){
        Userstate userstate=userstateService.findUserstateById(user.getId());
        Result result=new Result(200);
        result.setData(userstate.getFeeltimes());
        return result;
    }

    //请求呼吸训练
    @ResponseBody
    @RequestMapping("/getBreatheTimes")
    Result getBreatheTimes(User user){
        Userstate userstate=userstateService.findUserstateById(user.getId());
        Result result=new Result(200);
        result.setData(userstate.getBreathetimes());
        return result;
    }


    //增加呼吸训练
    @ResponseBody
    @RequestMapping("/addBreatheTimes")
    Result addBreatheTimes(User user){
        Userstate userstate=userstateService.findUserstateById(user.getId());
        userstate.setBreathetimes(userstate.getBreathetimes()+1);
        userstateService.enrolluserstate(userstate);
        //        result.setData(userstate.getBreathetimes());
        return new Result(200);
    }

    //增加感受记录
    @ResponseBody
    @RequestMapping("/addFeelTimes")
    Result addFeelTimes(User user){
        Userstate userstate=userstateService.findUserstateById(user.getId());
        userstate.setBreathetimes(userstate.getBreathetimes()+1);
        userstateService.enrolluserstate(userstate);
        return new Result(200);
    }

}
