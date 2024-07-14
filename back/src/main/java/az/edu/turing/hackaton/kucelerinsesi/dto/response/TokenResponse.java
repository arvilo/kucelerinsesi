package az.edu.turing.hackaton.kucelerinsesi.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TokenResponse {


    private String token;

    private String message;
    private String error;
}
