package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dao.ShelterDAO;
import az.edu.turing.hackaton.kucelerinsesi.dao.ShelterEntity;

import java.io.IOException;
import java.util.List;

public class ShelterService {
    private ShelterDAO shelterDao = new ShelterDAO();

    public void saveShelter(ShelterEntity shelter) throws IOException {
        shelterDao.insertShelter(shelter);
    }

    public ShelterEntity getShelterById(Long id) {
        return shelterDao.selectShelter(id);
    }

    public List<ShelterEntity> searchShelters(String keyword) {
        return shelterDao.searchShelters(keyword);
    }

    public void updateShelter(ShelterEntity shelter) throws IOException {
        shelterDao.updateShelter(shelter);
    }

    public void deleteShelter(Long id) throws IOException {
        shelterDao.deleteShelter(id);
    }
}
