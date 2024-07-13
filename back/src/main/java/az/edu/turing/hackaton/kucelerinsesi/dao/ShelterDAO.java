package az.edu.turing.hackaton.kucelerinsesi.dao;

import az.edu.turing.hackaton.kucelerinsesi.dao.impl.ShelterFileDao;
import java.io.IOException;
import java.util.List;

public class ShelterDAO {
    private DAO<ShelterEntity> shelterFileDao = new ShelterFileDao();

    public void insertShelter(ShelterEntity shelter) throws IOException {
        shelterFileDao.insert(shelter);
    }

    public ShelterEntity selectShelter(Long id) {
        return shelterFileDao.selectById(id);
    }

    public List<ShelterEntity> searchShelters(String keyword) {
        return shelterFileDao.search(keyword);
    }

    public void updateShelter(ShelterEntity shelter) throws IOException {
        shelterFileDao.update(shelter);
    }

    public void deleteShelter(Long id) throws IOException {
        shelterFileDao.delete(id);
    }

    public DAO<ShelterEntity> getShelterFileDao() {
        return shelterFileDao;
    }
}
