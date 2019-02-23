package com.Gindiascholars2k18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

public class MainActivity extends AppCompatActivity {

    private final String PROFILES = "1", PORTFOLIO = "2", RESUME = "3", FEEDBACK = "4", ABOUT = "5", SETTINGS = "6", CONTACT_US = "7", RATE_APP = "8", SHARE_APP = "9";
    private Drawer result = null;
    private String lastSelectedItem = PROFILES;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTextColor(Color.WHITE)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("User Name")
                                .withEmail("user@email.com")
                                .withIcon(R.drawable.user_image)
                )
                .withHeaderBackground(R.drawable.wallpaper)
                .withOnAccountHeaderListener((view, profile, current) -> false)
                .build();

        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withDisplayBelowStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Profiles").withIdentifier(Long.parseLong(PROFILES)).withIcon(R.drawable.ic_profiles),
                        new PrimaryDrawerItem().withName("Portfolio").withIdentifier(Long.parseLong(PORTFOLIO)).withIcon(R.drawable.ic_portfolio),
                        new PrimaryDrawerItem().withName("Resume").withIdentifier(Long.parseLong(RESUME)).withIcon(R.drawable.ic_resume),
                        new PrimaryDrawerItem().withName("Feedback").withIdentifier(Long.parseLong(FEEDBACK)).withIcon(R.drawable.ic_feedback),
                        new PrimaryDrawerItem().withName("About").withIdentifier(Long.parseLong(ABOUT)).withIcon(R.drawable.ic_info),
                        new SectionDrawerItem().withName("Tools"),
                        new PrimaryDrawerItem().withName("Settings").withIdentifier(Long.parseLong(SETTINGS)).withIcon(R.drawable.ic_settings),
                        new PrimaryDrawerItem().withName("Contact us").withIdentifier(Long.parseLong(CONTACT_US)).withIcon(R.drawable.ic_contact_us),
                        new PrimaryDrawerItem().withName("Rate App").withIdentifier(Long.parseLong(RATE_APP)).withIcon(R.drawable.ic_rating),
                        new PrimaryDrawerItem().withName("Share App").withIdentifier(Long.parseLong(SHARE_APP)).withIcon(R.drawable.ic_share)
                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    long identifier = drawerItem.getIdentifier();
                    switch (String.valueOf(identifier)) {
                        case PROFILES:
                            Toast.makeText(MainActivity.this, "Profiles", Toast.LENGTH_SHORT).show();
                            lastSelectedItem = PROFILES;
                            break;
                        case PORTFOLIO:
                            Toast.makeText(MainActivity.this, "Portfolio", Toast.LENGTH_SHORT).show();
                            lastSelectedItem = PORTFOLIO;
                            break;
                        case RESUME:
                            Toast.makeText(MainActivity.this, "Resume", Toast.LENGTH_SHORT).show();
                            lastSelectedItem = RESUME;
                            break;
                        case FEEDBACK:
                            Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
                            lastSelectedItem = FEEDBACK;
                            break;
                        case ABOUT:
                            Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
                            lastSelectedItem = ABOUT;
                            break;
                        case SETTINGS:
                            Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                            result.setSelection(Long.parseLong(lastSelectedItem), false);
                            break;
                        case CONTACT_US:
                            Toast.makeText(MainActivity.this, "Contact us", Toast.LENGTH_SHORT).show();
                            result.setSelection(Long.parseLong(lastSelectedItem), false);
                            break;
                        case RATE_APP:
                            Toast.makeText(MainActivity.this, "Rate App", Toast.LENGTH_SHORT).show();
                            result.setSelection(Long.parseLong(lastSelectedItem), false);
                            break;
                        case SHARE_APP:
                            Toast.makeText(MainActivity.this, "Share App", Toast.LENGTH_SHORT).show();
                            result.setSelection(Long.parseLong(lastSelectedItem), false);
                            break;
                    }
                    return false;
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
