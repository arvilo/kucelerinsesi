package az.edu.turing.hackaton.kucelerinsesi.dto.request;


public class LikeRequest {

    private String petId;
    private String token;

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
