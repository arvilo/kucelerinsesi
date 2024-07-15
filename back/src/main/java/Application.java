import az.edu.turing.hackaton.kucelerinsesi.controller.ShelterController;
import az.edu.turing.hackaton.kucelerinsesi.dto.request.ShelterRequest;
import az.edu.turing.hackaton.kucelerinsesi.dto.response.ShelterResponse;
import az.edu.turing.hackaton.kucelerinsesi.service.ShelterService;
import az.edu.turing.hackaton.kucelerinsesi.service.ShelterServiceImpl;

;import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {

//            ShelterController controller = new ShelterController();
//
//            ShelterRequest newShelter = new ShelterRequest();
//            newShelter.setCompanyName("Animal Haven");
//            newShelter.setEmail("contact@animalhaven.org");
//            newShelter.setPassword("securepassword");
//            newShelter.setAddress("123 Animal Street");
//            newShelter.setPhoneNumber("+123456789");
//            newShelter.setDescription("A safe place for animals.");
//            newShelter.setWorkHours("9AM - 5PM");
//
//            try {
//                controller.signUpShelter(newShelter);
//                System.out.println("Shelter created successfully.");
//            } catch (IOException e) {
//                System.err.println("Error creating shelter: " + e.getMessage());
//            }
//
//            // Get shelter by ID
//            try {
//                ShelterResponse shelter = controller.getShelterById(1L);
//                System.out.println("Shelter fetched by ID: " + shelter.getCompanyName());
//            } catch (RuntimeException e) {
//                System.err.println("Error fetching shelter by ID: " + e.getMessage());
//            }
//
//            // Search shelters
//            List<ShelterResponse> shelters = controller.searchShelters("Animal");
//            System.out.println("Shelters found: " + shelters.size());
//            for (ShelterResponse shelter : shelters) {
//                System.out.println("Found shelter: " + shelter.getCompanyName());
//            }
//
//            // Update shelter
//            ShelterRequest updatedShelter = new ShelterRequest();
//            updatedShelter.setCompanyName("Animal Haven Updated");
//            updatedShelter.setEmail("contact@animalhaven.org");
//            updatedShelter.setPassword("securepassword");
//            updatedShelter.setAddress("123 Animal Street");
//            updatedShelter.setPhoneNumber("+123456789");
//            updatedShelter.setDescription("An updated safe place for animals.");
//            updatedShelter.setWorkHours("9AM - 6PM");
//
//            try {
//                controller.updateShelter(updatedShelter, 1L);
//                System.out.println("Shelter updated successfully.");
//            } catch (IOException e) {
//                System.err.println("Error updating shelter: " + e.getMessage());
//            }
//
//
//            try {
//                controller.deleteShelter(1L);
//                System.out.println("Shelter deleted successfully.");
//            } catch (IOException e) {
//                System.err.println("Error deleting shelter: " + e.getMessage());
//            }
        ShelterController controller = new ShelterController();
        ShelterService service = new ShelterServiceImpl();

        // Create a new shelter
        ShelterRequest newShelter = new ShelterRequest();
        newShelter.setCompanyName("Animal Haven");
        newShelter.setEmail("contact@animalhaven.org");
        newShelter.setPassword("securepassword");
        newShelter.setAddress("123 Animal Street");
        newShelter.setPhoneNumber("+123456789");
        newShelter.setDescription("A safe place for animals.");
        newShelter.setWorkHours("9AM - 5PM");

        try {
            // Save the new shelter
            service.saveShelter(newShelter);
            System.out.println("Shelter created and saved successfully.");

            // Get shelter by ID
            ShelterResponse shelter = service.getShelterById(1L);
            System.out.println("Shelter fetched by ID: " + shelter.getCompanyName());

            // Search shelters
            List<ShelterResponse> shelters = service.searchShelters("Animal");
            System.out.println("Shelters found: " + shelters.size());
            for (ShelterResponse foundShelter : shelters) {
                System.out.println("Found shelter: " + foundShelter.getCompanyName());
            }

            // Update shelter
            ShelterRequest updatedShelter = new ShelterRequest();
            updatedShelter.setCompanyName("Animal Haven Updated");
            updatedShelter.setEmail("contact@animalhaven.org");
            updatedShelter.setPassword("securepassword");
            updatedShelter.setAddress("123 Animal Street");
            updatedShelter.setPhoneNumber("+123456789");
            updatedShelter.setDescription("An updated safe place for animals.");
            updatedShelter.setWorkHours("9AM - 6PM");

            service.updateShelter(updatedShelter, 1L);
            System.out.println("Shelter updated successfully.");

            // Delete shelter
            service.deleteShelter(1L);
            System.out.println("Shelter deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
