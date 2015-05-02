package Core;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Julien on 02.05.2015.
 *
 * This class serves as an general purpose adapter for HTTP networks.
 * It does primarily and ONLY perform POST requests.
 *
 * The implementation works with 2 strings:
 * params[0] -> 1st string | Actual URL
 * params[1] -> 2nd string | POST Parameters
 *
 *
 */

public class Networker extends AsyncTask<String, Void, String>{

    // Cookies must be saved in order to maintain the session and they have to be accessible globally.
    private static final CookieManager cookieJar = new CookieManager(null, CookiePolicy.ACCEPT_ALL);

    @Override
    protected String doInBackground(String... params) {

        try{
            CookieHandler.setDefault(cookieJar);

            HttpURLConnection connection = (HttpURLConnection) (new URL(params[0]).openConnection());
            connection.setDoOutput(true);
            new PrintStream(connection.getOutputStream()).write(params[1].getBytes());

            connection.getInputStream();

            //
            // TODO:
            //  Make the method return the response as a string.
            //

            return null;
        }
        catch(MalformedURLException e)
        {
            Log.w("Core.Networker","MalformedURLException:\t"+params[0]);
        }
        catch(IOException e)
        {
            Log.v("Core.Networker", "IOException!\t" + e.toString());
        }

        return null;
    }


}
