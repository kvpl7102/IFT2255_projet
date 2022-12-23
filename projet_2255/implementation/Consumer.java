import java.util.ArrayList;

public class Consumer extends User {

    private String code;
    private String capacity;
    private double overallRating;
    private String trashType;
    private ArrayList<ConsumerActivity> activities;

    public Consumer(String id, String password, String name, String code, String phoneNum, String address,
            String trashType) {

        super(id, password, name, phoneNum, address);

        this.code = code;
        this.trashType = trashType;
        this.overallRating = 0;
        activities = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getOverallRating() {
        return this.overallRating;
    }

    public void calculateOverallRating() {
        double overallRating = 0;

        for (ConsumerActivity activity : activities) {
            overallRating += activity.getOverallRating();
        }
        this.overallRating = overallRating;
    }

    public String getCapacity() {
        return this.capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getTrashType() {
        return this.trashType;
    }

    public void setTrashType(String trashType) {
        this.trashType = trashType;
    }

    public ArrayList<ConsumerActivity> getActivities() {
        return this.activities;
    }

    public String printActivities() {
        String result = "";

        for (ConsumerActivity activity : activities) {
            System.out.print(activity.getActivityName() + "| ");
        }
        return result;
    }
}
