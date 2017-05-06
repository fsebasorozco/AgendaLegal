package com.fsebasorozco.agendalegal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.R.*;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton addEvent,Location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvent = (ImageButton) findViewById(R.id.ImB1);
        Location = (ImageButton) findViewById(R.id.ImB2);

        addEvent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EventActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LocationActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
}
