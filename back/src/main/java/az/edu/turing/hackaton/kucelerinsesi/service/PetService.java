package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.PetRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;

import java.util.List;

public interface PetService {
    List<PetResponse> getAllPets();
    PetResponse getPetById(int id);
    void savePet(PetRequest petRequest);
    void deletePet(int id);
}
