import java.util.ArrayList;

public class Resident extends User {
    private ArrayList<Bin> residentBins = new ArrayList<>();

    public Resident(String id, String password, String name, String phoneNum, String address) {
        super(id, password, name, phoneNum, address);

    }

    public void addBin(Bin bin) {
        residentBins.add(bin);
    }

    public void removeBin(int index) {
        residentBins.remove(index);
    }

    public ArrayList<Bin> getBinsList() {
        return this.residentBins;
    }

    public void printResidentBins() {

        System.out.println('\n');
        for (int i = 0; i < residentBins.size(); i++) {
            System.out.println((i + 1) + ". " + residentBins.get(i).getName());
        }
    }

}
