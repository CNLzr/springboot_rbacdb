package com.lzr.service;

import com.lzr.model.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean setUser(User user);
    boolean delUser(User user);
    List<User> getAll();
    User getById(Integer id);
    List<User> getByRoleId(Integer roleId);
    User getByCondition(User user);
}
