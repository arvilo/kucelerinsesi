package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.AdopterResponse;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;

import java.util.List;

public interface AdopterService {
    List<AdopterResponse> getAllAdopters();

    AdopterResponse getAdopterById(int id);

    void saveAdopter(AdopterRequest adopterRequest);

    List<PetResponse> getFavorites(String token);
    //boolean likePet(LikeRequest likeRequest);
}
