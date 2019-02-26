package com.Gindiascholars2k18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.ButterKnife;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final String PROFILES = "1", PORTFOLIO = "2", RESUME = "3", FEEDBACK = "4",
            ABOUT = "5", SETTINGS = "6", CONTACT_US = "7", RATE_APP = "8", SHARE_APP = "9",
            PROFILE = "10", MANAGE_ACCOUNT = "11";
    private Drawer drawer = null;
    private AccountHeader accountHeader = null;
    private String lastSelectedDrawerItem = PROFILES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Handle Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withTextColor(Color.WHITE)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("User Name")
                                .withEmail("user@email.com")
                                .withIcon(R.drawable.user_image)
                                .withIdentifier(Long.parseLong(PROFILE)),
                        new ProfileSettingDrawerItem()
                                .withName("Manage Account")
                                .withIcon(R.drawable.ic_settings)
                                .withIdentifier(Long.parseLong(MANAGE_ACCOUNT))
                )
                .withHeaderBackground(R.drawable.wallpaper)
                .withOnAccountHeaderListener((view, profile, current) -> {
                    switch (String.valueOf(profile.getIdentifier())) {
                        case PROFILE:
                            Toast.makeText(this, "Clicked on " + profile.getName(), Toast.LENGTH_SHORT).show();
                            break;
                        case MANAGE_ACCOUNT:
                            Toast.makeText(this, "Clicked on " + profile.getName(), Toast.LENGTH_SHORT).show();
                    }
                    return false;
                })
                .withSavedInstance(savedInstanceState)
                .build();

        //Create the drawer
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(accountHeader)
                .withDisplayBelowStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName("Profiles")
                                .withIdentifier(Long.parseLong(PROFILES))
                                .withIcon(R.drawable.ic_profiles),
                        new PrimaryDrawerItem()
                                .withName("Portfolio")
                                .withIdentifier(Long.parseLong(PORTFOLIO))
                                .withIcon(R.drawable.ic_portfolio),
                        new PrimaryDrawerItem()
                                .withName("Resume")
                                .withIdentifier(Long.parseLong(RESUME))
                                .withIcon(R.drawable.ic_resume),
                        new PrimaryDrawerItem()
                                .withName("Feedback")
                                .withIdentifier(Long.parseLong(FEEDBACK))
                                .withIcon(R.drawable.ic_feedback),
                        new PrimaryDrawerItem().withName("About")
                                .withIdentifier(Long.parseLong(ABOUT))
                                .withIcon(R.drawable.ic_info),
                        new SectionDrawerItem()
                                .withName("Tools"),
                        new PrimaryDrawerItem()
                                .withName("Settings")
                                .withIdentifier(Long.parseLong(SETTINGS))
                                .withIcon(R.drawable.ic_settings),
                        new PrimaryDrawerItem()
                                .withName("Contact us")
                                .withIdentifier(Long.parseLong(CONTACT_US))
                                .withIcon(R.drawable.ic_contact_us),
                        new PrimaryDrawerItem()
                                .withName("Rate App")
                                .withIdentifier(Long.parseLong(RATE_APP))
                                .withIcon(R.drawable.ic_rating),
                        new PrimaryDrawerItem()
                                .withName("Share App")
                                .withIdentifier(Long.parseLong(SHARE_APP))
                                .withIcon(R.drawable.ic_share)
                )// add the items we want to use with our Drawer
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    long identifier = drawerItem.getIdentifier();
                    switch (String.valueOf(identifier)) {
                        case PROFILES:
                            Toast.makeText(MainActivity.this, "Profiles", Toast.LENGTH_SHORT).show();
                            lastSelectedDrawerItem = PROFILES;
                            break;
                        case PORTFOLIO:
                            Toast.makeText(MainActivity.this, "Portfolio", Toast.LENGTH_SHORT).show();
                            lastSelectedDrawerItem = PORTFOLIO;
                            break;
                        case RESUME:
                            Toast.makeText(MainActivity.this, "Resume", Toast.LENGTH_SHORT).show();
                            lastSelectedDrawerItem = RESUME;
                            break;
                        case FEEDBACK:
                            Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
                            lastSelectedDrawerItem = FEEDBACK;
                            break;
                        case ABOUT:
                            Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
                            lastSelectedDrawerItem = ABOUT;
                            break;
                        case SETTINGS:
                            Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                            drawer.setSelection(Long.parseLong(lastSelectedDrawerItem), false);
                            break;
                        case CONTACT_US:
                            Toast.makeText(MainActivity.this, "Contact us", Toast.LENGTH_SHORT).show();
                            drawer.setSelection(Long.parseLong(lastSelectedDrawerItem), false);
                            break;
                        case RATE_APP:
                            Toast.makeText(MainActivity.this, "Rate App", Toast.LENGTH_SHORT).show();
                            drawer.setSelection(Long.parseLong(lastSelectedDrawerItem), false);
                            break;
                        case SHARE_APP:
                            Toast.makeText(MainActivity.this, "Share App", Toast.LENGTH_SHORT).show();
                            drawer.setSelection(Long.parseLong(lastSelectedDrawerItem), false);
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
        outState = drawer.saveInstanceState(outState);
        outState = accountHeader.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (accountHeader != null && accountHeader.isSelectionListShown()) {
            accountHeader.toggleSelectionList(MainActivity.this);
            return;
        }
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
