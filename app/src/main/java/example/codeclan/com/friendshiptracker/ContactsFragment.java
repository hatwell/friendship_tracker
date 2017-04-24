//package example.codeclan.com.friendshiptracker;
//
//import android.annotation.SuppressLint;
//import android.app.Fragment;
//import android.app.LoaderManager;
//import android.content.Loader;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.provider.ContactsContract;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.SimpleCursorAdapter;
//
//
///**
// * Created by user on 23/04/2017.
// */
//
//public class ContactsFragment extends Fragment implements
//        LoaderManager.LoaderCallbacks<Cursor>,
//        AdapterView.OnItemClickListener {
//
//    public ContactsFragment(){
//
//    }
//
//    @SuppressLint("InlinedApi")
//    private final static String[] FROM_COLUMNS = {
//            Build.VERSION.SDK_INT
//                    >= Build.VERSION_CODES.HONEYCOMB ?
//                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY :
//                    ContactsContract.Contacts.DISPLAY_NAME
//    };
//
//    private final static int[] TO_IDS = {
//            android.R.id.text1
//    };
//    // Define global mutable variables
//    // Define a ListView object
//    ListView mContactsList;
//    // Define variables for the contact the user selects
//    // The contact's _ID value
//    long mContactId;
//    // The contact's LOOKUP_KEY
//    String mContactKey;
//    // A content URI for the selected contact
//    Uri mContactUri;
//    // An adapter that binds the result Cursor to the ListView
//    private SimpleCursorAdapter mCursorAdapter;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the fragment layout
//        return inflater.inflate(R.layout.contacts_list_fragment,
//                container, false);
//    }
//
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        // Gets the ListView from the View list of the parent activity
//        mContactsList =
//                (ListView) getActivity().findViewById(R.layout.contact_list);
//        // Gets a CursorAdapter
//        mCursorAdapter = new SimpleCursorAdapter(
//                getActivity(),
//                R.layout.contacts_list_item,
//                null,
//                FROM_COLUMNS, TO_IDS,
//                0);
//        // Sets the adapter for the ListView
//        mContactsList.setAdapter(mCursorAdapter);
//    }
//
//
//
//
//
//
//
//}
