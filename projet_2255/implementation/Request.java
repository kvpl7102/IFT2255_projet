public class Request {
    private String description;
    private String id;

    public Request(String id) {
        this.description = "";
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return this.id;
    }
}
