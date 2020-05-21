package com.example.p05_ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(int _id, String title, String singer, int year, int stars) {
        this._id = _id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }
}
