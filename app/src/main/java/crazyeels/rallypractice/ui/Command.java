package crazyeels.rallypractice.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import crazyeels.rallypractice.R;
import crazyeels.rallypractice.models.NoviceCommand;


public class Command extends AppCompatActivity {
    private NoviceCommand noviceCommand = new NoviceCommand();
    private TextView heading;
    private TextView commandTextView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        heading = (TextView) findViewById(R.id.intro);
        commandTextView = (TextView) findViewById(R.id.content);
        nextButton = (Button) findViewById(R.id.submitButton);

        View.OnClickListener nextCommand = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Remove Let's Practice Heading
                heading.setVisibility(View.GONE);

                // Update the screen with new command
                String nCommand = noviceCommand.getNoviceCommand();
                commandTextView.setText(nCommand);
                nextButton.setText("ANOTHER");
            }
        } ;

        nextButton.setOnClickListener(nextCommand);

    }
}
