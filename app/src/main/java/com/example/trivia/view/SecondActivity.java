package com.example.trivia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.trivia.R;

public class SecondActivity extends AppCompatActivity {
    CheckBox cb_sachin,cb_virat,cb_adam,cb_jacques;
    Button btn_next;
    String name,cricketer_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name = getIntent().getStringExtra("name");
        cb_sachin = findViewById(R.id.sachin);
        cb_virat = findViewById(R.id.virat);
        cb_adam = findViewById(R.id.adam);
        cb_jacques = findViewById(R.id.jacques);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_sachin.isChecked() || cb_virat.isChecked() || cb_adam.isChecked() || cb_jacques.isChecked()) {
                    Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                    i.putExtra("name", name);
                    i.putExtra("cricketer_name", cricketer_name);
                    startActivity(i);
                    finish();
                }else{

                    Toast.makeText(SecondActivity.this,"please select any one", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb_sachin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cricketer_name = cb_sachin.getText().toString();
                    cb_virat.setChecked(false);
                    cb_adam.setChecked(false);
                    cb_jacques.setChecked(false);

                }
            }
        });
        cb_virat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cricketer_name = cb_virat.getText().toString();
                    cb_sachin.setChecked(false);
                    cb_adam.setChecked(false);
                    cb_jacques.setChecked(false);

                }
            }
        });
        cb_adam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cricketer_name = cb_adam.getText().toString();
                    cb_sachin.setChecked(false);
                    cb_virat.setChecked(false);
                    cb_jacques.setChecked(false);

                }
            }
        });
        cb_jacques.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cricketer_name = cb_jacques.getText().toString();
                    cb_sachin.setChecked(false);
                    cb_virat.setChecked(false);
                    cb_adam.setChecked(false);

                }
            }
        });
    }
}