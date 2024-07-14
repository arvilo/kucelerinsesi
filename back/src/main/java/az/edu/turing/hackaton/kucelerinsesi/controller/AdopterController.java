package az.edu.turing.hackaton.kucelerinsesi.controller;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.AdopterResponse;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.service.AdopterService;

import java.util.List;

public class AdopterController {
    private AdopterService adopterService;

    public List<AdopterResponse> getAllAdopters() {
        return adopterService.getAllAdopters();
    }

    public AdopterResponse getAdopterById(int id) {
        return adopterService.getAdopterById(id);
    }

    public void saveAdopter(AdopterRequest adopterRequest) {
        adopterService.saveAdopter(adopterRequest);
    }

    public List<PetResponse> getFavoritePets(String token){
        return adopterService.getFavorites(token);
    }
}
