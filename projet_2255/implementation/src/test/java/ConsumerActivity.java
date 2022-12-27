import java.util.ArrayList;

public class ConsumerActivity {

    private String activityName;
    private double overallRating;
    private ArrayList<Double> ratings = new ArrayList<>();

    public ConsumerActivity(String activityName) {
        this.activityName = activityName;
    }

    /**
     * @return String
     */
    public String getActivityName() {
        return this.activityName;
    }

    /**
     * @param activityName
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * @return double
     */
    public double getOverallRating() {
        return this.overallRating;
    }

    /**
     * @param rating
     */
    public void addRating(double rating) {
        ratings.add(rating);
        updateOverallRating();
    }

    private void updateOverallRating() {
        double sum = 0;
        double average;

        for (double rating : ratings) {
            sum += rating;
        }
        average = sum / ratings.size();

        this.overallRating = average;
    }

}
