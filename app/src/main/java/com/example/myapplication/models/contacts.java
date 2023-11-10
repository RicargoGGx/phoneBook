package com.example.myapplication.models;

import java.io.Serializable;

public class contacts implements Serializable {
    private String name;
    private String tel;
    private String birth;
    private String institution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public contacts(String name, String tel, String birth, String institution) {
        this.name = name;
        this.tel = tel;
        this.birth = birth;
        this.institution = institution;
    }
}
