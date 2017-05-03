package com.example.nick.kingcaddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class Score_Activity extends AppCompatActivity {
    ArrayList<Player> players = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_);
        players = getIntent().getParcelableArrayListExtra("key");
        final TextView textViewToChange = (TextView) findViewById(R.id.player_name);
        textViewToChange.setText(
                players.get(0).getName());

    }

    public void Scorecard(View v){
        Intent intent = new Intent(this,scorecard.class);

        TextView hole1 = (TextView) findViewById(R.id.hole1_score);
        TextView hole2 = (TextView) findViewById(R.id.hole2_score);
        TextView hole3 = (TextView) findViewById(R.id.hole3_score);
        TextView hole4 = (TextView) findViewById(R.id.hole4_score);
        TextView hole5 = (TextView) findViewById(R.id.hole5_score);
        TextView hole6 = (TextView) findViewById(R.id.hole6_score);
        TextView hole7 = (TextView) findViewById(R.id.hole7_score);
        TextView hole8 = (TextView) findViewById(R.id.hole8_score);
        TextView hole9 = (TextView) findViewById(R.id.hole9_score);


        players.get(0).setScore(1,Integer.parseInt(hole1.getText().toString()));
        players.get(0).setScore(2,Integer.parseInt(hole2.getText().toString()));
        players.get(0).setScore(3,Integer.parseInt(hole3.getText().toString()));
        players.get(0).setScore(4,Integer.parseInt(hole4.getText().toString()));
        players.get(0).setScore(5,Integer.parseInt(hole5.getText().toString()));
        players.get(0).setScore(6,Integer.parseInt(hole6.getText().toString()));
        players.get(0).setScore(7,Integer.parseInt(hole7.getText().toString()));
        players.get(0).setScore(8,Integer.parseInt(hole8.getText().toString()));
        players.get(0).setScore(9,Integer.parseInt(hole9.getText().toString()));


        int total = 0;
        for(int i = 1; i< 10; i++){

            total += players.get(0).getScore(i);
        }

        intent.putParcelableArrayListExtra("key",players);
        intent.putExtra("p1score",total);
        startActivity(intent);

    }

    public void Next_Player(View v){
        Intent intent = new Intent(this,Score_Activity2.class);
        intent.putParcelableArrayListExtra("key",players);
        startActivity(intent);
    }
}
