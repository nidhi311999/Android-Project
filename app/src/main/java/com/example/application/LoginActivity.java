package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText name, pass ;
    Button submit ;
    DBHelper dbHelper ;
    //public static final String DBNAME = "registration.db" ;
   // public static final String TBNAME = "registration" ;
    public static final int DB_VERSION= 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        /*SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor resultSet = db.rawQuery("Select * from registration",null);
        resultSet.moveToFirst();
        final String username = resultSet.getString(0);
        final String password = resultSet.getString(1);
        db.close();*/
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("admin")  && pass.getText().toString().equals("admin"))
                {
                    Intent it = new Intent(getApplicationContext(),AdminOperations.class);
                    startActivity(it);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid login", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(it);
                }
            }
        });
    }

}