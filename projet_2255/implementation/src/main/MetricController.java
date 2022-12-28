import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MetricController implements Controller {
    //prologe: controller for all system's global metric
    
    private int userNb, residentNb, consNb;
    private int binNb;
    private int binCompNb, binRecyNb, binOrdureNb;
    private ArrayList<Bin> recyBins = new ArrayList<Bin>();

    private UserController users;
    private BinController bins;
    private double averageFillLevel = 0;

    public MetricController(UserController users, BinController bins) {
        this.userNb = users.getUsers().size();
        this.residentNb = users.getResidents().size();
        this.consNb = users.getConsumers().size();
        this.bins = bins;
        this.users = users;

        this.binNb = bins.getBins().size();
        for (int i = 0; i < this.binNb; i++) { // After all the bins, several numerical calculations are performed.
            if (bins.getBins().get(i).getType() == BinType.COMPOSTAGE) {
                this.binCompNb = this.binCompNb + 1;
                recyBins.add(bins.getBins().get(i));
            }

            if (bins.getBins().get(i).getType() == BinType.RECYCLAGE) {
                this.binRecyNb = this.binRecyNb + 1;
            }

            if (bins.getBins().get(i).getType() == BinType.ORDURE) {
                this.binOrdureNb = this.binOrdureNb + 1;
            }

        }

    }

    /**
     * @return UserController
     */
    public UserController getUsersController() {
        return this.users;
    }

    /**
     * @return BinController
     */
    public BinController getBinController() {
        return this.bins;
    }

    /**
     * @return double
     */
    // all those fonctions are for municipal levels

    // This is to calculate the average number of bins owned by each resident, which
    // can reflect the average garbage generation level and classification degree of
    // residents.
    public double calNbBinPerRes() {
        double nbBinPerRes = this.binNb / (this.residentNb + 0.01);// +1 to avoid dividing by zero;

        nbBinPerRes = (double) Math.round(nbBinPerRes * 100) / 100; // arrondir
        return nbBinPerRes;
    }

    /**
     * @return double
     */
    // calAverageFillLevel is to calculate the average fill level of all bins, which
    // can reflect the degree of garbage retention in the city
    public double calAverageFillLevel() {
        for (int i = 0; i < bins.getBins().size(); i++) {
            this.averageFillLevel = (this.averageFillLevel * i + bins.getBins().get(i).getFillLevel()) / (i + 1); // averageFillLevel
                                                                                                                  // * i
                                                                                                                  // is
                                                                                                                  // the
                                                                                                                  // sum
                                                                                                                  // of
                                                                                                                  // levels
                                                                                                                  // for
                                                                                                                  // all
                                                                                                                  // other
                                                                                                                  // bins
                                                                                                                  // +
                                                                                                                  // current
                                                                                                                  // bin
                                                                                                                  // /
                                                                                                                  // number
                                                                                                                  // of
                                                                                                                  // bins.
        }
        return this.averageFillLevel;
    }

    /**
     * @return double
     */
    // recyclageLevel is the recycling rate of garbage, which can reflect the
    // efficiency of urban residents' activities on garbage recycling. calcul by
    // FillLevel Recy / FillLevel for all
    public double calRecyRate() {
        double recyLv = 0;
        for (int i = 0; i < this.recyBins.size(); i++) {

            recyLv = ((recyLv * i) + this.binRecyNb * this.recyBins.get(i).getFillLevel());

        }
        double rate = recyLv / calAverageFillLevel();
        return rate;
    }

    public void showMetrics() {

        System.out.println("\n=================================================");

        System.out.println("NbBinPerRes score: " + (calNbBinPerRes()));
        System.out.println("AverageFillLevel score: " + (calAverageFillLevel()));
        System.out.println("RecyclageLevel score: " + (calRecyRate()));

        System.out.println("\n=================================================");

    }

}
