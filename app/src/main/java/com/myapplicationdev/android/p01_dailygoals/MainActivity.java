package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOk = findViewById(R.id.button);



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Get the edittext when user keys in name
                TextView tv1 = findViewById(R.id.textView);
                TextView tv3 = findViewById(R.id.textView3);
                TextView tv5 = findViewById(R.id.textView5);
                EditText et1 = findViewById(R.id.editText2);
                RadioGroup rg = findViewById(R.id.radioGroup1);
                RadioGroup rg2 = findViewById(R.id.radioGroup2);
                RadioGroup rg3 = findViewById(R.id.radioGroup3);

                int selectedButtonID = rg.getCheckedRadioButtonId();
                int selectedButtonID2 = rg2.getCheckedRadioButtonId();
                int selectedButtonID3 = rg3.getCheckedRadioButtonId();

                RadioButton rb = findViewById(selectedButtonID);
                RadioButton rb2 = findViewById(selectedButtonID2);
                RadioButton rb3 = findViewById(selectedButtonID3);



                //Put the name and age into the array
                String[] info = {tv1.getText().toString(), tv3.getText().toString(), tv5.getText().toString(), rb.getText().toString(),rb2.getText().toString(),rb3.getText().toString()
                ,et1.getText().toString()};

                //Create an intent to start another activity called DemoActivities
                Intent i = new Intent(MainActivity.this,Summary.class);

                //Pass the String array holding the name and age to new activity
                i.putExtra("info",info);
                //Start the new activity
                startActivity(i);


            }


        });




    }
    protected void onPause() {
        super.onPause();
        RadioGroup rg1 = findViewById(R.id.radioGroup1);
        RadioGroup rg2 = findViewById(R.id.radioGroup2);
        RadioGroup rg3 = findViewById(R.id.radioGroup3);
        EditText et1 = findViewById(R.id.editText2);
        int selectedButtonId1 = rg1.getCheckedRadioButtonId();
        int selectedButtonId2 = rg2.getCheckedRadioButtonId();
        int selectedButtonId3 = rg3.getCheckedRadioButtonId();
        String text = et1.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("rg1", selectedButtonId1);
        prefEdit.putInt("rg2", selectedButtonId2);
        prefEdit.putInt("rg3", selectedButtonId3);
        prefEdit.putString("text", text);

        prefEdit.commit();
    }

    protected void onResume() {
        super.onResume();
        RadioGroup rg1 = findViewById(R.id.radioGroup1);
        RadioGroup rg2 = findViewById(R.id.radioGroup2);
        RadioGroup rg3 = findViewById(R.id.radioGroup3);
        EditText et1 = findViewById(R.id.editText2);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int intRB1 = prefs.getInt("rg1",0);
        int intRB2 = prefs.getInt("rg2",0);
        int intRB3 = prefs.getInt("rg3",0);
        String strText = prefs.getString("text", "");

        rg1.check(intRB1);
        rg2.check(intRB2);
        rg3.check(intRB3);
        et1.setText(strText);
    }
}
