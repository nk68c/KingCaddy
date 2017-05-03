
package com.example.nick.kingcaddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class scorecard extends AppCompatActivity {
    ArrayList<Player> players = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);
        players = getIntent().getParcelableArrayListExtra("key");
        int p1_total = getIntent().getIntExtra("p1score", 0);
        String total = Integer.toString(p1_total);
        final TextView textViewToChange = (TextView) findViewById(R.id.name1);
        textViewToChange.setText(
                players.get(0).getName());
        final TextView textViewToChange1 = (TextView) findViewById(R.id.score1);
        textViewToChange1.setText(total);
    }

}
