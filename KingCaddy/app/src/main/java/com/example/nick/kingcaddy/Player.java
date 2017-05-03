package com.example.nick.kingcaddy;


import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;

/**
 * Created by Nick on 10/8/2016.
 */
public class Player implements Parcelable {
    public String name;
    private int[] scores = new int[18];
    Integer total_score;


    public Player(String name) {
        this.name = name;
        this.total_score = 0;
        this.scores[0] = 0;
        for(int i = 0; i < 17; i++){
            this.scores[i] = 0;
        }
    }

    protected Player(Parcel in) {
        name = in.readString();
        scores = in.createIntArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeIntArray(scores);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setScore(Integer hole,Integer score) {

        this.scores[hole-1] = score;
    }

    public int getScore(int i) {
        int x = scores[i-1];
        return x;
    }
}
