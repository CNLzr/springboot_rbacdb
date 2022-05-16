package com.lzr.dao;

import com.lzr.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    boolean addUser(User user);
    boolean setUser(User user);
    boolean delUser(User user);
    List<User> getAll();
    User getById(Integer id);
    List<User> getByRoleId(Integer roleId);
    User getByCondition(User user);
}
