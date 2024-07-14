package az.edu.turing.hackaton.kucelerinsesi.dto.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PetResponse {

    private int id;
    private String nickname;
    private int age;
    private String species;
    private String breed;
    private String gender;
    private String color;
    private String imagePath;
    private int shelterId;

    private String message;
    private String error;
}
