package example.codeclan.com.friendshiptracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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

        Friend currentFriend = getItem(position);
        TextView daysRemaining = (TextView) listItemView.findViewById(R.id.days_remaining);
        daysRemaining.setText(currentFriend.getDaysRemaining().toString());

        TextView firstName = (TextView) listItemView.findViewById(R.id.first_name);
        firstName.setText(currentFriend.getFirstName());

        TextView lastName = (TextView) listItemView.findViewById(R.id.last_name);
        lastName.setText(currentFriend.getLastName());

        listItemView.setTag(currentFriend);

        return listItemView;

    }
}
