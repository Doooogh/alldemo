package com.example.jwtdemo.auth;

import com.example.jwtdemo.dao.*;
import com.example.jwtdemo.entity.SysMenu;
import com.example.jwtdemo.entity.SysPermission;
import com.example.jwtdemo.entity.SysRole;
import com.example.jwtdemo.entity.SysUser;
import com.example.jwtdemo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 19:50
 * @Version 1.0
 **/
@Service
public class CustomizedUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysPermissionDao sysPermissionDao;


    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Autowired
    private SysRolePermissionDao sysRolePermissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser jwtUser=null;

        //TODO 根据用户名从数据库查询该用户
        SysUser sysUser= sysUserDao.findByUsername(username);
        if(null==sysUser){
            return jwtUser;
        }

        //TODO 将该用户的菜单和权限查询出来
        List<SysMenu> menuList=new ArrayList<>();
        List<SysPermission> permissionList=new ArrayList<>();
        List<SysRole> roleList = sysRoleDao.getRoleByUserId(sysUser.getId());
        List<String> roleIds = roleList.stream().map(SysRole::getId).collect(toList());
        for (String roleId : roleIds) {
            List<String> menuIdsByRoleId = sysRoleMenuDao.getMenuIdsByRoleId(roleId);
            List<String> permissionIdsByRoleId = sysRolePermissionDao.getPermissionIdsByRoleId(roleId);
            if(menuIdsByRoleId.size()>0){
                List<SysMenu> menuListTem = sysMenuDao.getListByIds(menuIdsByRoleId);
                menuList.addAll(menuListTem);
            }
            if(permissionIdsByRoleId.size()>0){
                List<SysPermission> permissionListTem = sysPermissionDao.getListByIds(permissionIdsByRoleId);

                permissionList.addAll(permissionListTem);
            }
        }
        Set<SysMenu> menuSet=new HashSet<>(menuList);
        Set<SysPermission> permissionSet=new HashSet<>(permissionList);
        jwtUser=new JwtUser(sysUser,menuSet,permissionSet);
        return jwtUser;
    }
}
