import java.util.ArrayList;

public class Resident extends User {
    private ArrayList<Bin> bins = new ArrayList<>();

    public Resident(String id, String password) {
        super(id, password);

    }

    public void addBin(Bin bin) {
        bins.add(bin);
    }

    public void removeBin(int index) {
        bins.remove(index);
    }

    public ArrayList<Bin> getBinList() {
        return this.bins;
    }

    public void printBins() {

        System.out.println('\n');
        System.out.println("=======================");
        for (int i = 0; i < bins.size(); i++) {
            System.out.println("Bin number " + (i + 1) + ": ");
            bins.get(i).printState();

        }
        System.out.println("=======================");
    }

    public void noterConsommateur(Consommateur consommateur, double note) {
        consommateur.notes.add(note);
    }
}
