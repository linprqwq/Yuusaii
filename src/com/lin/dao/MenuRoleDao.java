package com.lin.dao;

import com.lin.pojo.MenuRoleInfo;

import java.util.List;

public interface MenuRoleDao {

    /**
     * 根据角色id，删除权限信息
     * @param rid
     * @return
     */
    public int delmrbyrid(int rid);

    /**
     * 根据角色id，查询所有的权限记录
     * @param rid
     * @return
     */
    public List<MenuRoleInfo> querymenurolebyrid(int rid);

    public boolean addauthc(List<MenuRoleInfo> list);


}
