package example.codeclan.com.friendshiptracker;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 21/04/2017.
 */

public class AllFriendsAdapter extends ArrayAdapter<Friend> {
    public AllFriendsAdapter(Context context, ArrayList<Friend> friends) {
        super(context, 0, friends);
    }


    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.all_friends_item, parent,false);
        }

        Date date_today = Calendar.getInstance().getTime();
        NiceDate niceDate = new NiceDate();


        //sets up each friend in the list
        Friend currentFriend = getItem(position);




        TextView daysRemaining = (TextView) listItemView.findViewById(R.id.days_remaining);
        daysRemaining.setText(Long.toString(currentFriend.getDaysRemaining()));
        if (currentFriend.getDaysRemaining() < 10) {
            daysRemaining.setBackgroundColor(Color.RED);
        }
        else {
            daysRemaining.setBackgroundColor(Color.TRANSPARENT);
        }



        //display first name
        TextView firstName = (TextView) listItemView.findViewById(R.id.first_name);
        firstName.setText(currentFriend.getFirstName());
//        Log.d("current friend id", String.valueOf(currentFriend.getId()));

        TextView lastName = (TextView) listItemView.findViewById(R.id.last_name);
        lastName.setText(currentFriend.getLastName());

        TextView dateSet = (TextView) listItemView.findViewById(R.id.date_set);
        dateSet.setText(NiceDate.getNiceDate(currentFriend.getDateSet()));
        Log.d("date set: ", NiceDate.getNiceDate(currentFriend.getDateSet()));

        TextView today = (TextView) listItemView.findViewById(R.id.today);
        today.setText(NiceDate.getNiceDate(date_today));
//        Log.d("date today: ", NiceDate.getNiceDate(date_today));

        Button resetButton = (Button) listItemView.findViewById(R.id.reset_button);
        resetButton.setVisibility(View.VISIBLE);

        Button deleteButton = (Button) listItemView.findViewById(R.id.delete_button);
        deleteButton.setVisibility(View.VISIBLE);

        Button contactButton = (Button) listItemView.findViewById(R.id.contact_friend_button);
        contactButton.setVisibility(View.VISIBLE);


        resetButton.setTag(currentFriend);
        deleteButton.setTag(currentFriend);
        contactButton.setTag(currentFriend);

        return listItemView;

    }
}
