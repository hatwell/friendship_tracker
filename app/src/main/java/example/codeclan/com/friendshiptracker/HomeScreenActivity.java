package example.codeclan.com.friendshiptracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity {
    private Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        enterButton = (Button) findViewById(R.id.enter_button);
    }

    public void enterButtonClicked(View button){

        Intent intent = new Intent(this, AddFriendActivity.class);

        startActivity(intent);
    }
}
