package crazyeels.rallypractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Command extends AppCompatActivity {

    private TextView commandTextView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        commandTextView = (TextView) findViewById(R.id.content);
        nextButton = (Button) findViewById(R.id.submitButton);

        View.OnClickListener nextCommand = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // List of Commands which will randomly displayed
                String [] commands = {
                    "#3 - Sit",
                    "#4 - Sit, Down",
                    "#5 - Right Turn",
                    "#6 - Left Turn",
                    "#7 - About Turn Right",
                    "#8 - About 'U' Turn",
                    "#9 - 270° Right",
                    "#10 - 270° Left",
                    "#11 - 360° Right",
                    "#12 - 360° Left",
                    "#13 - Call Front, Finish Right, Forward",
                    "#14 - Call Front, Finish Left, Forward",
                    "#15 - Call Front, Finish Right, Forward",
                    "#16 - Call Front, Finish Left, Halt",
                    "#17 - Slow Pace",
                    "#18 - Fast Pace",
                    "#19 - Normal Pace",
                    "#20 - Moving Side Step Right",
                    "#21 - Spiral Right Dog Outside",
                    "#22 - Spiral Left Dog Inside",
                    "#23 - Straight Figure 8 Weave Twice",
                    "#24 - Serpentine Weave Once",
                    "#25 - 1 Step, 2 Steps, 3 Steps",
                    "#26 - Call Front, 1 Step, 2 Steps, 3 Steps",
                    "#27 - Down and Stop",
                    "#28 - Fast Forward From Sit",
                    "#29 - Left About Turn",
                    "#30 - Walk Around Dog",
                    "#31 - Down Walk Around Dog",
                    "#32 - Figure 8 No Distractions",
                    "#33 - Left Turn - Forward",
                    "#34 - Right Turn - Forward",
                    "#35 - Call Front, Return to Heel",
                    "#36 - Slow Forward From Sit"
                };

                // Randomly display a command within the set parameters
                Random randomizer = new Random();
                int randomCommand = randomizer.nextInt(commands.length);

                String command = commands[randomCommand];

                // Update the screen with new command
                commandTextView.setText(command);
            }
        } ;

        nextButton.setOnClickListener(nextCommand);

    }
}
