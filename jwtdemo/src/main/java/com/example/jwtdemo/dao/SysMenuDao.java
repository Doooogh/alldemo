package com.example.jwtdemo.dao;

import com.example.jwtdemo.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 16:49
 * @Version 1.0
 **/
public interface SysMenuDao {

    List<SysMenu> getList();

    List<SysMenu> getListByIds(@Param("ids") List<String> ids);
}
