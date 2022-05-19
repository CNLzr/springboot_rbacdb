package com.lzr.controller;

import com.lzr.model.Menu;
import com.lzr.model.Role;
import com.lzr.model.User;
import com.lzr.service.MenuService;
import com.lzr.service.RoleService;
import com.lzr.service.UserService;
import com.lzr.util.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    /**
     * 角色修改页面
     * @return 转发到对应的角色列表静态html资源文件
     */
    @GetMapping(value = "/editPage/{id}")
    public String editPage(@PathVariable Integer id){
        return "/roles/edit";
    }

    /**
     * 角色列表页面
     * @return 转发到对应的角色列表静态html资源文件
     */
    @GetMapping(value = "/listPage")
    public String listPage(){
        return "/roles/list";
    }

    /**
     * 角色新增页面
     * @return 转发到对应的角色列表静态html资源文件
     */
    @GetMapping(value = "/addPage")
    public String addPage(){
        return "/roles/add";
    }

    /**
     * 角色修改业务
     * @param role
     * @return 重定向到角色列表页面
     */
    @ResponseBody
    @PutMapping(value = "/role")
    public APIResult edit(@RequestBody Role role){
        System.out.println(role);
        boolean flag = roleService.setRole(role);
        if(flag){
            return APIResult.success(role);
        }
        return APIResult.error();
    }

    /**
     * 角色删除业务
     *  注：此业务需注意是否有关联的用户与权限
     * @param id 前端传入的id值参数
     * @return 删除成功，客户端重定向到角色列表页面
     */
    @DeleteMapping(value = "/role/{id}")
    public APIResult del(@PathVariable("id") Integer id){
        List<User> list = userService.getByRoleId(id);
        System.out.println(list);
        if(!list.isEmpty()){
            System.out.println("此角色已有所属用户.");
            return APIResult.error();
        }
        Role role = new Role();
        role.setId(id);
//        roleService.delRole(role);
        System.out.println("删除Role，id=" + id);
        return APIResult.success();
    }

    /**
     * 角色新增业务
     * @param role 前端传入的参数包装的对象
     * @return 新增成功，客户端重定向到角色列表页面
     */
    @PostMapping(value = "/role")
    @ResponseBody
    public APIResult add(Role role){
        System.out.println("新增Role,Role="+role);
        boolean flag = roleService.addRole(role);
        if(flag){
            return APIResult.success(role);
        }
        return APIResult.error();
    }

    /**
     * 获取角色列表
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/list")
    public APIResult list(){
        List<Role> list = roleService.getAll();
        return APIResult.success(list);
    }

    /**
     * 根据Id获取角色业务
     * @param id
     * @return
     */
    @GetMapping(value = "/role/{id}")
    @ResponseBody
    public APIResult getById(@PathVariable("id") Integer id){
        System.out.println("根据Id获取Role,id="+id);
        Role role = roleService.getById(id);
        return APIResult.success(role);
    }

    /**
     * 修改角色菜单权限业务
     * 方案一：
     *  先接收前端传入的角色id和菜单ids
     *  再删除对应角色的菜单权限
     *  再插入传入的菜单ids
     * @return
     */
    @ResponseBody
    @PutMapping(value = "/role_menu")
    public APIResult editRoleAndMenu(@RequestParam("role_id") Integer role_id,@RequestParam("menu_ids") List<Integer> menu_ids){
        List<Menu> role_menus = menuService.getByRoleId(role_id);
        System.out.println(menu_ids);
        boolean flag = roleService.setRoleAndMenu(role_id, menu_ids);
        // 修改后再查询一次对应角色的权限
        role_menus = menuService.getByRoleId(role_id);
        return APIResult.success(role_menus);
    }

    @ResponseBody
    @DeleteMapping(value = "/role_menu/{role_id}")
    public APIResult deleteRoleAndMenu(@PathVariable("role_id") Integer role_id){
        boolean flag = roleService.delRoleAndMenu(role_id);
        return APIResult.success(flag);
    }

}
