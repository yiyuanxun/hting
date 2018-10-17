package com.accp.pojo;

public class Servicetype {
    private Integer stid;

    private Integer stpid;

    private String stname;

    private Integer sort;

    private Boolean display;

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getStpid() {
        return stpid;
    }

    public void setStpid(Integer stpid) {
        this.stpid = stpid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname == null ? null : stname.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }
}