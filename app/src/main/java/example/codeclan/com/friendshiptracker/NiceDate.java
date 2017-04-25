package example.codeclan.com.friendshiptracker;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 24/04/2017.
 */

public class NiceDate {



    public NiceDate(){

    }

    public static String getNiceDate(Date date) {
        String dateString = date.toString();
        String yearString = date.toString().substring(30);
        String dayString = dateString.substring(0, 10);
        return dayString + ", " + yearString;
    }

}
