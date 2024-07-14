package az.edu.turing.hackaton.kucelerinsesi.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

    private String error;
}
