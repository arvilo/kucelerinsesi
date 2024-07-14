package az.edu.turing.hackaton.kucelerinsesi.dto.request;

import az.edu.turing.hackaton.kucelerinsesi.model.Gender;
import az.edu.turing.hackaton.kucelerinsesi.model.Species;

import java.util.Date;

public class AdopterRequest {
    private String name;
    private String surname;
    private String mail;
    private String password;
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
