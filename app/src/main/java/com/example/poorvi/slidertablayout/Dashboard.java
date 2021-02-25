package com.example.poorvi.slidertablayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Dashboard extends AppCompatActivity {

    private Locale myLocale;
    SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();

        Button createres = (Button) findViewById(R.id.createresume);
        Button view = (Button) findViewById(R.id.viewresume);
        Button guide = (Button) findViewById(R.id.resumeguide);
        Button aboutus = (Button) findViewById(R.id.aboutus);
        Button rateus = (Button) findViewById(R.id.rateus);

        createres.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), View_Pdf.class);
                startActivity(i);
            }
        });

        guide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), ResumeGuide.class);
                startActivity(i);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(i);
            }
        });

        rateus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), RateUs.class);
                startActivity(i);
            }
        });

    }
    private void init() {
        sharedPrefs = new SharedPrefs(Dashboard.this);
    }
    private void loadLocale() {
        String language = "";
        Log.e("Current_Language", sharedPrefs.get_Language_name());

        if (sharedPrefs.get_Language_name().equalsIgnoreCase("Hindi")) {
            language = "hi";
        }

        if (sharedPrefs.get_Language_name().equalsIgnoreCase("English")) {
            language = "en";
        }
        changeLocale(language);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    if (id == R.id.english) {
        sharedPrefs.save_Language_name("English");
        loadLocale();
        Intent i = new Intent(Dashboard.this, Dashboard.class);
        startActivity(i);
        finish();
    }

    if (id == R.id.hindi) {
        sharedPrefs.save_Language_name("Hindi");
        loadLocale();
        Intent i = new Intent(Dashboard.this, Dashboard.class);
        startActivity(i);
        finish();
    }

    return super.onOptionsItemSelected(item);
}

    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);//Set Selected Locale
        Locale.setDefault(myLocale);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = myLocale;//set config locale as selected locale
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());//Update the config
    }
}
