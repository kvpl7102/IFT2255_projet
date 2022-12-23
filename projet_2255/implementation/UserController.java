import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * UserController
 * 
 */
public class UserController implements Controller {

    private Map<String, String> usersList;
    private ArrayList<Resident> residentsList;
    private ArrayList<Consumer> consumersList;

    public UserController() {
        usersList = new HashMap<>();
        residentsList = new ArrayList<>();
        consumersList = new ArrayList<>();
    }

    public boolean verifyUser(String id, String password) {
        return usersList.containsKey(id);
    }

    public ArrayList<Resident> getResidents() {
        return residentsList;
    }

    public ArrayList<Consumer> getConsumers() {
        return consumersList;
    }

    public Map<String, String> getUsers() {
        return usersList;
    }

}