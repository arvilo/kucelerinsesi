
import az.edu.turing.hackaton.kucelerinsesi.dao.ShelterDAO;
import az.edu.turing.hackaton.kucelerinsesi.dao.ShelterEntity;
import az.edu.turing.hackaton.kucelerinsesi.dao.impl.ShelterFileDao;
import az.edu.turing.hackaton.kucelerinsesi.exception.ShelterFileException;
import az.edu.turing.hackaton.kucelerinsesi.exception.ShelterNotFoundException;
import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        ShelterDAO shelterDAO = new ShelterDAO();
//
//
//        ShelterEntity newShelter = new ShelterEntity("Happy Paws Shelter", "happypaws@example.com", "password123", "1234 Street, City", "123-456-7890", "We care for stray animals", "09:00-18:00");
//        try {
//            shelterDAO.insertShelter(newShelter);
//            System.out.println("New shelter added with ID: " + newShelter.getId());
//        } catch (IOException e) {
//            System.err.println("Error inserting shelter: " + e.getMessage());
//        }
//
//
//        try {
//            ShelterEntity shelter = shelterDAO.selectShelter(newShelter.getId());
//            System.out.println("Selected Shelter: " + shelter.getCompanyName());
//        } catch (ShelterNotFoundException e) {
//            System.err.println("Error selecting shelter: " + e.getMessage());
//        }
//
//
//        List<ShelterEntity> shelters = shelterDAO.searchShelters("Happy");
//        System.out.println("Search results:");
//        for (ShelterEntity shelter : shelters) {
//            System.out.println(" - " + shelter.getCompanyName());
//        }
//
//
//        newShelter.setDescription("Updated description");
//        try {
//            shelterDAO.updateShelter(newShelter);
//            System.out.println("Shelter updated.");
//        } catch (IOException e) {
//            System.err.println("Error updating shelter: " + e.getMessage());
//        }
//
//        try {
//            shelterDAO.deleteShelter(newShelter.getId());
//            System.out.println("Shelter deleted.");
//        } catch (IOException e) {
//            System.err.println("Error deleting shelter: " + e.getMessage());
//        }
//        System.out.println("************************************************************************************");
//        System.out.println("");
        ShelterDAO shelterDAO = new ShelterDAO();


        String testFilePath = "az/edu/turing/hackaton/kucelerinsesi/resource/shelters_test.ser";

        // Override FILE_PATH in ShelterFileDao for testing
        ShelterFileDao shelterFileDao = (ShelterFileDao) shelterDAO.getShelterFileDao();
        shelterFileDao.setFilePath(testFilePath);


        ShelterEntity newShelter = new ShelterEntity("Happy Paws Shelter", "happypaws@example.com", "password123", "1234 Street, City", "123-456-7890", "We care for stray animals", "09:00-18:00");
        try {
            shelterDAO.insertShelter(newShelter);
            System.out.println("New shelter added with ID: " + newShelter.getId());
        } catch (IOException e) {
            System.err.println("Error inserting shelter: " + e.getMessage());
        }

        try {
            ShelterEntity shelter = shelterDAO.selectShelter(newShelter.getId());
            System.out.println("Selected Shelter: " + shelter.getCompanyName());
        } catch (ShelterNotFoundException e) {
            System.err.println("Error selecting shelter: " + e.getMessage());
        }


        List<ShelterEntity> shelters = shelterDAO.searchShelters("Happy");
        System.out.println("Search results:");
        for (ShelterEntity shelter : shelters) {
            System.out.println(" - " + shelter.getCompanyName());
        }


        newShelter.setDescription("Updated description");
        try {
            shelterDAO.updateShelter(newShelter);
            System.out.println("Shelter updated.");
        } catch (IOException e) {
            System.err.println("Error updating shelter: " + e.getMessage());
        }


        try {
            shelterDAO.deleteShelter(newShelter.getId());
            System.out.println("Shelter deleted.");
        } catch (IOException e) {
            System.err.println("Error deleting shelter: " + e.getMessage());
        }


        try {
            List<ShelterEntity> writtenShelters = shelterFileDao.readSheltersFromFile();
            System.out.println("Shelters read from file:");
            for (ShelterEntity shelter : writtenShelters) {
                System.out.println(" - " + shelter.getCompanyName());
            }
        } catch (ShelterFileException e) {
            System.err.println("Error reading shelters from file: " + e.getMessage());
        }
    }
}
