import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * UserController
 */
public class UserController implements Controller {

    public Map<String, String> usersList;
    public ArrayList<Resident> residentsList;
    public ArrayList<Consommateur> consommateursList;

    public UserController() {
        usersList = new HashMap<>();
        residentsList = new ArrayList<>();
        consommateursList = new ArrayList<>();
    }

    public boolean verifyUser(String id, String password) {
        return usersList.containsKey(id) && usersList.containsValue(password);
    }

    public Resident createResident(String id, String password) {
        Resident resident = new Resident(id, password);
        residentsList.add(resident);
        usersList.put(id, password);

        return resident;
    }

    public Consommateur createConsommateur(String id, String password, String code) {
        Consommateur consommateur = new Consommateur(id, password, code);
        consommateursList.add(consommateur);
        usersList.put(id, password);

        return consommateur;
    }

    public void getConsommateurs() {
        System.out.println("\n================================");
        for (Consommateur consommateur : consommateursList) {
            System.out.println(consommateur);
            System.out.println("================================");
        }
        System.out.println("================================\n");
    }

}