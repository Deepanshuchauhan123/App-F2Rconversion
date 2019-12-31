package com.example.app_deepanshu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Start_Activity extends AppCompatActivity {

    private Button mButtonhealth;
    private Button mButtoneducation;
    private Button mButtonAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_start_);

        //change action bar language
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        Button changeLang=findViewById(R.id.changeLang);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

        //mButtonLogin =(Button)findViewById(R.id.button_login);
        mButtonhealth = (Button) findViewById(R.id.button_health);
        mButtonhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Start_Activity.this, health_cat.class);
                startActivity(i);

            }
        });
        mButtoneducation = (Button) findViewById(R.id.button_education);
        mButtoneducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Start_Activity.this, edu_start.class);
                startActivity(i);

            }
        });
        mButtonAdmin = (Button) findViewById(R.id.button_duty);
        mButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Start_Activity.this, admin_chart.class);
                startActivity(i);

            }
        });


    }

    private void showChangeLanguageDialog() {
        final String[] listitem={"Hindi", "English"};
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(Start_Activity.this);
        mBuilder.setTitle("Choose Language......");
        mBuilder.setSingleChoiceItems(listitem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i==0){
                    //for hindi
                    setLocale("hi");
                    recreate();
                }
                else if(i==1){
                    //for english
                    setLocale("en");
                    recreate();
                }
                dialog.dismiss();
            }
        });
        AlertDialog mDilaog= mBuilder.create();
        mDilaog.show();
    }

    private void setLocale(String lang) {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources()
                .updateConfiguration(config, getBaseContext().getResources()
                .getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }
    public void loadLocale(){
        SharedPreferences prefs= getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=prefs.getString("My_Lang","");
        setLocale(language);
    }
}
