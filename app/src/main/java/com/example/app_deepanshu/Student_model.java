package com.example.app_deepanshu;

public class Student_model {
private String Student_Class;
private String Batch;
private String Student_Name;
private String Student_Adhaar;
private String Stream;
private String Father_Name;

    public Student_model() {
    }

    public Student_model(String student_Class, String batch, String student_Name, String student_Adhaar, String stream, String father_Name) {
        Student_Class = student_Class;
        Batch = batch;
        Student_Name = student_Name;
        Student_Adhaar = student_Adhaar;
        Stream = stream;
        Father_Name = father_Name;
    }

    public String getStudent_Class() {
        return Student_Class;
    }

    public void setStudent_Class(String student_Class) {
        Student_Class = student_Class;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStudent_Adhaar() {
        return Student_Adhaar;
    }

    public void setStudent_Adhaar(String student_Adhaar) {
        Student_Adhaar = student_Adhaar;
    }

    public String getStream() {
        return Stream;
    }

    public void setStream(String stream) {
        Stream = stream;
    }

    public String getFather_Name() {
        return Father_Name;
    }

    public void setFather_Name(String father_Name) {
        Father_Name = father_Name;
    }
}
