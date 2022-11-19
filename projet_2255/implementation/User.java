public class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private String address;
    private String telephone;
    private Request request;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        request = new Request(id);
    }

    public void editInfo(String name, String email, String telephone, String address) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getRequest() {
        return this.request.getDescription();
    }

    public void updateRequest(String description) {
        this.request.setDescription(description);
    }

    public void deleteRequest() {
        this.request.setDescription("");
    }

}
