package com.example.app_deepanshu;

public class StudentLoginResponse {

    private boolean error;
    private String message;
    private student user;
    private int id;
    private String adhaar;
    private String token;

    public StudentLoginResponse(boolean error, String message, student user, int id, String adhaar, String token) {
        this.error = error;
        this.message = message;
        this.user = user;
        this.id = id;
        this.adhaar = adhaar;
        this.token = token;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public student getUser() {
        return user;
    }

    public void setUser(student user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
