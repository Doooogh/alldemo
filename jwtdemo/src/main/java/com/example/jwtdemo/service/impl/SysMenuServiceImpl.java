package com.example.jwtdemo.service.impl;

import com.example.jwtdemo.dao.SysPermissionDao;
import com.example.jwtdemo.dao.SysRoleDao;
import com.example.jwtdemo.dao.SysRoleMenuDao;
import com.example.jwtdemo.dao.SysRolePermissionDao;
import com.example.jwtdemo.entity.SysPermission;
import com.example.jwtdemo.entity.SysRole;
import com.example.jwtdemo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 11:40
 * @Version 1.0
 **/
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysPermissionDao menuDao;

    @Autowired
    private SysRoleDao roleDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;



    @Override
    public List<SysPermission> getMenuByUserId(String userId) {
        List<SysPermission> menuList=new ArrayList<>();
        List<SysRole> roleList = roleDao.getRoleByUserId(userId);
        for (SysRole sysRole : roleList) {
            List<String> menuIdsByRoleId = sysRoleMenuDao.getMenuIdsByRoleId(sysRole.getId());
            if(menuIdsByRoleId.size()>0){
                List<SysPermission> listByRoleId = menuDao.getListByIds(menuIdsByRoleId);
                menuList.addAll(listByRoleId);
            }
        }
        return menuList;
    }
}
