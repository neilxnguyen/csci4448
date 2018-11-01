public class User {
    public int id;
    public String userEmail;
    public String mobile;
    public String userType;
    public String firstName;
    public String lastName;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return lastName + firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String name) {
        firstName = name;
    }
    public void setLastName(String name) {
        lastName = name;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
}


