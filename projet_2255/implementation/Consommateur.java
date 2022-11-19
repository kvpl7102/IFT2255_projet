import java.util.ArrayList;

public class Consommateur extends User {

    private String code;
    private String capacity;
    private String details;
    private double noteGeneral;
    public ArrayList<Double> notes = new ArrayList<>();
    private ArrayList<String> trashType = new ArrayList<>();

    public Consommateur(String id, String password, String code) {
        super(id, password);
        this.code = code;
        this.details = "";
        this.noteGeneral = 0;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetail(String details) {
        this.details = details;
    }

    public double getNote() {
        return this.noteGeneral;
    }

    public void calculateNoteGeneral() {
        int sum = 0;
        for (double note : notes) {
            sum += note;
        }
        noteGeneral = sum / notes.size();
    }

    public String getCapacity() {
        return this.capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public ArrayList<String> getTrashType() {
        return this.trashType;
    }

    @Override
    public String toString() {
        String info = "ID: " + this.getId() + " | " + "Code: " + this.getCode() + " | " +
                "Details: " + this.getDetails() + " | " + "General note " + this.getNote();

        return info;
    }
}
