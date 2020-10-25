package com.hzit.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzit.demo.VO.Resp;
import com.hzit.demo.model.UserInfo;

public interface UserInfoService extends IService<UserInfo> {
    Resp<UserInfo> select(UserInfo userInfo);
    Resp<Object> getRedis();
    Resp<Object> getRedisTwo();
}
