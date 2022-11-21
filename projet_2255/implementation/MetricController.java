import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MetricController {

    ArrayList<Double> listNc = new ArrayList<Double>(Arrays.asList(30.0, 40.0, 50.0)); // tableau de proportion de
                                                                                       // chaque catégorie du bac de
                                                                                       // compostage

    ArrayList<Double> listNr = new ArrayList<Double>(Arrays.asList(60.0, 80.0, 45.0)); // tableau de proportion de
                                                                                       // chaque catégorie du bac de
                                                                                       // recyclage

    ArrayList<Double> listEc = new ArrayList<Double>(Arrays.asList(45.9, 68.5, 12.0)); // tableau d'usage des déchets
                                                                                       // compostables

    ArrayList<Double> listEr = new ArrayList<Double>(Arrays.asList(10.0, 20.0, 3.5)); // tableau d'usage des déchets
                                                                                      // recyclables

    double Pr = 34; // Poids du recyclage
    double Pc = 25; // Poids du compostage
    double Po = 67; // Poids des ordures

    double Nr = 60; // Niveau de remplissage du bac de recyclage
    double Nc = 80; // Niveau de remplissage du bac de compostage
    double No = 40; // Niveau de remplissage du bac des ordures

    double PNr = Pr * Nr;
    double PNc = Pc * Nc;
    double PNo = Po * No;

    double Cr = 55; // Cout du recyclage
    double Cc = 50; // Cout du compostage
    double Co = 45; // Cout des ordures
    double CIM = 100; // Cout idéal max des activités

    double CN = calculateCN(); // Cout positif/negatif
    double PNU = calculatePNU(listNr, listNc, listEr, listEc); // Facteur positif/negatif en fonction de l'usage
    double PNUI = calculatePNUI(listNr, listNc, listEr, listEc); // Facteur positif/negatif en fonction de l'usage idéal

    /**
     * Methode de calculer le niveau de participation au composte
     * 
     * @param listNc tableau de proportion de chaque catégorie du bac de compostage
     * @param listEc tableau d'usage des déchets compostables
     * 
     * @return niveau de participation au composte
     */
    public double calculateUc(ArrayList<Double> listNc, ArrayList<Double> listEc) {

        double Nc1 = listNc.get(0);
        double Nc2 = listNc.get(1);
        double Nc3 = listNc.get(2);

        double Ec1 = listEc.get(0);
        double Ec2 = listEc.get(1);
        double Ec3 = listEc.get(2);

        return (Nc1 * Ec1 + Nc2 * Ec2 + Nc3 * Ec3) / Collections.max(listEc);

    }

    /**
     * Methode de calculer le niveau de participation au recyclage
     * 
     * @param listNr tableau de proportion de chaque catégorie du bac de recyclage
     * @param listEr tableau d'usage des déchets recyclables
     * @return niveau de participation au recyclage
     */
    public double calculeUr(ArrayList<Double> listNr, ArrayList<Double> listEr) {

        double Nr1 = listNr.get(0);
        double Nr2 = listNr.get(1);
        double Nr3 = listNr.get(2);

        double Er1 = listEr.get(0);
        double Er2 = listEr.get(1);
        double Er3 = listEr.get(2);

        return (Nr1 * Er1 + Nr2 * Er2 + Nr3 * Er3) / Collections.max(listEr);
    }

    /**
     * Methode de calculer le facteur positif/negatif
     * 
     * @return facteur positif/negatif (PN)
     */
    public void calculatePN() {
        double PN = (PNr + PNc) / (PNo + 1);
        System.out.println("Filling ratio of recycling and composting compared to garbage: " + Math.round(PN) + "%");
    }

    /**
     * Methode de calculer le facteur PN en fonction de l'usage
     * 
     * @param listNr tableau de proportion de chaque catégorie du bac de recyclage
     * @param listNc tableau de proportion de chaque catégorie du bac de compostage
     * @param listEr tableau d'usage des déchets recyclables
     * @param listEc tableau d'usage des déchets compostables
     * 
     * @return facteur PNU
     */
    public double calculatePNU(ArrayList<Double> listNr,
            ArrayList<Double> listNc,
            ArrayList<Double> listEr,
            ArrayList<Double> listEc) {

        double Ur = calculeUr(listNr, listEr);
        double Uc = calculateUc(listNc, listEc);

        return Math.log((PNr * Ur + PNc * Uc + 1) / (PNo + 1));

    }

    /**
     * Methode de calculer le facteur PNU idéal
     * avec Nr = Nc = 100; No = 0
     * 
     * @param listNr tableau de proportion de chaque catégorie du bac de recyclage
     * @param listNc tableau de proportion de chaque catégorie du bac de compostage
     * @param listEr tableau d'usage des déchets recyclables
     * @param listEc tableau d'usage des déchets compostables
     * 
     * @return facteur PNU idéal
     */
    public double calculatePNUI(ArrayList<Double> listNr,
            ArrayList<Double> listNc,
            ArrayList<Double> listEr,
            ArrayList<Double> listEc) {

        double Ur = calculeUr(listNr, listEr);
        double Uc = calculateUc(listNc, listEc);

        return Math.log(((Pr * 100) * Ur + (Pc * 100) * Uc + 1));
    }

    /**
     * Methode de calculer cout positif/negatif
     * 
     * @return cout positif/negatif (CN)
     */
    public double calculateCN() {
        return ((Nr * Cr + Nc * Cc + No * Co - CIM) / CIM);
    }

    public void showMetrics() {

        System.out.println("\n=================================================");

        calculatePN();
        System.out.println("Ecology score: " + (PNU / PNUI));
        System.out.println("Economy score: " + (1 - Math.max(0, CN)));
    }

}
