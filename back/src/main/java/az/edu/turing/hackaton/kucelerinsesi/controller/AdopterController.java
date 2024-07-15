package az.edu.turing.hackaton.kucelerinsesi.controller;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.AdopterResponse;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Adopter;
import az.edu.turing.hackaton.kucelerinsesi.service.AdopterService;

import java.util.List;

public class AdopterController {
    private AdopterService adopterService;

    public void saveAdopter(AdopterRequest adopterRequest) {
        Adopter adopter = parseAdopterRequest(adopterRequest);
        adopterService.saveAdopter(adopter);
    }

    public List<PetResponse> getFavoritePets(String token){
        return adopterService.getFavorites(token);
    }

    private Adopter parseAdopterRequest(AdopterRequest adopterRequest) {
        Adopter adopter = new Adopter();
        adopter.setName(adopterRequest.getName());
        adopter.setSurname(adopterRequest.getSurname());
        adopter.setMail(adopterRequest.getMail());
        adopter.setPassword(adopterRequest.getPassword());
        adopter.setBirth(adopterRequest.getBirth());
        return adopter;
    }
}
