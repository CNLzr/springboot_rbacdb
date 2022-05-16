package com.lzr.service;

import com.lzr.model.Menu;

import java.util.List;

public interface MenuService {
    boolean addMenu(Menu menu);
    boolean setMenu(Menu menu);
    boolean delMenu(Menu menu);
    List<Menu> getAll();
    Menu getById(Integer id);
    List<Menu> getByPid(Integer id);
    List<Menu> getByRoleId(Integer id);
}
