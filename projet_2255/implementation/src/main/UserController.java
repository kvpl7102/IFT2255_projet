import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * UserController
 * 
 */
public class UserController implements Controller {

    //prologe: controller class for all users including resident and consumers;

    private Map<String, String> usersList;
    private ArrayList<Resident> residentsList;
    private ArrayList<Consumer> consumersList;

    public UserController() {
        usersList = new HashMap<>();
        residentsList = new ArrayList<>();
        consumersList = new ArrayList<>();

    }

    /**
     * @param id
     * @param password
     * @return boolean
     */
    public boolean verifyUser(String id, String password) {
        return usersList.containsKey(id);
    }

    /**
     * @return ArrayList<Resident>
     */
    public ArrayList<Resident> getResidents() {
        return residentsList;
    }

    /**
     * @return ArrayList<Consumer>
     */
    public ArrayList<Consumer> getConsumers() {
        return consumersList;
    }

    /**
     * @return Map<String, String>
     */
    public Map<String, String> getUsers() {
        return usersList;
    }

}