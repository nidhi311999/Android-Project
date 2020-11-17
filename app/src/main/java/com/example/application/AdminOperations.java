package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminOperations extends AppCompatActivity {
    Button insert,display,delete,update;
    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_operations);
        insert=findViewById(R.id.insert);
        display = findViewById(R.id.display);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AdminOperations.this, InsertionPage.class) ;
                startActivity(intent);
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AdminOperations.this, DisplayPage.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AdminOperations.this, DeletePage.class);
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AdminOperations.this, UpdatePage.class) ;
                startActivity(intent);
            }
        });
    }

}