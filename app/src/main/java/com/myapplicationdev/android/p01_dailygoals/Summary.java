package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        // Get the TextView object
        TextView tv1 = findViewById(R.id.textViewRead);
        TextView tv2 = findViewById(R.id.textViewArrive);
        TextView tv3 = findViewById(R.id.textViewAttempt);
        TextView tv4 = findViewById(R.id.textViewRef);
        Button btnClose = findViewById(R.id.buttonClose);
        // Display the name and age on the TextView
        tv1.setText(info[0] + " " + info[3]);
        tv2.setText(info[1] + " " + info[4]);
        tv3.setText(info[2] + " " + info[5]);
        tv4.setText("Reflection : " + info[6] );

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Summary.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
}
