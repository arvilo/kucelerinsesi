package az.edu.turing.hackaton.kucelerinsesi.dao;

import az.edu.turing.hackaton.kucelerinsesi.dto.response.AdopterResponse;
import az.edu.turing.hackaton.kucelerinsesi.model.Adopter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdopterDaoImpl implements AdopterDao {
    private static final String FILE_PATH="az/edu/turing/hackaton/kucelerinsesi/resource/adapter.ser";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Adopter> getAllAdopters() {
        List<Adopter> adopters = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                adopters.add(parseAdopter(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adopters;
    }

    @Override
    public Adopter getAdopterById(int id) {
        return getAllAdopters().stream()
                .filter(adopter -> adopter.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveAdopter(Adopter adopter) {
        List<Adopter> adopters = getAllAdopters();
        adopters.add(adopter);
        saveToFile(adopters);
    }

    @Override
    public void saveFavoritePet(int adopterId, int petId) {

    }

    private Adopter parseAdopter(String line) {
        String[] fields = line.split(",");
        Adopter adopter = new Adopter();
        adopter.setId(Integer.parseInt(fields[0]));
        adopter.setName(fields[1]);
        adopter.setSurname(fields[2]);
        adopter.setMail(fields[3]);
        adopter.setPassword(fields[4]);
        try {
            adopter.setBirth(String.valueOf(DATE_FORMAT.parse(fields[5])));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return adopter;
    }

    private String formatAdopter(Adopter adopter) {
        return adopter.getId() + "," +
                adopter.getName() + "," +
                adopter.getSurname() + "," +
                adopter.getMail() + "," +
                adopter.getPassword() + "," +
                DATE_FORMAT.format(adopter.getBirth());
    }

    private void saveToFile(List<Adopter> adopters) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Adopter adopter : adopters) {
                bw.write(formatAdopter(adopter));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
