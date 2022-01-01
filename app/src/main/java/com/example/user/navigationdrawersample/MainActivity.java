package com.example.user.navigationdrawersample;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NotificationManagerCompat notificationManagerCompat;


    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private SwitchCompat darkModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);

        initializeViews();
        toggleDrawer();
        initializeDefaultFragment(savedInstanceState,0);

    }

    /**
     * Initialize all widgets
     */
    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar_id);
        toolbar.setTitle(R.string.toolbar_title);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout_id);
        frameLayout = findViewById(R.id.framelayout_id);
        navigationView = findViewById(R.id.navigationview_id);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * Checks if the savedInstanceState is null - onCreate() is ran
     * If so, display fragment of navigation drawer menu at position itemIndex and
     * set checked status as true
     * @param savedInstanceState
     * @param itemIndex
     */
    private void initializeDefaultFragment(Bundle savedInstanceState, int itemIndex){
        if (savedInstanceState == null){
            MenuItem menuItem = navigationView.getMenu().getItem(itemIndex).setChecked(true);
            onNavigationItemSelected(menuItem);
        }
    }

    /**
     * Creates an instance of the ActionBarDrawerToggle class:
     * 1) Handles opening and closing the navigation drawer
     * 2) Creates a hamburger icon in the toolbar
     * 3) Attaches listener to open/close drawer on icon clicked and rotates the icon
     */
    private void toggleDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        //Checks if the navigation drawer is open -- If so, close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        // If drawer is already close -- Do not override original functionality
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_dashboard_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new DashboardFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_profile_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ProfileFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_notebooks_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new NotebooksFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_message_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new MessageFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_send_id:
                Snackbar snackbar = Snackbar
                        .make(this.drawerLayout, "SnackBar successful!", Snackbar.LENGTH_LONG);
                // Show
                snackbar.show();
                closeDrawer();
                break;
            case R.id.nav_notif_id:
                Notification notification = new NotificationCompat.Builder(this,MonApp.exampleNotification)
                        .setSmallIcon(R.drawable.ic_notifications)
                        .setContentTitle("RMS")
                        .setContentText("Your Body Notifications here")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();
                notificationManagerCompat.notify(1,notification);
                closeDrawer();
                break;
            case R.id.nav_offers_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new OffersFragment())
                        .commit();
                // deSelectCheckedState();
                closeDrawer();
                break;
            case R.id.nav_emplyees_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new EmployeesFragment())
                        .commit();
                closeDrawer();
                break;

            case R.id.nav_Question_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new QuestionFragment())
                        .commit();
                deSelectCheckedState();
                closeDrawer();
                break;

            case R.id.nav_settings_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new SettingsFragment())
                        .commit();
                deSelectCheckedState();
                closeDrawer();
                break;
            case R.id.nav_logout_id:
                Intent it = new Intent(MainActivity.this,login_page.class);
                startActivity(it);
                closeDrawer();
                break;

        }
        return true;
    }

    /**
     * Checks if the navigation drawer is open - if so, close it
     */
    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    
    /**
     * Iterates through all the items in the navigation menu and deselects them:
     * removes the selection color
     */
    private void deSelectCheckedState(){
        int noOfItems = navigationView.getMenu().size();
        for (int i=0; i<noOfItems;i++){
            navigationView.getMenu().getItem(i).setChecked(false);
        }
    }
}
