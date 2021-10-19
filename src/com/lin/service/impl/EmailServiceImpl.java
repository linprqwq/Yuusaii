package com.lin.service.impl;

import com.lin.dao.EmailDao;
import com.lin.dao.impl.EmailDaoImpl;
import com.lin.pojo.Email;
import com.lin.service.EmailService;

import java.util.ArrayList;

public class EmailServiceImpl implements EmailService {
    EmailDao d=new EmailDaoImpl();
    @Override
    public boolean xj(Email e){
        return d.xj(e)==1 ? true:false;
    }
    public ArrayList<Email> sj(){
        return d.sj();
    }

    @Override
    public boolean sc(int id) {
        return d.sc(id)==1? true:false;
    }

    @Override
    public boolean hf(int id) {
        return d.hf(id)==1? true:false;
    }

    @Override
    public boolean zsc(int id) {
        return d.zsc(id)==1? true:false;
    }


}
