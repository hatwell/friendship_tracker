package example.codeclan.com.friendshiptracker;

import java.util.List;

/**
 * Created by user on 21/04/2017.
 */

public class FriendsList {

    public FriendsList() {
        List<Friend> friendList;

        DBHandler friendsDb = new DBHandler(this);

        friendList = friendsDb.getAllFriends();
    }

    public List<Friend> getList() {
        return this.friendList;
    }
}
