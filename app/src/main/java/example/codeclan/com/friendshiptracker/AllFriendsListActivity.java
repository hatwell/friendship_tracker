package example.codeclan.com.friendshiptracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

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
}
