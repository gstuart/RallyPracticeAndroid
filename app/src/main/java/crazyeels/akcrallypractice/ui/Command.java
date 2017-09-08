package crazyeels.akcrallypractice.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import crazyeels.akcrallypractice.R;
import crazyeels.akcrallypractice.models.NoviceCommands;
import crazyeels.akcrallypractice.util.Nav_Drawer;


public class Main extends Nav_Drawer {

    private NoviceCommands noviceCommand = new NoviceCommands();
    private TextView heading;
    private ImageView commandImageView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        heading = (TextView) findViewById(R.id.intro);
        commandImageView = (ImageView) findViewById(R.id.content);
        nextButton = (Button) findViewById(R.id.submitButton);

        View.OnClickListener nextCommand = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("In On click", "yep");
                // Remove Let's Practice Heading
                heading.setVisibility(View.GONE);

                // Update the screen with new command
                Integer nCommand = noviceCommand.getNoviceCommand();
                commandImageView.setImageResource(nCommand);
                nextButton.setText(getString(R.string.another));
            }
        } ;

        nextButton.setOnClickListener(nextCommand);

    }
}
