package crazyeels.rallypractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Command extends AppCompatActivity {

    private TextView commandTextView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        commandTextView = (TextView) findViewById(R.id.content);
        nextButton = (Button) findViewById(R.id.mailButton);

        View.OnClickListener nextCommand = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        } ;

        nextButton.setOnClickListener(nextCommand);
    }
}
