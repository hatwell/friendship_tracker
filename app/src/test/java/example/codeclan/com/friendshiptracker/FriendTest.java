package example.codeclan.com.friendshiptracker;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 24/04/2017.
 */

public class FriendTest {

    public Friend friend;
    public Date date;

    @Before
    public void before(){
        friend = new Friend("Friendly", "Bear", 100);
        date = new Date();
    }

    @Test
    public void friendHasName(){
        assertEquals("Friendly", friend.getFirstName());
    }

    @Test
    public void friendHasDate(){

        assertNotNull(friend.getDateSet());
        System.out.println(friend.getDateSet());

    }

    @Test
    public void friendHasDaysRemaining(){
        assertNotNull(friend.getDaysRemaining());
        System.out.println(friend.getDaysRemaining());

    }



}
