package com.pku.domain;

import java.io.Serializable;

public class UserInfo implements Serializable {
    /*
       userId               int not null,
   userName             varchar(30),
   name                 varchar(30),
   password             varchar(30),
   email                varchar(30),
   phone                varchar(11),
   locked               int,
   sendAddress0         varchar(100),
   sendAddress1         varchar(100),
   sendAddress2         varchar(100),
   def0                 varchar(100),
   def1                 varchar(100),
   def2                 varchar(100),
   registerTime         varchar(100),
   primary key (userId)
    */

    private static final long serialVersionUID = 8809101560720973267L;
    public int userId ;
    public String userName ;
    public String name ;
    public String password ;
    public String email ;
    public String phone ;
    public int locked ;
    public String sendAddress0 ;
    public String sendAddress1 ;
    public String sendAddress2 ;
    public String def0 ;
    public String def1 ;
    public String def2 ;
    public String registerTime ;
    public String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public String getSendAddress0() {
        return sendAddress0;
    }

    public void setSendAddress0(String sendAddress0) {
        this.sendAddress0 = sendAddress0;
    }

    public String getSendAddress1() {
        return sendAddress1;
    }

    public void setSendAddress1(String sendAddress1) {
        this.sendAddress1 = sendAddress1;
    }

    public String getSendAddress2() {
        return sendAddress2;
    }

    public void setSendAddress2(String sendAddress2) {
        this.sendAddress2 = sendAddress2;
    }

    public String getDef0() {
        return def0;
    }

    public void setDef0(String def0) {
        this.def0 = def0;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
}
