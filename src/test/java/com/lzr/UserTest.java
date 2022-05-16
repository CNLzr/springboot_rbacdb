package com.lzr;

import com.lzr.model.User;
import com.lzr.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void getAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        List<User> list = userService.getAll();
        System.out.println(list);
    }

    @Test
    public void getById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    public void getByCondition(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setId(1);
        user.setLoginId("lzr");
        User user2 = userService.getByCondition(user);
        System.out.println(user2);
    }

    @Test
    public void update(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setId(1);
        user.setAddress("lzr");
        boolean flag = userService.setUser(user);
        System.out.println(flag);
    }

}
