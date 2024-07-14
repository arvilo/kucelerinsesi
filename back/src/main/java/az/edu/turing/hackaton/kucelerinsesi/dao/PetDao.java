package az.edu.turing.hackaton.kucelerinsesi.dao;

import az.edu.turing.hackaton.kucelerinsesi.model.Pet;

import java.util.List;

public interface PetDao {
    List<Pet> getAllPets();
    Pet getPetById(int id);
    void savePet(Pet pet);
    void deletePet(int id);
}
