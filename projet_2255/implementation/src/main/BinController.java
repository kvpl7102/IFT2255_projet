import java.util.ArrayList;
import java.util.Scanner;

//controller for class bin
public class BinController implements Controller {

    private ArrayList<Bin> bins = new ArrayList<Bin>();

    /**
     * @return ArrayList<Bin>
     */
    public ArrayList<Bin> getBins() {
        return this.bins;
    }

    /**
     * @param bin
     */
    public void removeBin(Bin bin) {
        bins.remove(bin);
    }

    /**
     * @return Bin
     */
    public Bin addNewBin() {
        BinType binType = BinType.COMPOSTAGE;
        String composition = "";
        String codeQr;
        String binName;

        System.out.println("Select type of bin you want to register: ");
        System.out.println("1. COMPOST (brown bin)");
        System.out.println("2. RECYCLE (green bin)");
        System.out.println("3. GARBAGE (black bin)");

        Scanner scanner = new Scanner(System.in);
        int binChoice = scanner.nextInt();

        switch (binChoice) {

            case 1:
                binType = BinType.COMPOSTAGE;
                composition = "Organic waste (fruits, vegetables, meat, bones, etc); Green waste (leaves, flowers, grasses, etc)";
                break;

            case 2:
                binType = BinType.RECYCLAGE;
                composition = "Fibers (magazines, paper bags, etc); Glasses (clean bottles, jars, etc), Empty containers (cartons, boxes, cans, etc)";
                break;

            case 3:
                binType = BinType.ORDURE;
                composition = "Unrecyclable household wastes";
                break;

            default:
                break;
        }

        System.out.print("Enter your bin name: ");
        binName = scanner.next();

        System.out.print("Enter QR code for your your bin: ");
        codeQr = scanner.next();

        System.out.println(codeQr);

        Bin newBin = new Bin(binType, codeQr, binName, composition);
        newBin.setStartTime();
        newBin.setBinStateType(BinStateType.AVAILABLE);
        return newBin;

    }

}
