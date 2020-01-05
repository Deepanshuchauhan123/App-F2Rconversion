package com.example.app_deepanshu;

public class Subject {

    private String title;
    private Integer id;
    private int std;

    public Subject(String name, int std, Integer id) {

        this.title = name;
        this.std = std;
        this.id = id;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public int getStd() { return std; }
    public String getTitle() {
        return title;
    }
    public int getId() {
        return id;
    }
}
