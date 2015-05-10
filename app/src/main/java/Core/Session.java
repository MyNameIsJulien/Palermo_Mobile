package Core;

import android.util.Log;

import java.util.concurrent.ExecutionException;

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

    private static String root_page = "http://palermo-game.com/";

    private Session()
    {}

    public static boolean register(String email, String username, String password)
    {

        /*

        This is the ajax code from the website. The request has to be the same.

        $.ajax({type: "POST", url: "register2.php",
        data: "registername=" + $("#registername").val() + "&registerpassword=" + $("#registerpassword").val() + "&registeremail=" + $("#registeremail").val() +
        "&recruiter=" + $("#recruiter").val(), success: function(msg){
	    $("#registerpasswordresponse").html(msg);
	    }});

        */
        try{
            String response = new Networker().execute(root_page+"register2.php","registername="+username+"&registerpassword="+password+"&registeremail="+email+"&recruiter=").get();
            Log.v("Core.Session", response);
            return (response == "");
        }
        catch (Exception e)
        {
            Log.v("Core.Session", "Exception");
            e.printStackTrace();
        }
        return false;
    }

    public static Session logIn(String username, String password)
    {

        /*

        This is the ajax code for the website. The request has to be the same.

        $.ajax({type: "POST", url: "login.php",
         data: "send=" + true + "&loginname=" + loginname + "&loginpassword=" + loginpassword + "&staylogged=" + staylogged,
         success: function(msg){$('#loginresponse').html(msg);
        }});
        */

        try
        {
            String response = new Networker().execute(root_page + "login.php", "send=true&loginname=" + username + "&loginpassword=" + password + "&staylogged=false").get();
            /*
            boolean b = "<script>window.open('lobby.html','_top','')</script>".equals(response);

            Log.v("Core.Session:LogIn","Length:\t" + response.length() + "\tActually response:\t" + "<script>window.open('lobby.html','_top','')</script>".length() );
            */
            return ("<script>window.open('lobby.html','_top','')</script>".equals(response) ? new Session() : null);
        }
        catch(Exception e)
        {
            Log.v("Core.Session", "Exception");
            e.printStackTrace();
            return null;
        }
    }

}
