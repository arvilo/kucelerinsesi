package az.edu.turing.hackaton.kucelerinsesi.controller;

import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.LikeRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.PetResponse;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.TokenResponse;

import java.util.List;

public class AdopterController {

    public List<PetResponse> getFavoritePets(String token) {
        return null;
    }

    public boolean like(LikeRequest likeRequest) {
        return true;
    }

    public boolean unlike(LikeRequest likeRequest) {
        return true;
    }

    public boolean signup(AdopterRequest adopterRequest) {
        return true;
    }

    public TokenResponse signin(AdopterRequest adopterRequest) {
        return null;
    }
}
