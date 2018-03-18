package CI316.loginservice;
/**
 * Provides database access for login related functions
 */
public interface UserDAO {

    /**
     * Loads a User object for the record that
     * is returned with the same userName and hash.
     *
     * @parameter userName
     * @parameter hash
     * @return    User
     */
    User loadByUsernameAndPassword(String userName, String hash);
}
