import java.util.ArrayList;

public class Resident extends User {
    private ArrayList<Bin> residentBins = new ArrayList<>();
    private ArrayList<ConsumerActivity> notedActivities = new ArrayList<ConsumerActivity>();

    public Resident(String id, String password, String name, String phoneNum, String address) {
        super(id, password, name, phoneNum, address);

        Bin bin1 = new Bin(BinType.ORDURE,"qr1","bin1","null");
        bin1.setFillLevel(40);
        Bin bin2 = new Bin(BinType.RECYCLAGE,"qr1","bin1","null");
        bin2.setFillLevel(35);
        addBin(bin1);
        addBin(bin2);
        bin2.setBinStateType(BinStateType.TREATING);
        //initial bins;
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

    public ArrayList<ConsumerActivity> getActivities(){
        return this.notedActivities;
    }

}
