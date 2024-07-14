package az.edu.turing.hackaton.kucelerinsesi.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdopterResponse {

    private int id;
    private String name;
    private String surname;
    private String mail;
    private String birth; // DD/MM/YYYY
    private String password;

    private String message;
    private String error;
}
