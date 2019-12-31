package com.example.app_deepanshu;

public class teachers {

    private String Name;
    private String E_mail;
    private String Mobile;
    private String Address;

    public teachers() {
    }

    public teachers(String name, String e_mail, String mobile, String address) {
        Name = name;
        E_mail = e_mail;
        Mobile = mobile;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
