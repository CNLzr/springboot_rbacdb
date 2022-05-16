package com.lzr.dao;

import com.lzr.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    boolean addRole(Role role);
    boolean addRoleAndMenu(@Param("role_id") Integer role_id, @Param("menu_id") Integer menu_id);
    boolean setRole(Role role);
    boolean delRole(Role role);
    boolean delRoleAndMenu(Integer role_Id);
    List<Role> getAll();
    List<Role> getRoleAndMenu();
    Role getById(Integer id);
}
