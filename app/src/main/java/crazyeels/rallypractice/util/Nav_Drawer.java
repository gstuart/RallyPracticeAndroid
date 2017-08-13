package crazyeels.rallypractice.util;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import crazyeels.rallypractice.R;
import crazyeels.rallypractice.models.NoviceCommand;


public class Nav_Drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    // variables for Command Activity
        private NoviceCommand noviceCommand = new NoviceCommand();
        private TextView heading;
        private TextView commandTextView;
        private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Methods for Command Activity
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
// Methods for Nav_Drawer
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            // Displays a series of images of the actual cards

        } else if (id == R.id.nav_videos) {
            // Takes user to youtube playlist of practice videos in a webViewer
            loadLink(Constants.youtube_url, "Novice Rally Playlist");

        } else if (id == R.id.nav_akc) {
            // Takes the user to the Rally page on the AKC website
            loadLink(Constants.akc_url, "AKC RALLY");


        } else if (id == R.id.nav_share) {
            // Allows user to share the app via text message, twitter, email, and Facebook


        } else if (id == R.id.nav_send) {
            // Takes the user to
            sendSupportEmail();

        } else if (id == R.id.nav_support) {
            // Generates an email, with device version, that user can write in and then send


        } else if (id == R.id.nav_rate) {
            // Takes the user to Google Play app review page
//            rateTheApp();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void rateTheApp() {
//        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
//        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY
//                | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
//                | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//
//        try {
//            startActivity(goToMarket);
//        } catch(ActivityNotFoundException e) {
//            startActivity(new Intent(Intent.ACTION_VIEW,
//                Uri.parse(getString(R.string.(Constants.google_play_store_prefix)) + this.getPackageName())));
//        }
//    }

    public void sendSupportEmail() {
        String subject = "[APP-SUPPORT]";
        String message =
                "<html><body><p>I need help with : </p>" +
                        "</p>" +
                        "</body></html>";
        try {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("RallyPracticeSupport@gmail.com"));
            emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{"mailto:github.gstuart@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(message));
            Intent intent = Intent.createChooser(emailIntent, "Request support");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(emailIntent);
        } catch(android.content.ActivityNotFoundException ex) {
            Toast.makeText(Nav_Drawer.this, "You do not have an email client installed on your phone!", Toast.LENGTH_LONG).show();

        } catch (NullPointerException e) {
            Log.e("Null Pointer Exception", "sendSupportEmail : NullPointerException");
        } catch (UnsupportedOperationException e) {
            Log.e("UnsupportedOp Exception", "unsupported");
        }
    }

    private void loadLink(String url, String title) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("Url", url);
        intent.putExtra("Title", title);
        startActivity(intent);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
