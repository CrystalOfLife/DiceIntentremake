package com.example.nicolai.diceintentremake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView dice1, dice2;
    Button Roll;
    TextView History1, History2, History3, History4, History5;
    int[] images = {
            R.drawable.dice1small, R.drawable.dice2small, R.drawable.dice1small,
            R.drawable.dice4small, R.drawable.dice5small, R.drawable.dice6small
    };
    int PickedImage, holdPicked;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Roll = findViewById(R.id.Roll);
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        History1 = findViewById(R.id.History1);
        History2 = findViewById(R.id.History2);
        History3 = findViewById(R.id.History3);
        History4 = findViewById(R.id.History4);
        History5 = findViewById(R.id.History5);
        r = new Random();

        Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.history:{
                onClickNext();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickNext() {
        String move = History1.getText().toString();
        Intent intent = new Intent(MainActivity.this, History.class);
        intent.setClass(this, History.class);
        intent.putExtra("Dice", move);
        startActivity(intent);

    }

    private void randomDice()
    {
        PickedImage = r.nextInt(images.length);
    }

    private void rollDice()
    {
        randomDice();
        dice1.setImageResource(images[PickedImage]);
        holdPicked = PickedImage;
        randomDice();
        dice2.setImageResource(images[PickedImage]);
    }
}
