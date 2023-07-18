package com.demirgroup.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CatchTheKennyFirstScreen extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_the_kenny_first_screen);
        sharedPreferences=this.getSharedPreferences("com.demirgroup.catchthekenny", Context.MODE_PRIVATE);
        textView=findViewById(R.id.lblfirstscreenscore);
        intent=getIntent();
        int score=intent.getIntExtra("score",0);
        sharedPreferences.edit().putInt("Score",score).apply();
        textView.setText("Score: "+sharedPreferences.getInt("Score",0));
    }
    Intent intent;
    public void openKenny(View view){
        intent=new Intent(CatchTheKennyFirstScreen.this,MainActivity.class);
        startActivity(intent);
    }
}