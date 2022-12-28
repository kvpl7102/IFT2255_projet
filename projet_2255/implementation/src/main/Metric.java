import java.util.ArrayList;

public class Metric {

    //prologe class to menage residents' personal metric.

    double AverageFillLvl = 0;
    BinController binsC;
    UserController usersC;
    MetricController metricC;
    Resident res;
    ArrayList<Bin> binsRes = new ArrayList<Bin>();

    public Metric(MetricController controller, Resident res) {
        this.binsC = controller.getBinController();
        this.usersC = controller.getUsersController();
        this.metricC = controller;
        this.res = res;
        this.binsRes = res.getBinsList();
        this.binsRes = res.getBinsList();

    }

    /**
     * @return double
     */
    // all those are resident level's metric.

    // This function is to calculate the average number of bins owned by the
    // resident, which can reflect the average garbage generation level and
    // classification degree of the person.

    public double calAverageFillLevelRes() {
        double averageFillLevelRes = 0;

        for (int i = 0; i < binsRes.size(); i++) {
            averageFillLevelRes = (averageFillLevelRes * i + binsRes.get(i).getFillLevel()) / (i + 1); // averageFillLevel
                                                                                                       // * i is the sum
                                                                                                       // of levels for
                                                                                                       // all other bins
                                                                                                       // + current bin
                                                                                                       // / number of
                                                                                                       // bins.
        }
        return averageFillLevelRes;
    }

    /**
     * @return double
     */
    // This ratio is the comparison between the public garbage collection rate and
    // the individual
    // residents' garbage collection rate. The higher the ratio, the greater the
    // contribution of residents to recycling garbage.

    public double calRatioRecyRate() {
        ArrayList<Bin> recyBins = new ArrayList<Bin>();

        double recyLvPub = this.metricC.calAverageFillLevel();

        for (int i = 0; i < this.binsC.getBins().size(); i++) {
            if (this.binsC.getBins().get(i).getType() == BinType.RECYCLAGE) {

                recyBins.add(this.binsC.getBins().get(i));
            }
        }

        double recyLvRes = 0;
        for (int i = 0; i < recyBins.size(); i++) {

            recyLvRes = ((recyLvRes * i) + recyBins.get(i).getFillLevel()) / (i + 1);
        }
        double rateRes = recyLvRes / calAverageFillLevelRes();

        double ratioRecyRate = rateRes / recyLvPub;

        ratioRecyRate = (double) Math.round(ratioRecyRate * 100) / 100;

        return ratioRecyRate;
    }

    /**
     * @return double
     */
    // calculate the current utilisation of fillLevel for all bins from this
    // resident
    public double calUtilisationRate() {
        double average = calAverageFillLevelRes();
        double utilisation = average / (100 - average);
        return utilisation;

    }

    public void showMetricRes() {
        System.out.println("\n=================================================");

        System.out.println("RatioRecyRate score: " + (calRatioRecyRate()));
        System.out.println("AverageFillLevelRes score: " + (calAverageFillLevelRes()));
        System.out.println(" bin utilization rate: " + (calUtilisationRate()));

        System.out.println("\n=================================================");

    }
}