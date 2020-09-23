package com.example.trivia.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trivia.R;

public class MainActivity extends AppCompatActivity {
    EditText et_name;
    Button btn_next,btn_history;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                if(!(name.isEmpty())) {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("name", name);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this,"please enter name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_history = findViewById(R.id.btn_history);
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });
    }
}