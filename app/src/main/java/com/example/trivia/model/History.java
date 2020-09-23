package com.example.trivia.model;

import java.util.Date;

public class History {
    public static final String TABLE_NAME = "history";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATETIME = "datetime";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CRICKETER = "cricketer";
    public static final String COLUMN_COLORS = "colors";

    private int id;
    private String datetime;
    private String name;
    private String cricketer;
    private String colors;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_CRICKETER + " TEXT,"
                    + COLUMN_COLORS + " TEXT,"
                    + COLUMN_DATETIME + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
    public History() {
    }
    public History(int id,String datetime, String name, String cricketer, String colors) {
        this.id = id;
        this.datetime = datetime;
        this.name = name;
        this.cricketer = cricketer;
        this.colors = colors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCricketer() {
        return cricketer;
    }

    public void setCricketer(String cricketer) {
        this.cricketer = cricketer;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
}
