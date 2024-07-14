package az.edu.turing.hackaton.kucelerinsesi.dao;

import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Adopter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface AdopterDao {
    List<Adopter> getAllAdopters();
    Adopter getAdopterById(int id);
    void saveAdopter(Adopter adopter);
    List<Integer> getFavoritePetIdsByAdopterId(int adopterId);
    void saveFavoritePet(int adopterId, int petId);
}
