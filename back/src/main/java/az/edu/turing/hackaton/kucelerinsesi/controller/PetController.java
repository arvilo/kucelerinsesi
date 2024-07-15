package az.edu.turing.hackaton.kucelerinsesi.controller;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.PetRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Gender;
import az.edu.turing.hackaton.kucelerinsesi.model.Pet;
import az.edu.turing.hackaton.kucelerinsesi.model.Species;
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
        Pet pet=parsePetRequest(petRequest);
        petService.savePet(pet);
    }

    public void deletePet(int id) {
        petService.deletePet(id);
    }

    private Pet parsePetRequest(PetRequest petRequest) {
        Pet pet = new Pet();
        pet.setNickname(petRequest.getNickname());
        pet.setAge(Integer.parseInt(petRequest.getAge()));
        pet.setSpecies(Species.valueOf(petRequest.getSpecies()));
        pet.setGender(Gender.valueOf(petRequest.getGender()));
        pet.setColor(petRequest.getColor());
        pet.setImagePath(petRequest.getImagePath());
        pet.setShelterId(Integer.parseInt(petRequest.getShelterId()));
        pet.setAbout(petRequest.getAbout());
        return pet;
    }
}
