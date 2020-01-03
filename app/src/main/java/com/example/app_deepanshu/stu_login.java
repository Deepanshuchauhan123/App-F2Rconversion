package com.example.app_deepanshu;

public class stu_login {
    private String key;
    private boolean error;
    private String message;

    public stu_login(String key, boolean error, String message)
    {
        this.key = key;
        this.error = error;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
}
