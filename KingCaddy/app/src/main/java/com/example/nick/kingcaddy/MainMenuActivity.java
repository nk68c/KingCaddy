package com.example.nick.kingcaddy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.reflect.Type;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainMenuActivity extends AppCompatActivity {



    private ArrayList<Player> player_list = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void newRound(View v){

        Intent intent = new Intent(this, Round_Players.class);
        intent.putParcelableArrayListExtra("key", (ArrayList<Player>) player_list);
        startActivity(intent);
        Toast.makeText(MainMenuActivity.this, "Testing " +player_list.get(0).getName()+ " is here", Toast.LENGTH_LONG).show();
    }

    public void add_Player(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enter player name: ");
        final EditText player_name = new EditText(this);
        builder.setView(player_name);

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = player_name.getText().toString();
                Player new_player = new Player(name);

                player_list.add(new_player);
                Toast.makeText(MainMenuActivity.this, "Player " +name+ " Added", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }

        });
        builder.show();

    }
}
