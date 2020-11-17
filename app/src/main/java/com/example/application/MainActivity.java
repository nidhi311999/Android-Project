package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View view) {
        Intent it=new Intent(this,LoginActivity.class);
        startActivity(it);
    }

    public void register(View view) {
        Intent it=new Intent(this,RegistrationActivity.class);
        startActivity(it);
    }
}