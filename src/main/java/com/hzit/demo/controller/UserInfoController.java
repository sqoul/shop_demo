package com.hzit.demo.controller;

import com.hzit.demo.VO.Resp;
import com.hzit.demo.model.UserInfo;
import com.hzit.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.sampled.Line;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/login")
    @ResponseBody
    public  Resp login(@RequestParam("userName") String userName,@RequestParam("password") String password){

        logger.info("=========================userName"+userName+";password"+password);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);

        Resp<UserInfo> resp = new Resp<>();

        try{
            resp = userInfoService.select(userInfo);
            return resp;
        }catch (Exception e){
            logger.error("Exception",e);
            resp.setCode("-1");
            resp.setMsg("系统繁忙！");
            return resp;
        }
    }
    @RequestMapping("/get")
    @ResponseBody
    public Resp get(){
        Resp<Object> resp = new Resp<>();
        try{
            resp = userInfoService.getRedis();
            return resp;
        }catch (Exception e){
            logger.error("Exception",e);
            resp.setCode("-1");
            resp.setMsg("系统繁忙！");
            return resp;
        }
    }

    @RequestMapping("/get1")
    @ResponseBody
    public Resp get1(){
        Resp<Object> resp = new Resp<>();
        try{
            resp = userInfoService.getRedisTwo();
            return resp;
        }catch (Exception e){
            logger.error("Exception",e);
            resp.setCode("-1");
            resp.setMsg("系统繁忙！");
            return resp;
        }
    }
}
