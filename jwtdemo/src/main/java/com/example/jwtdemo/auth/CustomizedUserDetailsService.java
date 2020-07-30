package com.example.jwtdemo.auth;

import com.example.jwtdemo.dao.SysMenuDao;
import com.example.jwtdemo.dao.SysPermissionDao;
import com.example.jwtdemo.dao.SysRoleDao;
import com.example.jwtdemo.dao.SysUserDao;
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
        for (SysRole sysRole : roleList) {
            List<SysMenu> menuListTem = sysMenuDao.getListByRoleId(sysRole.getId());
            List<SysPermission> permissionListTem = sysPermissionDao.getListByRoleId(sysRole.getId());
            menuList.addAll(menuListTem);
            permissionList.addAll(permissionListTem);
        }
        Set<SysMenu> menuSet=new HashSet<>(menuList);
        Set<SysPermission> permissionSet=new HashSet<>(permissionList);
        jwtUser=new JwtUser(sysUser,menuSet,permissionSet);
        return jwtUser;
    }
}
