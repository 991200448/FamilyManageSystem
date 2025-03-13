package com.daisypig.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daisypig.auth.dao.UserMapper;
import com.daisypig.auth.service.UserService;

import com.daisypig.common.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}