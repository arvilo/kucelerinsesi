package az.edu.turing.hackaton.kucelerinsesi.controller;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.PetRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.service.PetService;

import java.util.List;

public class PetController {
    private PetService petService;

    public List<PetResponse> getAllPets() {
        return petService.getAllPets();
    }

    public PetResponse getById(int id) {
        return petService.getPetById(id);
    }

    public void savePet(PetRequest petRequest) {
        petService.savePet(petRequest);
    }

    public void deletePet(int id) {
        petService.deletePet(id);
    }

}
