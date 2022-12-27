import java.util.Date;

public class Bin {

    private String codeQr;
    private String binName;
    private BinType binType;
    private double fillLevel;
    private String composition;
    private BinStateType stateType;
    private Date timeStart;

    public Bin(BinType binType, String codeQr, String binName, String composition) {
        this.fillLevel = 0;
        this.binType = binType;
        this.codeQr = codeQr;
        this.binName = binName;
        this.composition = composition;

        setStartTime();
        setBinStateType(BinStateType.AVAILABLE);

    }

    public void setStartTime() {
        this.timeStart = new Date();
    }

    /**
     * @return BinType
     */
    public BinType getBinType() {
        return this.binType;
    }

    /**
     * @return Date
     */
    public Date getStartTime() {
        return timeStart;

    }

    /**
     * @return String
     */
    public String getComposition() {
        return this.composition;
    }

    /**
     * @return double
     */
    public double getFillLevel() {
        return this.fillLevel;
    }

    /**
     * @param newType
     */
    public void setBinStateType(BinStateType newType) {
        this.stateType = newType;
    }

    /**
     * @return BinStateType
     */
    public BinStateType getBinStateType() {
        return this.stateType;

    }

    /**
     * @param fillLevel
     */
    public void setFillLevel(double fillLevel) {
        this.fillLevel = fillLevel;
    }

    /**
     * @return BinType
     */
    public BinType getType() {
        return this.binType;
    }

    /**
     * @return String
     */
    public String getCodeQr() {
        return this.codeQr;
    }

    /**
     * @return String
     */
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
