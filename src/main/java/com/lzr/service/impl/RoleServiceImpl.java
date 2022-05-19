package com.lzr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzr.dao.RoleMapper;
import com.lzr.model.Role;
import com.lzr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public boolean addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public boolean setRoleAndMenu(Integer role_id, List<Integer> menu_ids) {
        roleMapper.delRoleAndMenu(role_id);
        boolean set_flag = true;
        for (Integer menu_id : menu_ids) {
            boolean add_flag = roleMapper.addRoleAndMenu(role_id, menu_id);
            if(!add_flag){
                set_flag = false;
            }
        }
        return set_flag;
    }

    @Override
    public boolean setRole(Role role) {
        return roleMapper.setRole(role);
    }

    @Override
    public boolean delRole(Role role) {
        return roleMapper.delRole(role);
    }

    @Override
    public boolean delRoleAndMenu(Integer role_Id) {
        return roleMapper.delRoleAndMenu(role_Id);
    }

    @Transactional(readOnly =true)
    @Override
    public PageInfo<Role> getAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> list = roleMapper.getAll();
        PageInfo<Role> page_list = new PageInfo<Role>(list);
        return page_list;
    }

    @Override
    public List<Role> getByCondition(Role role) {
        List<Role> list = roleMapper.getByCondition(role);
        return list;
    }

    @Override
    public List<Role> getRoleAndMenu() {
        return roleMapper.getRoleAndMenu();
    }

    @Override
    public Role getById(Integer id) {
        return roleMapper.getById(id);
    }

}
