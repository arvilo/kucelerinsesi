package az.edu.turing.hackaton.kucelerinsesi.controller;


import az.edu.turing.hackaton.kucelerinsesi.dto.request.AdopterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.LikeRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.PetRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.ShelterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.*;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class HomeController {

    private ShelterController shelterController;
    private AdopterController adopterController;
    private PetController petController;

    public HomeController() {
        this.shelterController = new ShelterController();
        this.adopterController = new AdopterController();
        this.petController = new PetController();
    }

    @PostMapping("signup/shelter")
    public ResponseEntity<ShelterResponse> signupShelter(@RequestBody ShelterRequest shelterRequest) {
        ShelterResponse sr;
        int statusCode;
        if (shelterController.signupAsShelter(shelterRequest) != null) {
            sr = ShelterResponse.builder().message("OK").build();
            statusCode = 200;
        } else {
            sr = ShelterResponse.builder().error("invalid data").build();
            statusCode = 400;
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).body(sr);
    }

    @PostMapping("signin/shelter")
    public ResponseEntity<TokenResponse> signinShelterAsShelter(@RequestBody ShelterRequest shelterRequest) {
        TokenResponse tr = shelterController.signinAsShelter(shelterRequest);
        tr = TokenResponse.builder().token("sd3423srsew").build();
        int statusCode;
        if (tr != null) {
            statusCode = 200;
        } else {
            tr = TokenResponse.builder().error("invalid data").build();
            statusCode = 400;
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).body(tr);
    }

    @PostMapping("signup/adopter")
    public ResponseEntity<AdopterResponse> signupAdopter(@RequestBody AdopterRequest adopterRequest) {
        AdopterResponse ar;
        int statusCode;
        if (adopterController.signupAsAdopter(adopterRequest)) {
            ar = AdopterResponse.builder().message("OK").build();
            statusCode = 200;
        } else {
            ar = AdopterResponse.builder().error("invalid data").build();
            statusCode = 400;
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).body(ar);
    }

    @PostMapping("signin/adopter")
    public ResponseEntity<TokenResponse> signinShelterAsAdopter(@RequestBody AdopterRequest adopterRequest) {
        TokenResponse tr = adopterController.signinAsAdopter(adopterRequest);
        int statusCode;
        if (tr != null) {
            statusCode = 200;
        } else {
            tr = TokenResponse.builder().error("invalid data").build();
            statusCode = 400;
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).body(tr);
    }

    //favorites (GET)

    @GetMapping("favorites/{token}")
    public ResponseEntity<List<PetResponse>> favorites(@PathVariable String token) {
        List<PetResponse> prl = adopterController.getFavoritePets(token);
        int statusCode;
        if (prl != null) {
            statusCode = 200;
        } else {
            prl = List.of(PetResponse.builder().error("invalid token").build());
            statusCode = 400;
        }

        return ResponseEntity.status(statusCode).body(prl);
    }

    //favorites/{data}  (POST)

    @PostMapping("favorites/{id}/{token}") //id -> petID
    public ResponseEntity<String> like(@PathVariable String id, @PathVariable String token) {
        LikeRequest likeRequest = new LikeRequest();
        likeRequest.setPetId(id);
        likeRequest.setToken(token);

        if (adopterController.like(likeRequest)) {
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.status(404).body("invalid data");
        }

    }

    //favorites/{id}/{token} (Delete)

    @DeleteMapping("favorites/{id}/{token}") //id -> petID
    public ResponseEntity<String> unlike(@PathVariable String id, @PathVariable String token) {
        LikeRequest likeRequest = new LikeRequest();
        likeRequest.setPetId(id);
        likeRequest.setToken(token);

        if (adopterController.unlike(likeRequest)) {
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.status(404).body("invalid data");
        }

    }

    //pets/getrandom  (GET)
    @GetMapping("pets/getrandom")
    public ResponseEntity<List<PetResponse>> getrandom() {
        return ResponseEntity.ok(petController.getRandomPets());
    }


    //pets?nickname=tom&age=2&species=asd&breed=adsd&gender=M&colour=black&shelter=dsd (GET)
    @GetMapping("pets")
    public ResponseEntity<List<PetResponse>> filterPets(
            @RequestParam String nickname,
            @RequestParam String age,
            @RequestParam String species,
            @RequestParam String breed,
            @RequestParam String gender,
            @RequestParam String colour,
            @RequestParam String shelterId
    ) {
        PetRequest petRequest = new PetRequest();
        petRequest.setNickname(nickname);
        petRequest.setAge(age);
        petRequest.setSpecies(species);
        petRequest.setBreed(breed);
        petRequest.setGender(gender);
        petRequest.setColor(colour);
        petRequest.setShelterId(shelterId);

        return ResponseEntity.ok(petController.filter(petRequest));
    }

    //pets/{id} (GET)
    @GetMapping("pets/{id}")
    public ResponseEntity<PetResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(petController.getById(id));
    }

    //shelters/{id} (GET)
    @GetMapping("shelters/{id}")
    public ResponseEntity<ShelterResponse> getShelterById(@PathVariable String id) {
        return ResponseEntity.ok(shelterController.getById(id));
    }

    //shelters
    @GetMapping("shelters")
    public ResponseEntity<List<ShelterResponse>> getShelters() {
        return ResponseEntity.ok(shelterController.getAllShelters());
    }

    //pets/{token}
    @PostMapping("pets/{token}")
    public ResponseEntity<PetResponse> addPet(@RequestBody PetRequest petRequest) {
        int statuscode;
        PetResponse pr = petController.addPet(petRequest);
        if (pr != null) {
            statuscode = 200;
        } else {
            statuscode = 404;
        }

        return ResponseEntity.status(statuscode).body(pr);
    }

    //pets/{id}/{token}
    @DeleteMapping("pets/{id}/{token}")
    public ResponseEntity<String> deletePet(@PathVariable String id, @PathVariable String token) {
        return ResponseEntity.status(petController.deletePat(id, token) ? 200 : 404).body("");
    }


}
