package Core;

/**
 * Created by Julien on 02.05.2015.
 *
 * This class serves as an interface to the website.
 *
 * Instances can only be retrieved through the LogIn-method,
 * since it can fail due to wrong user data.
 *
 */

public class Session {

    private Session()
    {}

    public static Session logIn(String username, String password)
    {
        return new Session();
    }

}
