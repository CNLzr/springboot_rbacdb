package com.lzr.dao;

import com.lzr.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    boolean addMenu(Menu menu);
    boolean setMenu(Menu menu);
    boolean delMenu(Menu menu);
    List<Menu> getAll();
    Menu getById(Integer id);
    List<Menu> getByPid(Integer id);
    List<Menu> getByRoleId(Integer id);
}
