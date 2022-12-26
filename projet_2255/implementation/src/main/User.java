public class User {
    private String email;
    private String password;
    private String name;
    private String address;
    private String phoneNum;

    public User(String email, String password, String name, String phoneNum, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public void editInfo(String name, String phoneNum, String address) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public String getId() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
