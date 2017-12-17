package com.wedddingapp.shankar.assignmenttwelevee;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetfrequencyActivity extends AppCompatActivity {
    EditText et_frequencyinput;
    Button bt_saveinfofrequency;
    Button bt_displayinfofrequency;
    TextView tv_infofrequency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setfrequency);
        et_frequencyinput = (EditText) findViewById(R.id.et_frequencyinput);
        bt_saveinfofrequency = (Button) findViewById(R.id.button_savefrequency);
        bt_displayinfofrequency = (Button) findViewById(R.id.button_displayfrquency);
        tv_infofrequency = (TextView) findViewById(R.id.tv_infofrquency);

        bt_saveinfofrequency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedatafrequency();
            }
        });
        bt_displayinfofrequency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaydatafrequency();
            }
        });
    }


    //shared prefrence is used which stores data in the form of key value pair
    //MODE_PRIVATE is used to  File creation mode: the default mode, where the created file can only be accessed by the calling application


    private void displaydatafrequency() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String password = preferences.getString("frequency","");
        tv_infofrequency.setText(password);
        tv_infofrequency.setVisibility(View.VISIBLE); //getString which gets the frequnecyvalue from  putstring and displays
    }

    private void savedatafrequency() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit(); //editor object along with put string which saves the frequency
        editor.putString("frequency",et_frequencyinput.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show(); //displays toast message after saving


    }
}