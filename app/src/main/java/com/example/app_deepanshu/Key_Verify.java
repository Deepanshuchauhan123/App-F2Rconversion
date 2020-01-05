package com.example.app_deepanshu;

public class Key_Verify {

    private Integer school_id;
    private String first_name;

    public Key_Verify(Integer school_id, String first_name) {
        this.school_id = school_id;
        this.first_name = first_name;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
