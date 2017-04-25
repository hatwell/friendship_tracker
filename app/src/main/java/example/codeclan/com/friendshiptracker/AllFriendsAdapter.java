package example.codeclan.com.friendshiptracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
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

        Date date = new Date();
        NiceDate niceDate = new NiceDate();

        Friend currentFriend = getItem(position);
        TextView daysRemaining = (TextView) listItemView.findViewById(R.id.days_remaining);
        daysRemaining.setText(Long.toString(currentFriend.getDaysRemaining()));

        TextView firstName = (TextView) listItemView.findViewById(R.id.first_name);
        firstName.setText(currentFriend.getFirstName());

        TextView lastName = (TextView) listItemView.findViewById(R.id.last_name);
        lastName.setText(currentFriend.getLastName());

        TextView dateSet = (TextView) listItemView.findViewById(R.id.date_set);
        dateSet.setText(niceDate.getNiceDate(currentFriend.getDateSet()));

        TextView today = (TextView) listItemView.findViewById(R.id.today);
        today.setText(niceDate.getNiceDate(date));

        Button resetButton = (Button) listItemView.findViewById(R.id.reset_button);
        resetButton.setVisibility(View.VISIBLE);


        listItemView.setTag(currentFriend);

        return listItemView;

    }
}
