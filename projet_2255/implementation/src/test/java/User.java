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

    /**
     * @param name
     * @param phoneNum
     * @param address
     */
    public void editInfo(String name, String phoneNum, String address) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    /**
     * @return String
     */
    public String getId() {
        return this.email;
    }

    /**
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @return String
     */
    public String getPhoneNum() {
        return this.phoneNum;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param email
     */
    public void setId(String email) {
        this.email = email;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
