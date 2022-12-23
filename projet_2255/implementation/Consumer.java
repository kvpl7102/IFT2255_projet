import java.util.ArrayList;

public class Consumer extends User {

    private String code;
    private String capacity;
    private double overallRating;
    private String trashType;
    private ArrayList<Double> ratings;
    private ArrayList<ConsumerActivity> activities;

    public Consumer(String id, String password, String name, String code, String phoneNum, String address,
            String trashType) {

        super(id, password, name, phoneNum, address);

        this.code = code;
        this.trashType = trashType;
        this.overallRating = 0;
        ratings = new ArrayList<>();
        activities = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRating() {
        return this.overallRating;
    }

    public void calculateOverallRating() {
        int sum = 0;
        for (double rating : ratings) {
            sum += rating;
        }
        overallRating = sum / ratings.size();
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
