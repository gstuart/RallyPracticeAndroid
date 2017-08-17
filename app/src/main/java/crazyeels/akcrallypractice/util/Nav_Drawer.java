package crazyeels.akcrallypractice.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import crazyeels.akcrallypractice.R;
import crazyeels.akcrallypractice.models.NoviceCommand;
import crazyeels.akcrallypractice.ui.WebViewActivity;


public class Nav_Drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    public static final String TAG = Nav_Drawer.class.getSimpleName();

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

/* Method for Command Activity */
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
                    nextButton.setText(getString(R.string.another));
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
//TODO determine if using menu or not, if not remove code below
//    Below are methods for the menu.main.xml (the menu on the top right of every screen that contains "Settings")
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
////
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_videos) {
            Log.d(TAG, "seeing result after clicking nav_videos");
            // Takes user to youtube playlist of practice videos in a webViewer
            loadLink(Constants.youtube_url, getString(R.string.nav_videos));

//        } else if (id == R.id.nav_gallery) {
//            // Displays a series of images of the actual cards


        } else if (id == R.id.nav_akc) {
            Log.i(TAG, "click on nav_akc");
            // Takes the user to the Rally page on the AKC website
            loadPdf(Constants.akc_url, getString(R.string.nav_akc));

        } else if (id == R.id.nav_share) {
            // Allows user to share the app via text message, twitter, email, and Facebook
            shareApp();

        } else if (id == R.id.nav_support) {
            // Generates an email, with device version, that user can write in and then send
            sendSupportEmail(this, new String[]{Constants.support_email}, getString(R.string.support_email_subject));
            Log.e(TAG, "Click on Support link in navDrawer");

        } else if (id == R.id.nav_rate) {
          //  Takes the user to Google Play app review page
            rateTheApp();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void shareApp() {
        Intent shareApp = new Intent(android.content.Intent.ACTION_SEND);
        shareApp.setType(Constants.text_html);
        shareApp.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.shareSubject));
        shareApp.putExtra(Intent.EXTRA_TEXT, getString(R.string.shareBody) + "\n" + Constants.google_play_url + this.getPackageName());
        startActivity(shareApp);
    }

    //TODO 8/17 need to test this after app is published, might need to use Constants.google_play_url
    public void rateTheApp() {
        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
        Intent myAppLink = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLink);
        } catch(ActivityNotFoundException e) {
            Toast.makeText(this, R.string.unable_to_find_app, Toast.LENGTH_LONG).show();
        }
    }

    public static void sendSupportEmail(Context context, String[] to, String subject) {
        String body = "";
        try {
            body = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            body = context.getApplicationInfo().name;
            body = "How can we help?\n\n\n\n\n\n\nPlease do not delete below contents"
                    + "\nApp: AKC Rally® Practice for Android"
                    + "\nDevice OS: Android("
                    + Build.VERSION.RELEASE
                    + ")"
                    + "\n App v"
                    + body
                    + ""
                    + "\n Device: "
                    + Build.BRAND
                    + ", "
                    + Build.MODEL;
        } catch (PackageManager.NameNotFoundException e) {
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.send_email)));
    }

    private void loadLink(String url, String title) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(getString(R.string.url), url);
        intent.putExtra(getString(R.string.title), title);
        startActivity(intent);
    }

    private void loadPdf(String url, String title) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse( Constants.google_viewer_url + url), Constants.text_html);
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
