package com.lin.service.impl;

import com.lin.dao.UserDao;
import com.lin.dao.impl.UserDaoImpl;
import com.lin.pojo.PageInfo;
import com.lin.pojo.UserInfo;
import com.lin.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao =new UserDaoImpl();


    @Override
    public UserInfo queryuserbyloginnameandpwd(UserInfo userInfo) {
        return userDao.queryuserbyloginnameandpwd(userInfo);
    }



    public PageInfo<UserInfo> selm(UserInfo r, int pagenum, int pagesize){
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>();


        pageInfo.setRows(userDao.selectservlet(r,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = userDao.querynewstypecountbycond(r);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(r);
        return pageInfo;
    }


    public boolean ad(UserInfo r){
        return userDao.add(r)== 1 ? true : false;
    }

    public UserInfo selById(int id){
        return userDao.selectByid(id);
    }

    @Override
    public boolean xg(UserInfo r) {
        return userDao.xg(r)== 1 ? true : false;
    }

    public boolean del(int id){
        return userDao.del(id)== 1 ? true : false;
    }
}
