package com.nbt.repair.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nbt.repair.entity.User;
import com.nbt.repair.mapper.UserMapper;
import com.nbt.repair.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}