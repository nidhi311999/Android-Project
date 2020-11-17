package com.example.application;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class InsertionPage extends AppCompatActivity {
    EditText name, pass ;
    Button register ;
    DBHelper dbHelper ;
    public static final String DBNAME = "registration.db" ;
    public static final String TBNAME = "registration" ;
    public static final int DB_VERSION= 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_page);
        name = findViewById(R.id.name) ;
        pass = findViewById(R.id.pass) ;

        final String uname = name.getText().toString() ;
        final String upass = pass.getText().toString();

        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            long val ;
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(InsertionPage.this, DBNAME, null, DB_VERSION);
                long val = dbHelper.adduser(uname, upass);
                if (val == -1) {
                    Toast.makeText(InsertionPage.this, "Error in Adding user", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(InsertionPage.this, MainActivity.class);
                    startActivity(it);
                }
                else{
                    Toast.makeText(InsertionPage.this, "Registered", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(InsertionPage.this,MainActivity.class);
                    startActivity(it);}
            }
        });
    }
}