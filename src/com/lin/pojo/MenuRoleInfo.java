package com.lin.pojo;

/**
 * 权限表实体类
 */
public class MenuRoleInfo {
    private int id;
    //角色id
    private int rid;
    //菜单id
    private int mid;

    public MenuRoleInfo() {

    }

    public MenuRoleInfo(int rid, int mid) {
        this.rid = rid;
        this.mid = mid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
