package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dao.PetDao;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.PetRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Gender;
import az.edu.turing.hackaton.kucelerinsesi.model.Pet;
import az.edu.turing.hackaton.kucelerinsesi.model.Species;

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
                    dto.setBreed(pet.getBreed());
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
        dto.setBreed(pet.getBreed());
        dto.setGender(pet.getGender());
        dto.setColor(pet.getColor());
        dto.setImagePath(pet.getImagePath());
        dto.setShelterId(pet.getShelterId());
        dto.setAbout(pet.getAbout());
        return dto;
    }

    @Override
    public void savePet(Pet pet) {
        Pet pet1 = new Pet();
        pet.setNickname(pet1.getNickname());
        pet.setAge(Integer.parseInt(String.valueOf(pet1.getAge())));
        pet.setSpecies(Species.valueOf(String.valueOf(pet1.getSpecies())));
        pet.setBreed(pet1.getBreed());
        pet.setGender(Gender.valueOf(String.valueOf(pet1.getGender())));
        pet.setColor(pet1.getColor());
        pet.setImagePath(pet1.getImagePath());
        pet.setShelterId(Integer.parseInt(String.valueOf(pet1.getShelterId())));
        pet.setAbout(pet1.getAbout());
        petDao.savePet(pet1);
    }

    @Override
    public void deletePet(int id) {
        petDao.deletePet(id);
    }
}
