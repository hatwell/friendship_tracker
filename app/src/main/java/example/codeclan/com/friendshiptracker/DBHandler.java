package example.codeclan.com.friendshiptracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;


/**
 * Created by user on 20/04/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "friendsinfo";

    //Friends Table Name
    private static final String TABLE_FRIENDS = "friends";

    //Friends Table column names
    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_TOTAL_DAYS = "total_days";
    private static final String KEY_DAYS_REMAINING = "days_remaining";
    private static final String KEY_DATE_SET = "date_set";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }







    private String firstName;
    private String lastName;
    private int totalDays;
    private int daysRemaining;
    private Date dateSet;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRIENDS_TABLE = "CREATE TABLE" + TABLE_FRIENDS + "(" +
                KEY_ID + "INTEGER PRIMARY KEY" +
                KEY_FIRST_NAME + "TEXT," +
                KEY_LAST_NAME + "TEXT" +
                KEY_TOTAL_DAYS + "DATE" +
                KEY_DAYS_REMAINING + "INTEGER" +
                KEY_DATE_SET + "DATE";


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
