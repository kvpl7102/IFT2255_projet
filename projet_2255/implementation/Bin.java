import java.util.Date;

public class Bin {

    private String codeQr;
    private String binName;
    private String binType;
    private double fillLevel;
    private String composition;
    private BinStateType stateType;
    private Date timeStart;

    public Bin(String binType, String codeQr, String binName, String composition) {
        this.fillLevel = 0;
        this.binType = binType;
        this.codeQr = codeQr;
        this.binName = binName;
        this.composition = composition;

    }

    public void setStartTime(){
        this.timeStart = new Date();
    }
    
    public Date getStartTime(){
        return timeStart;

    }

    public String getComposition() {
        return this.composition;
    }

    public double getFillLevel() {
        return this.fillLevel;
    }

    public void setBinStateType(BinStateType newType){
        this.stateType = newType;
    }

    
    public BinStateType getBinStateType(){
        return this.stateType;

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

    public String getName() {
        return this.binName;
    }

    public void printState() {
        System.out.print("QR code: " + this.getCodeQr() + " | ");
        System.out.print("Bin name: " + this.getName() + " | ");
        System.out.print("Fill Level: " + this.getFillLevel() + "% " + " | ");
        System.out.print("Type: " + this.getType() + " | ");
        System.out.println("Composition: " + this.getComposition());
        System.out.println("=======================");
    }

}
