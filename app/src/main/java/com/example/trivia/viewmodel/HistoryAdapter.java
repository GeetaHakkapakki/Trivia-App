package com.example.trivia.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trivia.R;
import com.example.trivia.model.History;
import com.example.trivia.view.HistoryActivity;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context mcontext;
    private List<History> historyList;


    public HistoryAdapter(HistoryActivity historyActivity,List<History> historyLists) {
        mcontext = historyActivity;
        this.historyList = historyLists;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.child_recyclerview,parent,false);
        ViewHolder vh = new ViewHolder(v);
        // Return the ViewHolder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        final History history = historyList.get(position);
        holder.datetime.setText("GAME 1 : "+history.getDatetime());
        holder.name.setText("Name : "+history.getName());
        holder.cricketer.setText(history.getCricketer());
        holder.colors.setText(history.getColors());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView datetime;
        public TextView name;
        public TextView cricketer;
        public TextView colors;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            datetime = (TextView)itemView.findViewById(R.id.txt_history_datetime);
            name = (TextView)itemView.findViewById(R.id.txt_history_name);
            cricketer = (TextView)itemView.findViewById(R.id.txt_history_cricketer);
            colors = (TextView)itemView.findViewById(R.id.txt_history_colors);
        }
    }
}
