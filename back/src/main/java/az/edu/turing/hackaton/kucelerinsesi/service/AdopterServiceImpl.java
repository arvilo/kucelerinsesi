package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dao.AdopterDao;
import az.edu.turing.hackaton.kucelerinsesi.dao.PetDao;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.AdopterResponse;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Adopter;

import java.util.List;
import java.util.stream.Collectors;

public class AdopterServiceImpl implements AdopterService {

    private AdopterDao adopterDao;
    private PetDao petDao;

    @Override
    public List<AdopterResponse> getAllAdopters() {
        return adopterDao.getAllAdopters().stream()
                .map(adopter -> {
                    AdopterResponse dto = new AdopterResponse();
                    dto.setId((adopter.getId()));
                    dto.setName(adopter.getName());
                    dto.setSurname(adopter.getSurname());
                    dto.setMail(adopter.getMail());
                    dto.setBirth(adopter.getBirth());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public AdopterResponse getAdopterById(int id) {
        Adopter adopter = adopterDao.getAdopterById(id);
        AdopterResponse dto = new AdopterResponse();
        dto.setId(adopter.getId());
        dto.setName(adopter.getName());
        dto.setSurname(adopter.getSurname());
        dto.setMail(adopter.getMail());
        dto.setBirth(adopter.getBirth());
        return dto;
    }

    @Override
    public void saveAdopter(AdopterRequest adopterRequest) {
        Adopter adopter = new Adopter();
        adopter.setName(adopterRequest.getName());
        adopter.setSurname(adopterRequest.getSurname());
        adopter.setMail(adopterRequest.getMail());
        adopter.setPassword(adopterRequest.getPassword());
        adopter.setBirth(adopterRequest.getBirth());
        adopterDao.saveAdopter(adopter);
    }

    @Override
    public List<PetResponse> getFavorites(String token) {
        return null;
    }
}
