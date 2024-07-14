package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dao.ShelterDAO;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.ShelterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.ShelterResponse;
import az.edu.turing.hackaton.kucelerinsesi.exception.ShelterNotFoundException;
import az.edu.turing.hackaton.kucelerinsesi.model.Shelter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ShelterServiceImpl implements ShelterService {
    private ShelterDAO shelterDao = new ShelterDAO();

    @Override
    public void saveShelter(ShelterRequest shelterRequest) throws IOException {
        Shelter shelter = mapToEntity(shelterRequest);
        shelterDao.insertShelter(shelter);
    }

    @Override
    public ShelterResponse getShelterById(Long id) {
        Shelter shelter = shelterDao.selectShelter(id);
        return mapToResponse(shelter);
    }

    @Override
    public List<ShelterResponse> searchShelters(String keyword) {
        List<Shelter> shelters = shelterDao.searchShelters(keyword);
        return shelters.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateShelter(ShelterRequest shelterRequest, Long id) throws IOException {
        Shelter existingShelter = shelterDao.selectShelter(id);
        if (existingShelter == null) {
            throw new ShelterNotFoundException("Shelter not found with id: " + id);
        }
        Shelter updatedShelter = mapToEntity(shelterRequest);
        updatedShelter.setId(id);
        shelterDao.updateShelter(updatedShelter);
    }

    @Override
    public void deleteShelter(Long id) throws IOException {
        shelterDao.deleteShelter(id);
    }

    private Shelter mapToEntity(ShelterRequest request) {
        Shelter shelter = new Shelter();
        shelter.setCompanyName(request.getCompanyName());
        shelter.setEmail(request.getEmail());
        shelter.setPassword(request.getPassword());
        shelter.setAddress(request.getAddress());
        shelter.setPhoneNumber(request.getPhoneNumber());
        shelter.setDescription(request.getDescription());
        shelter.setWorkHours(request.getWorkHours());
        return shelter;
    }

    private ShelterResponse mapToResponse(Shelter shelter) {
        if (shelter == null) {
            return null;
        }
        ShelterResponse response = new ShelterResponse();
        response.setId(shelter.getId());
        response.setCompanyName(shelter.getCompanyName());
        response.setEmail(shelter.getEmail());
        response.setAddress(shelter.getAddress());
        response.setPhoneNumber(shelter.getPhoneNumber());
        response.setDescription(shelter.getDescription());
        response.setWorkHours(shelter.getWorkHours());
        return response;
    }
}
