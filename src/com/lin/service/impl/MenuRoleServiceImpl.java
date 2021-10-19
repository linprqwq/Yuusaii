package com.lin.service.impl;

import com.lin.dao.MenuRoleDao;
import com.lin.dao.impl.MenuRoleDaoImpl;
import com.lin.pojo.MenuRoleInfo;
import com.lin.service.MenuRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuRoleServiceImpl implements MenuRoleService {
    MenuRoleDao menuRoleDao = new MenuRoleDaoImpl();

    @Override
    public boolean setauthc(Map<String, String[]> map) {

        int rid = Integer.parseInt(map.get("rid")[0]);

        String[] mids = map.get("mid");

        //组装权限表数据  多条  放入集合中
        List<MenuRoleInfo> list = new ArrayList<MenuRoleInfo>();
        for (String mid : mids){
            //循环每一个菜单id，组装一个权限表数据
            MenuRoleInfo menuRoleInfo = new MenuRoleInfo(rid,
                    Integer.parseInt(mid));
            list.add(menuRoleInfo);
        }

        //防止权限表有重复数据，先根据角色id，将
        //权限表中相同角色id的数据全部删除，然后在批量添加
        menuRoleDao.delmrbyrid(rid);


        //批量操作  dao.add(List<MenuRoleInfo>  list)
        boolean res = menuRoleDao.addauthc(list);


        return res;
    }
}
