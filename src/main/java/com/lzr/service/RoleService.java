package com.lzr.service;

import com.lzr.model.Role;

import java.util.List;

public interface RoleService {
    boolean addRole(Role role);
    boolean setRoleAndMenu(Integer role_id, List<Integer> menu_ids);
    boolean setRole(Role role);
    boolean delRole(Role role);
    boolean delRoleAndMenu(Integer role_Id);
    List<Role> getAll();
    List<Role> getRoleAndMenu();
    Role getById(Integer id);
}
