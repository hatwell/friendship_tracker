package example.codeclan.com.friendshiptracker;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by user on 21/04/2017.
 */

public class FriendsList {

    private ArrayList<Friend> friendList;
    private Context context;

    public FriendsList() {
        ArrayList<Friend> friendList;

        DBHandler friendsDb = new DBHandler(context);

        this.friendList = friendsDb.getAllFriends();
    }

    public ArrayList<Friend> getList() {
        return this.friendList;
    }
}
