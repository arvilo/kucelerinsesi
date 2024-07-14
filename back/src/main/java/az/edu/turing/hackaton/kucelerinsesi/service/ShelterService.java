package az.edu.turing.hackaton.kucelerinsesi.service;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.ShelterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.ShelterResponse;

import java.io.IOException;
import java.util.List;

public interface ShelterService {
    void saveShelter(ShelterRequest shelterRequest) throws IOException;

    ShelterResponse getShelterById(Long id);

    List<ShelterResponse> searchShelters(String keyword);

    void updateShelter(ShelterRequest shelterRequest, Long id) throws IOException;

    void deleteShelter(Long id) throws IOException;
}
