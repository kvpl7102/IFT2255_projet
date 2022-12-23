import java.util.ArrayList;
import java.util.Scanner;

public class BinController implements Controller {

    private ArrayList<Bin> bins = new ArrayList<Bin>();

    public ArrayList<Bin> getBins() {
        return bins;
    }

    public void removeBin(Bin bin) {
        bins.remove(bin);
    }

    public Bin addNewBin() {
        String binType = "";
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
                binType = "COMPOST";
                composition = "Organic waste (fruits, vegetables, meat, bones, etc); Green waste (leaves, flowers, grasses, etc)";
                break;

            case 2:
                binType = "RECYCLE";
                composition = "Fibers (magazines, paper bags, etc); Glasses (clean bottles, jars, etc), Empty containers (cartons, boxes, cans, etc)";
                break;

            case 3:
                binType = "GARBAGE";
                composition = "Unrecyclable household wastes";
                break;

            default:
                break;
        }

        System.out.print("Enter QR code for your bin: ");
        codeQr = scanner.nextLine();

        System.out.print("Enter your bin name: ");
        binName = scanner.nextLine();

        scanner.close();

        Bin newBin = new Bin(binType, codeQr, binName, composition);
        return newBin;

    }

}
