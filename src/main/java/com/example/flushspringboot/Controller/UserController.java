package com.example.flushspringboot.Controller;

import com.example.flushspringboot.Service.UserstateService;
import com.example.flushspringboot.Utils.Result;
import com.example.flushspringboot.Service.UserService;

import com.example.flushspringboot.Utils.User;
import com.example.flushspringboot.Utils.Userstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserstateService userstateService;
    /**
     * 注册用户
     * @author Wayland
     *
     * @return code=0  empty value
     *         code=100 email has been enrolled
     *         code=200 success
    */
    //注册用户与用户状态
    @RequestMapping("/enroll")
    @ResponseBody
    Result enrollUser(User user) throws ParseException {

        //判断账号注册条件
        if(Objects.equals(user.getUsername(), "") || Objects.equals(user.getUseremail(), "")|| Objects.equals(user.getUserpassword(), "")){
            return  new Result(0);
        }
        else if (userService.findUserByEmail(user.getUseremail())!=null){
            return  new Result(100);
        }
        //注册账号 初始化头像
        user.setUserpicture("https://profile.csdnimg.cn/7/9/8/1_flawless22222");
        User tempuser = userService.enrollUser(user);

        //添加账号使用情况
        Userstate userstate =new  Userstate();
        userstate.setId(tempuser.getId());
        Date date=new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        userstate.setEnrolltime(sqlDate);
        userstate.setFeeltimes(0);
        userstate.setBreathetimes(0);
        userstateService.enrolluserstate(userstate);
        return  new Result(200);
    }

    //登录用户
    @RequestMapping("/login")
    @ResponseBody
    Result LoginUser(User user) throws ParseException{
        User user1= userService.findUserByEmail(user.getUseremail());
        if(user1!=null&& Objects.equals(user1.getUserpassword(), user.getUserpassword())){
            Result  result =new Result(200);
            result.setData(user1);
            return  result;
        }
        else
            return new Result(0);
    }


    //找回密码
    @RequestMapping("/findPassword")
    @ResponseBody
    Result findPassword(User user) throws ParseException{
        User user1= userService.findUserByEmail(user.getUseremail());
        if(user1!=null&& Objects.equals(user1.getUsername(), user.getUsername())){
            Result  result =new Result(200);
            result.setData(user1.getUserpassword());
            return  result;
        }
        else
            return new Result(0);
    }

    //请求头像
    @RequestMapping("/getPicture")
    @ResponseBody
    Result getPicture(User user) {
        User user1= userService.findUserById(user.getId());
        if(user1!=null){
            Result  result =new Result(200);
            result.setData(user1.getUserpicture());
            return  result;
        }
        else
            return new Result(0);
    }

    //更换头像
    //收藏文章
    //反馈





}
