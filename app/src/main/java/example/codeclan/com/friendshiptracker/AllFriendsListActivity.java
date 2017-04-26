package example.codeclan.com.friendshiptracker;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AllFriendsListActivity extends AppCompatActivity {

    Date rightNow = Calendar.getInstance().getTime();
    String titleDate = NiceDate.getNiceDate(rightNow);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Friendship Tracker " + titleDate);

        Button openContactsButton = (Button) findViewById(R.id.open_contacts_button);
        openContactsButton.setVisibility(View.VISIBLE);

        setContentView(R.layout.activity_all_friends_list);
        Log.d(getClass().toString(), "friends list page loaded");

//        Intent intent = getIntent();

        FriendsList friendsList = new FriendsList(this);
        ArrayList<Friend> list = friendsList.getList();

        AllFriendsAdapter friendsAdapter = new AllFriendsAdapter(this,list);

        ListView listView = (ListView) findViewById(R.id.friends_list);
        listView.setAdapter(friendsAdapter);

    }

    public void update() {
        FriendsList friendsList = new FriendsList(this);
        ArrayList<Friend> list = friendsList.getList();

        AllFriendsAdapter friendsAdapter = new AllFriendsAdapter(this,list);

        ListView listView = (ListView) findViewById(R.id.friends_list);
        listView.setAdapter(friendsAdapter);
    }


    public void getFriend(View listItem){
       Friend friend = (Friend) listItem.getTag();
    }

    public void resetButtonClicked(View button) {
        Friend friend = (Friend) button.getTag();
        friend.resetDays();
        DBHandler dbHandler = new DBHandler(this);
        Date rightNow = Calendar.getInstance().getTime();
        Log.d("the date and time is", rightNow.toString());
        dbHandler.updateFriend(friend);
        this.update();

    }

    public void deleteButtonClicked(View button){
        Friend friend = (Friend) button.getTag();
        DBHandler dbHandler = new DBHandler(this);
        dbHandler.deleteFriend(friend);
        Log.d(friend.getFirstName(), "was deleted");
        this.update();
    }

    public void openContactsButtonClicked(View button){
        Log.d(getClass().toString(), "open contacts button clicks");
        Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);
    }
}
