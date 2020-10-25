package com.hzit.demo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzit.demo.VO.Resp;
import com.hzit.demo.constant.RedisKeyConstant;
import com.hzit.demo.mapper.UserInfoMapper;
import com.hzit.demo.model.UserInfo;
import com.hzit.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo>implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ValueOperations valueOperations;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Resp<UserInfo> select(UserInfo userInfo) {
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.eq("user_name",userInfo.getUserName());
        userInfoQueryWrapper.eq("password",userInfo.getPassword());
        userInfo = userInfoMapper.selectOne(userInfoQueryWrapper);

        Resp<UserInfo> resp = new Resp<>();
        if(userInfo.getId().equals(null)){
            resp.setCode("-1");
            resp.setMsg("请检查用户或者密码是否错误！");
            return resp;
        }else {
//            valueOperations.set(RedisKeyConstant.USER_LOGIN + userInfo.getId() ,userInfo,2, TimeUnit.HOURS);
            redisTemplate.opsForValue().set(RedisKeyConstant.USER_LOGIN + userInfo.getId(), userInfo,2,TimeUnit.HOURS);
            resp.setCode("1");
            resp.setMsg("登录成功！");
            resp.setDate(userInfo);
            return resp;
        }

    }

    @Override
    public Resp<Object> getRedis() {
        Resp<Object> resp = new Resp<>();

        Object userInfo  = valueOperations.get(RedisKeyConstant.USER_LOGIN + "1410080408");


        if(false){
            resp.setCode("-1");
            resp.setMsg("请检查用户或者密码是否错误！");
            return resp;
        }else {

            resp.setCode("1");
            resp.setMsg("登录成功！");
            resp.setDate(userInfo);
            return resp;
        }
    }
    @Override
    public Resp<Object> getRedisTwo() {
        Resp<Object> resp = new Resp<>();

        Object userInfo = redisTemplate.opsForValue().get(RedisKeyConstant.USER_LOGIN + "1410080408");

        System.err.println(userInfo.toString());

        if(false){
            resp.setCode("-1");
            resp.setMsg("请检查用户或者密码是否错误！");
            return resp;
        }else {
            resp.setCode("1");
            resp.setMsg("登录成功！");
            resp.setDate(userInfo);
            return resp;
        }
    }

}
