import az.edu.turing.hackaton.kucelerinsesi.model.Shelter;
import az.edu.turing.hackaton.kucelerinsesi.dao.ShelterDAO;
import az.edu.turing.hackaton.kucelerinsesi.exception.ShelterFileException;

public class Application {
    private static final String SHELTER_FILE_PATH = "shelters.dat";

    public static void main(String[] args) {
        // Create a shelter object
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setCompanyName("Animal Haven");
        shelter.setEmail("contact@animalhaven.org");

        // Save shelter information to file
        saveShelterToFile(shelter);

        // Now you can perform other operations or tests
    }

    private static void saveShelterToFile(Shelter shelter) {
        ShelterDAO shelterDAO = new ShelterDAO();
        try {
            // Insert shelter into file
            shelterDAO.insertShelter(shelter);
            System.out.println("Shelter information saved to file successfully.");
        } catch (ShelterFileException e) {
            System.err.println("Error saving shelter information to file: " + e.getMessage());
        }
    }
}
