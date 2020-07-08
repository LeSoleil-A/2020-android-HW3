package com.example.test_0708_1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;

public class LottieActivity extends AppCompatActivity {

    private LottieAnimationView lottieAnimationView;
    private CheckBox checkBox;
    private SeekBar seekBar;
    private float pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        lottieAnimationView =findViewById(R.id.lottie_image);
        seekBar = findViewById(R.id.seek_bar);
        checkBox = findViewById(R.id.loop_checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 当选中自动播放的时候，开始播放 lottie 动画，同时禁止手动修改进度
                    lottieAnimationView.playAnimation();
                    lottieAnimationView.setProgress(pos);
                    seekBar.setEnabled(false);
                } else {
                    // 当去除自动播放时，停止播放 lottie 动画，同时允许手动修改进度
                    lottieAnimationView.pauseAnimation();
                    seekBar.setEnabled(true);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pos = (float)progress/100;
                lottieAnimationView.setProgress(pos);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }




}
