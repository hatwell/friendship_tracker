package example.codeclan.com.friendshiptracker;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 24/04/2017.
 */

public class DateTest {
    Date date;

    @Before
    public void before(){
        date = new Date();

    }

    @Test
    public void testDateExists(){
        assertNotNull(date);
        String dateString = date.toString();
        String yearString = date.toString().substring(23);
        String dayString = dateString.substring(0, 10);
        String prettyDate = dayString + "," + yearString;
        System.out.println(prettyDate);
    }
}
