package example.codeclan.com.friendshiptracker;

import java.util.Date;

/**
 * Created by user on 24/04/2017.
 */

public class NiceDate {

    Date date;

    public NiceDate(){

    }

    public String getNiceDate(Date date) {
        String dateString = date.toString();
        String yearString = date.toString().substring(23);
        String dayString = dateString.substring(0, 10);
        return dayString + "," + yearString;
    }
}
