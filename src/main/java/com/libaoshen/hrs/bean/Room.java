package com.libaoshen.hrs.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Room {
    private Integer roomid;
    @NotNull(message="����������Ϊ��")
    @Size(min=3,max=10,message="������������3��20��֮��")
    private String roomname;
    @NotNull(message="����������Ϊ��")
    @Size(min=3,max=10,message="������������3��20��֮��")
    private String bedtype;
    @NotNull(message="ͼƬ��Ϣ����Ϊ��")
    private String imginfo;
    @NotNull(message="������Ϣ����Ϊ��")
    @Size(max=100,message="������Ϣ����������100��")
    private String description;
    @DecimalMax(value="999999",message="���ֱ���С��999999")
    private Float roomprice;
    
    private Integer roomleftnum;
    @DecimalMax(value="9999",message="���ֱ���С��9999")
    private Integer roomtotalnum;

    private Boolean hasbroadband;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype == null ? null : bedtype.trim();
    }

    public String getImginfo() {
        return imginfo;
    }

    public void setImginfo(String imginfo) {
        this.imginfo = imginfo == null ? null : imginfo.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(Float roomprice) {
        this.roomprice = roomprice;
    }

    public Integer getRoomleftnum() {
        return roomleftnum;
    }

    public void setRoomleftnum(Integer roomleftnum) {
        this.roomleftnum = roomleftnum;
    }

    public Integer getRoomtotalnum() {
        return roomtotalnum;
    }

    public void setRoomtotalnum(Integer roomtotalnum) {
        this.roomtotalnum = roomtotalnum;
    }

    public Boolean getHasbroadband() {
        return hasbroadband;
    }

    public void setHasbroadband(Boolean hasbroadband) {
        this.hasbroadband = hasbroadband;
    }
}