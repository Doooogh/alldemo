package com.example.jwtdemo.auth.impl;

import com.example.jwtdemo.auth.DynamicSecurityService;
import com.example.jwtdemo.dao.SysPermissionDao;
import com.example.jwtdemo.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 21:57
 * @Version 1.0
 **/
@Configuration
public class DynamicSecurityServiceImpl implements DynamicSecurityService {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public Map<String, ConfigAttribute> loadDataSource() {
        List<SysPermission> list = sysPermissionDao.getList();
        Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
        for (SysPermission sysPermission : list) {
            map.put(sysPermission.getPath(),new SecurityConfig(sysPermission.getPermission()));
        }
        return map;
    }
}
