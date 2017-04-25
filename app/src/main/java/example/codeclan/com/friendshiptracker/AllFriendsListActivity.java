package example.codeclan.com.friendshiptracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AllFriendsListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_friends_list);
        Log.d(getClass().toString(), "friends list page loaded");

        Intent intent = getIntent();

        FriendsList friendsList = new FriendsList(this);
        ArrayList<Friend> list = friendsList.getList();

        AllFriendsAdapter friendsAdapter = new AllFriendsAdapter(this,list);

        ListView listView = (ListView) findViewById(R.id.friends_list);
        listView.setAdapter(friendsAdapter);

    }



    public void getFriend(View listItem){
       Friend friend = (Friend) listItem.getTag();
        Log.d("friend name: ", friend.getFirstName());
    }

    public void resetButtonClicked(View button) {
        Friend friend = (Friend) button.getTag();
        friend.resetDays();
        DBHandler dbHandler = new DBHandler(this);
        Date rightNow = Calendar.getInstance().getTime();
        Log.d("the date and time is", rightNow.toString());
        dbHandler.updateFriend(friend);


    }
}
