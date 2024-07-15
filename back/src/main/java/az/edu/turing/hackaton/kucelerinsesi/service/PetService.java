package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.PetRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Pet;

import java.util.List;

public interface PetService {
    List<PetResponse> getAllPets();

    PetResponse getPetById(int id);

    void savePet(Pet pet);

    void deletePet(int id);
}
