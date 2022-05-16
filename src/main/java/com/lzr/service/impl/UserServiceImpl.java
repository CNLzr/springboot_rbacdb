package com.lzr.service.impl;

import com.lzr.dao.UserMapper;
import com.lzr.model.User;
import com.lzr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean setUser(User user) {
        return userMapper.setUser(user);
    }

    @Override
    public boolean delUser(User user) {
        return userMapper.delUser(user);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> getByRoleId(Integer roleId) {
        return userMapper.getByRoleId(roleId);
    }

    @Override
    public User getByCondition(User user) {
        return userMapper.getByCondition(user);
    }
}
