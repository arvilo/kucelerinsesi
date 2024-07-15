package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.AdopterResponse;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Adopter;

import java.util.List;

public interface AdopterService {
    void saveAdopter(Adopter adopter);

    List<PetResponse> getFavorites(String token);
    //boolean likePet(LikeRequest likeRequest);
}
