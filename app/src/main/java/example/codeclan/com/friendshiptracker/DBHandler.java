package example.codeclan.com.friendshiptracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by user on 20/04/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 555;

    //Database Name
    private static final String DATABASE_NAME = "friends_info";

    //Friends Table Name
    private static final String TABLE_FRIENDS = "friends";

    //Friends Table column names
    private static final String KEY_ID = "id ";
    private static final String KEY_FIRST_NAME = "first_name ";
    private static final String KEY_LAST_NAME = "last_name ";
    private static final String KEY_TOTAL_DAYS = "total_days ";
    private static final String KEY_DAYS_REMAINING = "days_remaining ";
    private static final String KEY_DATE_SET = "date_set ";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private String firstName;
    private String lastName;
    private int totalDays;
    private int daysRemaining;
    private Date dateSet;
    public Date today = Calendar.getInstance().getTime();


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_FRIENDS + "(" +
                KEY_ID + "INTEGER PRIMARY KEY, " +
                KEY_FIRST_NAME + "TEXT, " +
                KEY_LAST_NAME + "TEXT, " +
                KEY_TOTAL_DAYS + "INTEGER, " +
                KEY_DAYS_REMAINING + "INTEGER, " +
                KEY_DATE_SET + "INTEGER" +")";
        db.execSQL(CREATE_FRIENDS_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if older existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);
        //Creating tables again
        onCreate(db);
    }

    //Adding new friend

    public void addFriend(Friend friend) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, friend.getFirstName());
        values.put(KEY_LAST_NAME, friend.getLastName());
        values.put(KEY_TOTAL_DAYS, friend.getTotalDays());
        values.put(KEY_DATE_SET, friend.getDateSet());

        /*TODO some kinda datatype discrepancy here*/
        db.insert(TABLE_FRIENDS, null, values);
        db.close();
    }

    //TODO Getting a friend


//
    //get list of all friends
    public ArrayList<Friend> getAllFriends() {


        ArrayList<Friend> friendList = new ArrayList<Friend>();


        String selectQuery = "SELECT * FROM " + TABLE_FRIENDS;
            SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Log.d(getClass().toString(), DatabaseUtils.dumpCursorToString(cursor));
                Friend friend = new Friend();
                friend.setId(Integer.parseInt(cursor.getString(0)));
                friend.setFirstName(cursor.getString(1));
                friend.setLastName(cursor.getString(2));
                friend.setTotalDays(Integer.parseInt(cursor.getString(3)));
                friend.setDateSet(Long.parseLong(cursor.getString(5)));

                friendList.add(friend);

            }
            while (cursor.moveToNext());
        }

        cursor.close();

        return friendList;

    }

    //Get friends count
    public int getFriendsCount() {
        String countQuery = "SELECT * FROM" + TABLE_FRIENDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }


    public int updateFriend(Friend friend) {
        long todayAsLong;
        todayAsLong = today.getTime();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, friend.getFirstName());
        values.put(KEY_LAST_NAME, friend.getLastName());
        values.put(KEY_TOTAL_DAYS, friend.getTotalDays());
        values.put(KEY_DATE_SET, String.valueOf(todayAsLong));

        return db.update(TABLE_FRIENDS, values, KEY_ID + "=?",
                new String[]{String.valueOf(friend.getId())});

    }

    public void deleteFriend(Friend friend) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FRIENDS, KEY_ID + "= ?",
                new String[] {String.valueOf(friend.getId())});

    }


}
