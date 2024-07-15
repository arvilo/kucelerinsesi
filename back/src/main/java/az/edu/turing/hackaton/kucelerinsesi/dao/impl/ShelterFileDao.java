package az.edu.turing.hackaton.kucelerinsesi.dao.impl;

import az.edu.turing.hackaton.kucelerinsesi.dao.DAO;
import az.edu.turing.hackaton.kucelerinsesi.exception.ShelterFileException;
import az.edu.turing.hackaton.kucelerinsesi.exception.ShelterNotFoundException;
import az.edu.turing.hackaton.kucelerinsesi.model.Shelter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShelterFileDao implements DAO<Shelter> {
    private static String RESOURCE_PATH = "src/main/java/az/edu/turing/hackaton/kucelerinsesi/resource";
    private static final String SHELTER_FILE_PATH = RESOURCE_PATH.concat("/shelters.ser");

    @Override
    public void insert(Shelter shelter) throws IOException {
        List<Shelter> shelters = readSheltersFromFile();
        shelter.setId(generateId(shelters));
        shelters.add(shelter);
        writeSheltersToFile(shelters);
    }

    @Override
    public Shelter selectById(Long id) {
        List<Shelter> shelters = readSheltersFromFile();
        return shelters.stream()
                .filter(shelter -> shelter.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ShelterNotFoundException("Shelter not found with id: " + id));
    }

    @Override
    public List<Shelter> search(String keyword) {
        List<Shelter> shelters = readSheltersFromFile();
        List<Shelter> result = new ArrayList<>();
        for (Shelter shelter : shelters) {
            if (shelter.getCompanyName().contains(keyword) || shelter.getDescription().contains(keyword)) {
                result.add(shelter);
            }
        }
        return result;
    }

    @Override
    public void update(Shelter updatedShelter) throws IOException {
        List<Shelter> shelters = readSheltersFromFile();
        Optional<Shelter> existingShelterOpt = shelters.stream()
                .filter(shelter -> shelter.getId().equals(updatedShelter.getId()))
                .findFirst();

        if (existingShelterOpt.isPresent()) {
            shelters.remove(existingShelterOpt.get());
            shelters.add(updatedShelter);
            writeSheltersToFile(shelters);
        } else {
            throw new ShelterNotFoundException("Shelter not found with id: " + updatedShelter.getId());
        }
    }

    @Override
    public void delete(Long id) throws IOException {
        List<Shelter> shelters = readSheltersFromFile();
        Optional<Shelter> shelterToRemove = shelters.stream()
                .filter(shelter -> shelter.getId().equals(id))
                .findFirst();
        if (shelterToRemove.isPresent()) {
            shelters.remove(shelterToRemove.get());
            writeSheltersToFile(shelters);
        } else {
            throw new ShelterNotFoundException("Shelter not found with id: " + id);
        }
    }

    public List<Shelter> readSheltersFromFile() {
        List<Shelter> shelters = new ArrayList<>();
        File file = new File(SHELTER_FILE_PATH);
        if (!file.exists()) {
            return shelters;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SHELTER_FILE_PATH))) {
            shelters = (List<Shelter>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Shelters file not found: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new ShelterFileException("Error reading shelters from file", e);
        }
        return shelters;
    }

    private void writeSheltersToFile(List<Shelter> shelters) {
        try {
            File file = new File(SHELTER_FILE_PATH);
            file.getParentFile().mkdirs();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(shelters);
            }
            System.out.println("Shelters written to file successfully.");
        } catch (IOException e) {
            throw new ShelterFileException("Error writing shelters to file", e);
        }
    }

    private Long generateId(List<Shelter> shelters) {
        return shelters.stream()
                .mapToLong(Shelter::getId)
                .max()
                .orElse(0L) + 1;
    }

    public void setFilePath(String filePath) {
        // Optional: if you want to set a custom file path dynamically
    }
}