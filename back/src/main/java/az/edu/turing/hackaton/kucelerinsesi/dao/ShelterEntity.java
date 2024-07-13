package az.edu.turing.hackaton.kucelerinsesi.dao;

import java.io.Serializable;

public class ShelterEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String companyName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String description;
    private String workHours;

    public ShelterEntity() {
    }

    public ShelterEntity(String companyName, String email, String password, String address, String phoneNumber, String description, String workHours) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.workHours = workHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }
}
