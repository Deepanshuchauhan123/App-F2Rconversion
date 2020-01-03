package com.example.app_deepanshu;

public class student {
    public String  E_mail,Name,Guardian_Name,student_adhaar,father_adhaar,Father_mobile,student_add,student_state;

    public student(){

    }

    public student(String student_email,String student_name,String student_parents,
                   String student_adhaar,String father_adhaar,String student_mobile,String student_add,String student_state) {
        this.E_mail = student_email;
        this.Name = student_name;
        this.Guardian_Name = student_parents;
        this.student_adhaar = student_adhaar;
        this.father_adhaar = father_adhaar;
        this.Father_mobile = student_mobile;
        this.student_add=student_add;
        this.student_state=student_state;
    }

    public String getE_mail() {
        return E_mail;
    }

    public String getName() {
        return Name;
    }

    public String getGuardian_Name() {
        return Guardian_Name;
    }

    public String getStudent_adhaar() {
        return student_adhaar;
    }

    public String getFather_adhaar() {
        return father_adhaar;
    }

    public String getFather_mobile() {
        return Father_mobile;
    }

    public String getStudent_add() {
        return student_add;
    }

    public String getStudent_state() {
        return student_state;
    }
}
