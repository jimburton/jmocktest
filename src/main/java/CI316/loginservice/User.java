package CI316.loginservice;

import java.util.Date;

public class User {
    private final long id;
    private final String userName;
    private final String password;

    public User(long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
