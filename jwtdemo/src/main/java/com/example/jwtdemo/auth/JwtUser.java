package com.example.jwtdemo.auth;

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
    private Set<String> roleNames;


    public JwtUser(SysUser sysUser, Set<String> roleNames) {
        this.sysUser = sysUser;
        this.roleNames = roleNames;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
        for (String roleName : roleNames) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(roleName));
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

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
