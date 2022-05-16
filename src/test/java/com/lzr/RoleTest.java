package com.lzr;

import com.lzr.model.Role;
import com.lzr.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RoleTest {

    @Test
    public void testGetAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = context.getBean("roleService", RoleService.class);
        System.out.println(roleService);
        List<Role> list = roleService.getAll();
        System.out.println(list);
    }

    @Test
    public void testGetById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = context.getBean("roleService", RoleService.class);
        System.out.println(roleService);
        Role role = roleService.getById(1);
        System.out.println(role);
    }

    @Test
    public void testGetRoleAndMenu() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = context.getBean("roleService", RoleService.class);
        List<Role> list = roleService.getRoleAndMenu();
        for (Role role : list) {
            System.out.println(role);
        }
    }

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = context.getBean("roleService", RoleService.class);
        List<Role> list = roleService.getAll();
        System.out.println(list);
    }
    @Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = context.getBean("roleService", RoleService.class);
        List<Role> list = roleService.getAll();
        System.out.println(list);
    }
    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = context.getBean("roleService", RoleService.class);
        List<Role> list = roleService.getAll();
        System.out.println(list);
    }
}
