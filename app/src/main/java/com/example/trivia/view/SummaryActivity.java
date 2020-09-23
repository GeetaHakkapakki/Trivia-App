package com.example.trivia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trivia.R;
import com.example.trivia.database.SQLliteHelper;
import com.example.trivia.model.History;
import com.example.trivia.viewmodel.HistoryAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SummaryActivity extends AppCompatActivity {
    TextView txt_name,txt_cricketer,txt_color;
    Button btn_finish;
    String name,cricketer_name,colorname,timedate;
    //private HistoryAdapter mAdapter;
    private List<History> historyList = new ArrayList<>();
    private SQLliteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        name = getIntent().getStringExtra("name");
        cricketer_name = getIntent().getStringExtra("cricketer_name");
        colorname = getIntent().getStringExtra("color");
        txt_name = findViewById(R.id.txt_name);
        txt_name.setText("Hello "+ name);
        txt_cricketer = findViewById(R.id.txt_cricketer);
        txt_cricketer.setText(cricketer_name);
        txt_color = findViewById(R.id.txt_colors);
        txt_color.setText(colorname);
        db = new SQLliteHelper(this);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:MM ");
        timedate = sdf.format(calendar.getTime());
        btn_finish = findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = db.insertHistory(timedate,name,cricketer_name,colorname);
                History n = db.getHistory(id);
                Intent i = new Intent(SummaryActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
    }

}