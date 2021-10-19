package com.lin.dao;



import com.lin.pojo.Email;

import java.util.ArrayList;

public interface EmailDao {
    public int xj(Email e);

  public ArrayList<Email> sj();

  public int sc(int id);

   public int hf(int id);

    public int zsc(int id);
}
