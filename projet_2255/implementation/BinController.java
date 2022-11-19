import java.util.Scanner;

public class BinController implements Controller {

    Resident resident;

    public void setResident(User resident) {
        this.resident = (Resident) resident;
    }

    public void addNewBin() {
        String binType = "";
        String composition = "";

        System.out.println("Select which type of bin you want: ");
        System.out.println("1. Compost bin (brown bin)");
        System.out.println("2. Recycle bin (green bin)");
        System.out.println("3. Garbage bin (black bin)");

        Scanner scanner = new Scanner(System.in);
        int binChoice = scanner.nextInt();

        switch (binChoice) {
            case 1:
                binType = "Compost";
                composition = "Organic waste (fruits, vegetables, meat, bones, etc); Green waste (leaves, flowers, grasses, etc)";
                break;

            case 2:
                binType = "Recycle";
                composition = "Fibres (magazines, paper bags, etc); Glass (clean bottles, jars, etc), Empty containers (cartons, boxes, cans, etc)";
                break;

            case 3:
                binType = "Garbage";
                composition = "Plastic; Household waste; Household appliances";
                break;

            default:
                break;
        }
        System.out.print("Enter QR code for your bin: ");
        String codeQr = scanner.next();

        Bin newBin = new Bin(binType, codeQr, composition);
        resident.addBin(newBin);

        System.out.println("\nBIN REGISTERED SUCCESSFULLY!");

    }

}
