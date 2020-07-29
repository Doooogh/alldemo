package com.example.jwtdemo.auth;

import com.example.jwtdemo.dao.SysUserDao;
import com.example.jwtdemo.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser jwtUser=null;

        //TODO 根据用户名从数据库查询该用户
        SysUser sysUser= sysUserDao.findByUsername(username);
        if(null==sysUser){
            return jwtUser;
        }

        Set<String> roleNames=new HashSet<>();
       /* SysUser sysUser1 = sysUserDao.findByUsername(username);

        if(null!=sysUser1){
            //TODO 将该用户的权限查询出来  赋值给roleNames
        }*/
        roleNames.add("USER");
        jwtUser=new JwtUser(sysUser,roleNames);
        return jwtUser;
    }
}
