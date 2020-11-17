package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePage extends AppCompatActivity {
    EditText _uname, _upass ;

    public static final String DBNAME = "registration.db" ;
    public static final String TBNAME = "registration" ;
    public static final int DB_VERSION= 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);
        _uname = findViewById(R.id.name) ;
        _upass = findViewById(R.id.pass) ;

        String uname = _uname.getText().toString();
        String upass = _upass.getText().toString();

        DBHelper helper = new DBHelper(this, DBNAME,null,DB_VERSION) ;
        helper.update(uname,upass);

    }
}