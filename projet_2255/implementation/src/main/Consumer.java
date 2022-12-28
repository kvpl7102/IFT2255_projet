import java.util.ArrayList;

//class for consumers.
public class Consumer extends User {
    //prologe: class for an individual consummer and all possible actions

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

        ConsumerActivity act1 = new ConsumerActivity("act1");
        ConsumerActivity act2 = new ConsumerActivity("act2");
        ConsumerActivity act3 = new ConsumerActivity("act3");
        activities.add(act1);
        activities.add(act2);
        activities.add(act3);
        // initials activities
    }

    /**
     * @return String
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return double
     */
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

    /**
     * @return String
     */
    public String getCapacity() {
        return this.capacity;
    }

    /**
     * @param capacity
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * @return String
     */
    public String getTrashType() {
        return this.trashType;
    }

    /**
     * @param trashType
     */
    public void setTrashType(String trashType) {
        this.trashType = trashType;
    }

    /**
     * @return ArrayList<ConsumerActivity>
     */
    public ArrayList<ConsumerActivity> getActivities() {
        return this.activities;
    }

    /**
     * @return String
     */
    public String printActivities() {
        String result = "";

        for (ConsumerActivity activity : activities) {
            System.out.print(activity.getActivityName() + "| ");
        }
        return result;
    }
}
