package com.lin.pojo;

import java.util.List;

public class MenuInfo {
    private int id;
    private String name;
    //父节点id
    private String parentid;
    //节点类型 1：根节点  2：子节点
    private int nodetype;
    //菜单跳转地址
    private String linkurl;

    private int isdelete;

    //如果是父节点  他的下面肯定有很多子节点
    List<MenuInfo>  childmenus;
    boolean ischecked;
    private boolean ischeck;

    public boolean isIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public List<MenuInfo> getChildmenus() {
        return childmenus;
    }

    public void setChildmenus(List<MenuInfo> childmenus) {
        this.childmenus = childmenus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public int getNodetype() {
        return nodetype;
    }

    public void setNodetype(int nodetype) {
        this.nodetype = nodetype;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }
}
