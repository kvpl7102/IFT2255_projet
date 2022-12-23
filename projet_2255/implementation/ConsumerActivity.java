import java.util.ArrayList;

public class ConsumerActivity {

    private String activityName;
    private double overallRating;
    private ArrayList<Double> ratings = new ArrayList<>();

    public ConsumerActivity(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getOverallRating() {
        return this.overallRating;
    }

    public void addRating(double rating) {
        ratings.add(rating);
        updateAverageRating();
    }

    private void updateAverageRating() {
        double sum = 0;
        double average;

        for (double rating : ratings) {
            sum += rating;
        }
        average = sum / ratings.size();

        overallRating = average;
    }

}
