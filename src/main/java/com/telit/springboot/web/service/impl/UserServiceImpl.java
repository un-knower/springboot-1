package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.UserDao;
import com.telit.springboot.web.model.TelitUser;
import com.telit.springboot.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<TelitUser,Long> implements UserService {
    @Autowired
    private UserDao userDao;

    @Resource(name="userDao")
    public void setBaseDao(UserDao userDao){
        super.setBaseDao(userDao);
    }
}
