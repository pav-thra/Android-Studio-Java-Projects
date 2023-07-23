package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText p1=findViewById(R.id.playerOne);
        EditText p2=findViewById(R.id.playerTwo);
        Button b=findViewById(R.id.startGameButton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1n=p1.getText().toString();
                String p2n=p2.getText().toString();

                if (p1n.isEmpty() || p2n.isEmpty()) {
                    Toast.makeText(AddPlayers.this, "Enter the players name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i=new Intent(AddPlayers.this, MainActivity.class);
                    i.putExtra("Player 1",p1n);
                    i.putExtra("Player 2",p2n);
                    startActivity(i);
                }
            }
        });

    }
}