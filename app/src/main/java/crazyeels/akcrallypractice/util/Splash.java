package crazyeels.akcrallypractice.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import crazyeels.akcrallypractice.R;
import crazyeels.akcrallypractice.ui.Command;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent(this, Command.class);
        startActivity(intent);
        finish();
    }
}