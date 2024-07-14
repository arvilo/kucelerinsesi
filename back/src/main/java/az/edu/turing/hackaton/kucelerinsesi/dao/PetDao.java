package az.edu.turing.hackaton.kucelerinsesi.dao;

import az.edu.turing.hackaton.kucelerinsesi.model.Gender;
import az.edu.turing.hackaton.kucelerinsesi.model.Pet;
import az.edu.turing.hackaton.kucelerinsesi.model.Species;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface PetDao {
    List<Pet> getAllPets();
    Pet getPetById(int id);
    void savePet(Pet pet);
    void deletePet(int id);
}
