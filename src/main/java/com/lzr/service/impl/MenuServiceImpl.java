package com.lzr.service.impl;

import com.lzr.dao.MenuMapper;
import com.lzr.model.Menu;
import com.lzr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public void setMenuMapper(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public boolean addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public boolean setMenu(Menu menu) {
        return menuMapper.setMenu(menu);
    }

    @Override
    public boolean delMenu(Menu menu) {
        return menuMapper.delMenu(menu);
    }

    @Override
    public List<Menu> getAll() {
        return menuMapper.getAll();
    }

    @Override
    public Menu getById(Integer id) {
        return menuMapper.getById(id);
    }

    @Override
    public List<Menu> getByPid(Integer id) {
        return menuMapper.getByPid(id);
    }

    @Override
    public List<Menu> getByRoleId(Integer id) {
        return menuMapper.getByRoleId(id);
    }
}
