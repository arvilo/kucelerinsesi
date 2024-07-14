package az.edu.turing.hackaton.kucelerinsesi.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Builder
@Data
public class ShelterResponse {

    private int id;
    private String companyName;
    private String mail;
    private String password;
    private String address;
    private String city;
    private String description;
    private LocalTime open;
    private LocalTime close;

    private String message;
    private String error;
}
