package az.edu.turing.hackaton.kucelerinsesi.controller;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.ShelterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.ShelterResponse;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.TokenResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ShelterController {
    public ShelterResponse signupAsShelter(ShelterRequest shelterRequest) {
        return null;
    }

    public TokenResponse signinAsShelter(ShelterRequest shelterRequest) {
        return null;
    }

    public ShelterResponse signupAsAdopter(AdopterRequest adopterRequest) {
        return null;
    }

    public TokenResponse signinAsAdopter(AdopterRequest adopterRequest) {
        return null;
    }

    public ShelterResponse getById(String id) {
        return null;
    }

    public List<ShelterResponse> getAllShelters() {
        return null;
    }
}
