package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dao.AdopterDao;
import az.edu.turing.hackaton.kucelerinsesi.dao.PetDao;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Adopter;

import java.util.List;

public class AdopterServiceImpl implements AdopterService {
    private AdopterDao adopterDao;
    private PetDao petDao;

    @Override
    public void saveAdopter(Adopter adopter) {
        adopter.setName(adopter.getName());
        adopter.setSurname(adopter.getSurname());
        adopter.setMail(adopter.getMail());
        adopter.setPassword(adopter.getPassword());
        adopter.setBirth(adopter.getBirth());
        adopterDao.saveAdopter(adopter);
    }

    @Override
    public List<PetResponse> getFavorites(String token) {
        return null;
    }
}
