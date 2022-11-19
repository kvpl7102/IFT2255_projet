public class Bin {

    private String codeQr;
    private String binType;
    private double fillLevel;
    private String composition;

    public Bin(String binType, String codeQr, String composition) {
        this.fillLevel = 0;
        this.binType = binType;
        this.codeQr = codeQr;
        this.composition = composition;

    }

    public String getComposition() {
        return this.composition;
    }

    public double getFillLevel() {
        return this.fillLevel;
    }

    public void setFillLevel(double fillLevel) {
        this.fillLevel = fillLevel;
    }

    public String getType() {
        return this.binType;
    }

    public String getCodeQr() {
        return this.codeQr;
    }

    public void printState() {
        System.out.print("QR code: " + this.getCodeQr() + " | ");
        System.out.print("Fill Level: " + this.getFillLevel() + "% " + " | ");
        System.out.print("Type: " + this.getType() + " | ");
        System.out.println("Composition: " + this.getComposition());
        System.out.println("=======================");
    }

}
