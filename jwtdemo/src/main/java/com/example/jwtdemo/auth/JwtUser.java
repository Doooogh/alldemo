package com.example.jwtdemo.auth;

import com.example.jwtdemo.entity.SysPermission;
import com.example.jwtdemo.entity.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/28 19:34
 * @Version 1.0
 **/
@Data
public class JwtUser implements UserDetails {

    private SysUser sysUser;
    private Set<SysPermission> permissionList;


    public JwtUser(SysUser sysUser, Set<SysPermission> roleNames) {
        this.sysUser = sysUser;
        this.permissionList = roleNames;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
        for (SysPermission menu : permissionList) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(menu.getPermission()));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    //是否已过期
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    //是否已锁定
    @Override
    public boolean isAccountNonLocked() {
        if(sysUser.getLocked()==1){
            return true;
        }
        return false;
    }

    //凭证是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //是否可用
    @Override
    public boolean isEnabled() {
        if(sysUser.getDisabled()==1){
            return true;
        }
        return false;
    }
}
