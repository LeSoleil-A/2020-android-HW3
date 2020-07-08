package com.example.test_0708_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_first;
    private Button btn_second;
    private Button btn_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_first = findViewById(R.id.btn_lottie);
        btn_first.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LottieActivity.class);
                startActivity(intent);
                Log.i("MainActivity", " on Click: Lottie ");
            }
        });
        btn_second = findViewById(R.id.btn_oani);
        btn_second.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OaniActivity.class);
                startActivity(intent);
                Log.i("MainActivity", " on Click: Object_ani ");
            }
        });
        btn_third= findViewById(R.id.btn_tab);
        btn_third.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
                Log.i("MainActivity", " on Click: ViewPager and TabLayout ");
            }
        });
    }
}
