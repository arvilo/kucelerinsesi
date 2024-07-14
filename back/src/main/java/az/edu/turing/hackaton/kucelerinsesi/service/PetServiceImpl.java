package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dao.PetDao;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.PetRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Pet;

import java.util.List;
import java.util.stream.Collectors;

public class PetServiceImpl implements PetService {
    private PetDao petDao;

    @Override
    public List<PetResponse> getAllPets() {
        return petDao.getAllPets().stream()
                .map(pet -> {
                    PetResponse dto = new PetResponse();
                    dto.setId(pet.getId());
                    dto.setNickname(pet.getNickname());
                    dto.setAge(pet.getAge());
                    dto.setSpecies(pet.getSpecies());
                    dto.setGender(pet.getGender());
                    dto.setColor(pet.getColor());
                    dto.setImagePath(pet.getImagePath());
                    dto.setShelterId(pet.getShelterId());
                    dto.setAbout(pet.getAbout());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public PetResponse getPetById(int id) {
        Pet pet = petDao.getPetById(id);
        PetResponse dto = new PetResponse();
        dto.setId(pet.getId());
        dto.setNickname(pet.getNickname());
        dto.setAge(pet.getAge());
        dto.setSpecies(pet.getSpecies());
        dto.setGender(pet.getGender());
        dto.setColor(pet.getColor());
        dto.setImagePath(pet.getImagePath());
        dto.setShelterId(pet.getShelterId());
        dto.setAbout(pet.getAbout());
        return dto;
    }

    @Override
    public void savePet(PetRequest petRequest) {
        Pet pet = new Pet();
        pet.setNickname(petRequest.getNickname());
        pet.setAge(petRequest.getAge());
        pet.setSpecies(petRequest.getSpecies());
        pet.setGender(petRequest.getGender());
        pet.setColor(petRequest.getColor());
        pet.setImagePath(petRequest.getImagePath());
        pet.setShelterId(petRequest.getShelterId());
        pet.setAbout(petRequest.getAbout());
        petDao.savePet(pet);
    }

    @Override
    public void deletePet(int id) {
        petDao.deletePet(id);
    }
}
