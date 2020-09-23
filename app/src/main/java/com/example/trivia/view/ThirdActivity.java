package com.example.trivia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.trivia.R;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    CheckBox cb_white,cb_yellow,cb_orange,cb_green;
    Button btn_next;
    String name,cricketer_name,white,orange,green,yellow;
    String colorname="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        name = getIntent().getStringExtra("name");
        cricketer_name = getIntent().getStringExtra("cricketer_name");
        cb_white = findViewById(R.id.white);
        cb_yellow = findViewById(R.id.yellow);
        cb_orange = findViewById(R.id.orange);
        cb_green = findViewById(R.id.green);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result=new StringBuilder();
                if(cb_white.isChecked()){
                    colorname += ","+cb_white.getText().toString();
                }if(cb_yellow.isChecked()){
                    colorname += ","+cb_yellow.getText().toString();
                }
                if(cb_orange.isChecked()){
                    colorname += ","+cb_orange.getText().toString();
                }
                if(cb_green.isChecked()){
                    colorname+= ","+cb_green.getText().toString();
                }

                if(cb_white.isChecked() || cb_yellow.isChecked() || cb_orange.isChecked() || cb_green.isChecked()) {
                    colorname = colorname.replaceFirst("^,", "");
                    Intent i = new Intent(ThirdActivity.this, SummaryActivity.class);
                    i.putExtra("name", name);
                    i.putExtra("cricketer_name", cricketer_name);
                    i.putExtra("color", colorname);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(ThirdActivity.this,"please select atleast one", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}