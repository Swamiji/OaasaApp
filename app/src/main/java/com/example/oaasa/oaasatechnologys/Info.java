package com.example.oaasa.oaasatechnologys;

/**
 * Created by Amit on 7/11/2017.
 */

public class Info {
    private String name,email_id,password,mobile_number;

    public Info(String name, String email_id, String password, String mobile_number) {
        this.name = name;
        this.email_id = email_id;
        this.password = password;
        this.mobile_number = mobile_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}
