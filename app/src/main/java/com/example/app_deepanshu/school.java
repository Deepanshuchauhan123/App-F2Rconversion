package com.example.app_deepanshu;

public class school {
    private String  E_mail,School_name,Board_Of_School,School_Verify_Key,Mobile,Address,State;


    public school()
    {

    }

//    @Override
//    public String toString() {
//        return "school{" +
//                "E_mail='" + E_mail + '\'' +
//                ", School_name='" + School_name + '\'' +
//                ", Board_Of_School='" + Board_Of_School + '\'' +
//                ", School_Verify_Key='" + School_Verify_Key + '\'' +
//                ", Mobile='" + Mobile + '\'' +
//                ", Address='" + Address + '\'' +
//                ", State='" + State + '\'' +
//                '}';
//    }

    public school(String e_mail, String school_name, String board,
                  String key, String teach_mobile, String address, String teach_state)
    {
        this.E_mail = e_mail;
        this.School_name = school_name;
        this.Board_Of_School = board;
        this.School_Verify_Key = key;
        this.Mobile = teach_mobile;
        this.Address = address;
        this.State = teach_state;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getSchool_name() {
        return School_name;
    }

    public void setSchool_name(String school_name) {
        School_name = school_name;
    }

    public String getBoard_Of_School() {
        return Board_Of_School;
    }

    public void setBoard_Of_School(String board_Of_School) {
        Board_Of_School = board_Of_School;
    }

    public String getSchool_Verify_Key() {
        return School_Verify_Key;
    }

    public void setSchool_Verify_Key(String school_Verify_Key) {
        School_Verify_Key = school_Verify_Key;
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

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
