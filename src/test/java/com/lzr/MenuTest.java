package com.lzr;

import com.lzr.model.Menu;
import com.lzr.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void testGetAll(){
        List<Menu> list = menuService.getAll();
        System.out.println(list);
    }

    @Test
    public void testGetByPid(){
        List<Menu> list = menuService.getByPid(1);
        System.out.println(list);
    }

    @Test
    public void testGetByRoleId(){
        List<Menu> list = menuService.getByRoleId(1);
        System.out.println(list);
    }

}
