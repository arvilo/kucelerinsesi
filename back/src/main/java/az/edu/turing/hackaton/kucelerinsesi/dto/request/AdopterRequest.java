package az.edu.turing.hackaton.kucelerinsesi.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AdopterRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("email")
    private String mail;

    @JsonProperty("password")
    private String password;

    @JsonProperty("birth")
    private String birth; // DD/MM/YYYY

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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
