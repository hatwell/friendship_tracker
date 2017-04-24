package example.codeclan.com.friendshiptracker;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 24/04/2017.
 */

public class FriendListTest {
    FriendsList testFriendList;
    Context context;

    @Before

    public void before() {
        testFriendList = new FriendsList(context);
    }

    @Test
    public void testListExists(){
        assertNotNull(testFriendList.getListSize());
        System.out.println(testFriendList.getListSize());
    }

}
