package com.lzr.service;

import com.github.pagehelper.PageInfo;
import com.lzr.model.Role;

import java.util.List;

public interface RoleService {
    boolean addRole(Role role);
    boolean setRoleAndMenu(Integer role_id, List<Integer> menu_ids);
    boolean setRole(Role role);
    boolean delRole(Role role);
    boolean delRoleAndMenu(Integer role_Id);
    PageInfo<Role> getAll(Integer pageNum,Integer pageSize);
    List<Role> getByCondition(Role role);
    List<Role> getRoleAndMenu();
    Role getById(Integer id);
}
