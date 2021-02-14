package bean;
import java.util.*;
public class User {
	private static final long serialVersionUID = 1 L;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    
    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void getPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
