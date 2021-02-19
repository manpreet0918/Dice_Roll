package com.example.dice_roll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random random=new Random();
    ImageView img1,img2;
    Button btn_higher,btn_lower;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        btn_higher = findViewById(R.id.btn_higher);
        btn_lower = findViewById(R.id.btn_lower);
        result = findViewById(R.id.textresult);
        btn_higher.setOnClickListener(view -> {

            int value1 = GenerateRandom();
            int value2 = GenerateRandom();

            int res1 = getResources().getIdentifier("img_"+value1,"drawable","com.example.dice_roll");
            int res2 = getResources().getIdentifier("img_"+value2,"drawable","com.example.dice_roll");
            img1.setImageResource(res1);
            img2.setImageResource(res2);
            if(value1 > value2){
                result.setText(getResources().getString(R.string.win));
                result.setTextColor(getResources().getColor(R.color.win));
            }else if(value1 < value2){
                result.setText(getResources().getString(R.string.loss));
                result.setTextColor(getResources().getColor(R.color.loss));
            }else{
                result.setText(getResources().getString(R.string.tie));
                result.setTextColor(getResources().getColor(R.color.tie));
            }

        });

        btn_lower.setOnClickListener(view -> {
            int value1 = GenerateRandom();
            int value2 = GenerateRandom();

            int res1 = getResources().getIdentifier("img_"+value1,"drawable","com.example.dice_roll");
            int res2 = getResources().getIdentifier("img_"+value2,"drawable","com.example.dice_roll");
            img1.setImageResource(res1);
            img2.setImageResource(res2);
            if(value1 < value2){
                result.setText(getResources().getString(R.string.win));
                result.setTextColor(getResources().getColor(R.color.win));
            }else if(value1 > value2){
                result.setText(getResources().getString(R.string.loss));
                result.setTextColor(getResources().getColor(R.color.loss));
            }else{
                result.setText(getResources().getString(R.string.tie));
                result.setTextColor(getResources().getColor(R.color.tie));
            }

        });
    }

    public static int GenerateRandom(){
        return random.nextInt(6)+1;
    }
}