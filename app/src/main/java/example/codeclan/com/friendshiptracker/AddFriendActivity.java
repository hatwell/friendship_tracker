package example.codeclan.com.friendshiptracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Date;

public class AddFriendActivity extends AppCompatActivity {

    public DBHandler myDb;
    public Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Log.d(getClass().toString(),"the adding friend form has loaded!!");
    }


    public void addFriendButtonClicked(View button) {

        Log.d(getClass().toString(), "i'm clking my add friend button");

        myDb.addFriend(first_name, last_name, days_total, date);
        Intent intent = new Intent(this, AllFriendsListActivity.class);

        startActivity(intent);

    }

    public void addFriend(Context context) {

    }


//
//    public void onCountButtonClicked(View button){
//
//        Log.d(getClass().toString(), "word counting button was clicked");
//        String wordsToBeCounted = wordsEditText.getText().toString();
//
//        Log.d(getClass().toString(), wordsToBeCounted);
//        Words myCounter = new Words(wordsToBeCounted);
//        myCountedWordsHash = myCounter.countWords();
//
//        Intent intent = new Intent(this, WordCountResultsActivity.class);
//
//        intent.putExtra("words", myCountedWordsHash.toString());
//        startActivity(intent);
//
//    }
}
