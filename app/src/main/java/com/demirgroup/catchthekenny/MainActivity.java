package com.demirgroup.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    TextView lblscore;
    TextView lbltime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
        lblscore=findViewById(R.id.textView2);
        lbltime=findViewById(R.id.lbltime);
        imageView2.setVisibility(View.INVISIBLE);
        durum(View.INVISIBLE);
        timecatch();

    }
    public void durum(int d){
        imageView1.setVisibility(d);
        imageView2.setVisibility(d);
        imageView3.setVisibility(d);
        imageView4.setVisibility(d);
        imageView5.setVisibility(d);
        imageView6.setVisibility(d);
        imageView7.setVisibility(d);
        imageView8.setVisibility(d);
        imageView9.setVisibility(d);

    }
    Runnable runnable;
    Handler handler;
    AlertDialog.Builder alert;
    Random random=new Random();
    int saglama=0, rndnumber ,score=0;
    public void timecatch(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                rndnumber=random.nextInt(9);
                if(rndnumber==0)
                    imageView1.setVisibility(View.VISIBLE);
                else if (rndnumber==1) {
                    imageView2.setVisibility(View.VISIBLE);
                } else if (rndnumber==2) {
                    imageView3.setVisibility(View.VISIBLE);
                } else if (rndnumber==3) {
                    imageView4.setVisibility(View.VISIBLE);
                } else if (rndnumber==4) {
                    imageView5.setVisibility(View.VISIBLE);
                } else if (rndnumber==5) {
                    imageView6.setVisibility(View.VISIBLE);
                }else if (rndnumber==6) {
                    imageView7.setVisibility(View.VISIBLE);
                }else if (rndnumber==7) {
                    imageView8.setVisibility(View.VISIBLE);
                }else {
                    imageView9.setVisibility(View.VISIBLE);
                }
                saglama++;
                if (saglama==2) {
                    durum(View.INVISIBLE);
                    saglama=0;
                }
                handler.postDelayed(runnable,500);
            }
         };
         handler.post(runnable);
         new CountDownTimer(10000,1000){
             @Override
             public void onTick(long l) {
                 lbltime.setText("Time: "+l/1000);
             }
             @Override
             public void onFinish() {
                 handler.removeCallbacks(runnable);
                 alert=new AlertDialog.Builder(MainActivity.this);
                 alert.setTitle("Restart Game");
                 alert.setMessage("Are you sure to restart game?");
                 alert.setPositiveButton("Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         timecatch();
                         score=0;
                     }
                 });
                 alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         Intent intent=new Intent(MainActivity.this, CatchTheKennyFirstScreen.class);
                         intent.putExtra("score",score);
                         startActivity(intent);
                     }
                 });
                 alert.show();
             }
         }.start();

    }
    public void click9(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click8(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click7(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click6(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click5(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click4(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click3(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click2(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }
    public void click1(View view){
        score++;
        lblscore.setText("Your score: "+score);
    }

}