package az.edu.turing.hackaton.kucelerinsesi.controller;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.ShelterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.ShelterResponse;
import az.edu.turing.hackaton.kucelerinsesi.service.ShelterService;
import az.edu.turing.hackaton.kucelerinsesi.service.ShelterServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ShelterController {
    private ShelterService shelterService = new ShelterServiceImpl();

    public void signUpShelter(ShelterRequest shelterRequest) throws IOException {
        shelterService.saveShelter(shelterRequest);
    }

    public ShelterResponse getShelterById(Long id) {
        ShelterResponse shelterResponse = shelterService.getShelterById(id);
        if (shelterResponse == null) {
            throw new RuntimeException("Shelter not found with id: " + id);
        }
        return shelterResponse;
    }

    public List<ShelterResponse> searchShelters(String keyword) {
        List<ShelterResponse> shelterResponses = shelterService.searchShelters(keyword);
        return shelterResponses.stream()
                .filter(response -> response != null)
                .collect(Collectors.toList());
    }

    public void updateShelter(ShelterRequest shelterRequest, Long id) throws IOException {
        shelterService.updateShelter(shelterRequest, id);
    }

    public void deleteShelter(Long id) throws IOException {
        shelterService.deleteShelter(id);
    }
}
