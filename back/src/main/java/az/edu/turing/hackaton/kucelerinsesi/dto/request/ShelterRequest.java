package az.edu.turing.hackaton.kucelerinsesi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShelterRequest {

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("password")
    private String password;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("description")
    private String description;


    @Override
    public String toString() {
        return "ShelterRequest{" +
                "companyName='" + companyName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
