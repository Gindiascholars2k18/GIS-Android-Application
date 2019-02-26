package com.Gindiascholars2k18;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.splash_screen_app_name_text1)
    TextView appNameText1;
    @BindView(R.id.splash_screen_app_name_text2)
    TextView appNameText2;
    @BindView(R.id.splash_screen_app_name_text3)
    TextView appNameText3;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        int SPLASH_TIME_OUT = 1750;

        appNameText2.setVisibility(View.INVISIBLE);
        appNameText3.setVisibility(View.INVISIBLE);
        appNameText1.setAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_screen_animation));
        new Handler().postDelayed(() -> {
            appNameText2.setAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_screen_animation));
            appNameText2.setVisibility(View.VISIBLE);
        }, 250);
        new Handler().postDelayed(() -> {
            appNameText3.setAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_screen_animation));
            appNameText3.setVisibility(View.VISIBLE);
        }, 500);

        ValueAnimator animator = ValueAnimator.ofInt(0, progressBar.getMax());
        animator.setDuration(SPLASH_TIME_OUT);
        animator.addUpdateListener(animation1 -> progressBar.setProgress((Integer) animation1.getAnimatedValue()));
        animator.start();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
