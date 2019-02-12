package com.xiaojiu.annotation.annotationdemo.middledemo;

public class PersonBean extends BaseBean {

    public PersonBean() {
        verification();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @ParamsRequired
    public String userName;
    @ParamsRequired
    public String passWord;
    @ParamsRequired
    public int phoneNumber;
}
