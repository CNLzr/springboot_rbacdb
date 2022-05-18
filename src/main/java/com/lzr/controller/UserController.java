package com.lzr.controller;

import com.lzr.model.User;
import com.lzr.service.UserService;
import com.lzr.util.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录业务
     * @param request 请求对象
     * @return 成功返回状态码:200,失败返回状态码:400
     */
    @ResponseBody
    @PostMapping(value = "/login")
    public APIResult login(@RequestBody User user, HttpServletRequest request){
        System.out.println(user);
        User user2 = userService.getByCondition(user);
        if(user2 != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",user2);
            return APIResult.success(user2);
        }
        return APIResult.error();
    }

    /**
     * 用户登录页面
     * @return
     */
    @GetMapping(value = "/loginPage")
    public String loginPage(){
        return "/login";
    }

    /**
     * 用户列表页面
     * @return
     */
    @GetMapping(value = "/listPage")
    public String listPage(){
        return "/users/list";
    }

    /**
     * 用户修改页面
     * @return
     */
    @GetMapping(value = "/editPage/{id}")
    public String editPage(@PathVariable("id")Integer id){
        return "/users/edit";
    }

    /**
     * 用户新增页面
     * @return
     */
    @GetMapping(value = "/addPage")
    public String addPage(){
        return "/users/add";
    }

    /**
     * 获取用户列表
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/list")
    public APIResult list(){
        List<User> list = userService.getAll();
        return APIResult.success(list);
    }

    /**
     * 根据Id获取用户
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/user/{id}")
    public User getById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return user;
    }

    /**
     * 新增用户
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/user")
    public APIResult add(@RequestBody User user){
        System.out.println("新增User user=" + user);
        boolean flag = userService.addUser(user);
        if(flag){
            return APIResult.success(user);
        }else {
            return APIResult.error();
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/user/{id}")
    public APIResult delete(@PathVariable("id") Integer id){
        User user = new User();
        user.setId(id);
        userService.delUser(user);
        System.out.println("删除User id=" + id);
        return APIResult.success();
    }

    /**
     * 修改用户
     * @return 修改完成后返回到用户列表页面
     */
    @ResponseBody
    @PutMapping(value = "/user")
    public APIResult edit(@RequestBody User user){
        System.out.println("修改操作...");
        System.out.println(user);
        boolean flag = userService.setUser(user);
        System.out.println("修改User user=" + user);
        if(flag){
            return APIResult.success(user);
        }
        return APIResult.error();
    }
}
