import CI316.loginservice.LoginService;
import CI316.loginservice.User;
import CI316.loginservice.UserDAO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;

import static junit.framework.TestCase.assertTrue;

public class LoginServiceTest {

    private long userID = 1234;
    private String userName = "testUserName";
    private String password = "password";
    private User user;
    private LoginService loginService;
    private Mockery context = new JUnit4Mockery();

    @Before
    public void setup() {
        user = new User(userID, userName, password);
        loginService = new LoginService() {
            private UserDAO userDAO;
            private String passwordHash = "[B@5e2de80c";
            public void setUserDAO(UserDAO userDao) {
                this.userDAO = userDao;
            }

            /**
             * Change this method so that it makes a SHA1 hash of the password
             * and returns true if it matches `passwordHash'
             * @param userName
             * @param password
             * @return
             */
            public boolean login(String userName, String password) {
                return false;
            }
        };
    }

    /**
     * This method will test the "rosy" scenario of passing a valid
     * username and password and retrieving the user.  Once the user
     * is returned to the service, the service will return true to
     * the caller.
     */
    @Test
    public void testLoginSucceedsIfUserKnown() {
        //setup the mock object and loginService
        final UserDAO userDAO = context.mock(UserDAO.class);
        loginService.setUserDAO(userDAO);

        //set the expectations
        context.checking(new Expectations() {{
            oneOf (userDAO).loadByUsernameAndPassword(userName, password);
            will(returnValue(true));
        }});

        //exercise the code
        assertTrue(loginService.login(userName, password));
    }

    /**
     * Write a test that fails if an unknown user (i.e. one with different data than used
     * in the previous test.
     */
    @Test
    public void testLoginFailsIfUserNotKnown() {
        assertTrue(false);
    }
}
