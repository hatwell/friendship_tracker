package example.codeclan.com.friendshiptracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.Date;

public class AddFriendActivity extends AppCompatActivity {

    public DBHandler myDb;

    //form fields
    private EditText add_first_name; //this is the field's ID
    private EditText add_last_name;
    private EditText add_days_total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Log.d(getClass().toString(),"the adding friend form has loaded!!");


        //TODO in this section i cast all my form fields
        add_first_name = (EditText) findViewById(R.id.add_first_name);
        add_last_name = (EditText) findViewById(R.id.add_last_name);
        add_days_total = (EditText) findViewById(R.id.add_days_total);


    }


    public void addFriendButtonClicked(View button) {

        //TODO here is where you assign the form input to variables
        String first_name = add_first_name.getText().toString();
        String last_name = add_last_name.getText().toString();
        String days_total = add_days_total.getText().toString();

        int number_days_total = Integer.parseInt(days_total);


        //

        myDb = new DBHandler(this);
        Date date = new Date();

        Log.d(getClass().toString(), "i'm clicking my add friend button");

        Friend newFriend = new Friend(first_name, last_name, number_days_total);

        myDb.addFriend(newFriend);
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
