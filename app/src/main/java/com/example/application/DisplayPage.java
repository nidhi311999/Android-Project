package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayPage extends AppCompatActivity {
    TextView display ;
    DBHelper helper ;
    public static final String DBNAME = "registration.db" ;
    public static final String TBNAME = "registration" ;
    public static final int DB_VERSION= 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);

        display = findViewById(R.id.displaytext);

        helper = new DBHelper(this,DBNAME, null,DB_VERSION);
        String finalres=  helper.display(DisplayPage.this);
        display.setText(finalres);
    }
}