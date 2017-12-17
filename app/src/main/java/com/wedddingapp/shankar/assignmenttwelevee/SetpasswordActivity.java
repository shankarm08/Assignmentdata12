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

public class SetpasswordActivity extends AppCompatActivity {
    EditText et_passowrdinput;
    Button bt_saveinfo;
    Button bt_displayinfo;
    TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpassword); //defining in layout
        et_passowrdinput = (EditText) findViewById(R.id.et_passwordinput); //edittext for password input
        tv_info = (TextView) findViewById(R.id.tv_info);  //for displaying the password
        bt_displayinfo = (Button) findViewById(R.id.button_display); //when the display button is initilaized
        bt_saveinfo = (Button) findViewById(R.id.button_save); //where the button is initialized
        bt_saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedata();
            }
        });

        //when i click on displayinfo this method is called
        bt_displayinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaydata();
            }
        });
    }

    //shared prefrence is used which stores data in the form of key value pair
    //MODE_PRIVATE is used to  File creation mode: the default mode, where the created file can only be accessed by the calling application

    private void displaydata() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String password = preferences.getString("password",""); //putstring follwed by getstring which is finally used to display data
        tv_info.setText(password);
        tv_info.setVisibility(View.VISIBLE);
    }

    private void savedata() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("password",et_passowrdinput.getText().toString()); //editor object is used along with putstring to put the data
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();//once you click on save the saved data will be shown
    }
}
