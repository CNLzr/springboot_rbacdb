package com.lzr.controller;

import com.lzr.model.Menu;
import com.lzr.service.MenuService;
import com.lzr.util.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/listPage")
    public String listPage(){
        return "/menus/list";
    }

    /**
     * 获取菜单列表
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public APIResult list(){
        List<Menu> list = menuService.getAll();
        return APIResult.success(list);
    }

    /**
     * 根据Id获取菜单
     * @param id 菜单主键Id
     * @return
     */
    @ResponseBody
    @GetMapping("/menu/{id}")
    public APIResult getById(@PathVariable("id") Integer id){
        Menu menu = menuService.getById(id);
        return APIResult.success(menu);
    }

    /**
     * 根据父级菜单Id获取所有子菜单
     * @param pid 父级菜单Id
     * @return
     */
    @ResponseBody
    @GetMapping("/pmenu/{pid}")
    public APIResult getByPid(@PathVariable("pid") Integer pid){
        List<Menu> list = menuService.getByPid(pid);
        return APIResult.success(list);
    }




}
