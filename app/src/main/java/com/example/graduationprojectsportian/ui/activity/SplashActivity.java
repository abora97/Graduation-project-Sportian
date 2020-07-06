package com.example.graduationprojectsportian.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.graduationprojectsportian.R;
import com.example.graduationprojectsportian.ui.intro.IntroAppActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int MAKE_CALL_PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getCallPermissions();

        //set animation to imageView
        ImageView imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.startAnimation(animation);
    }

    private void getCallPermissions() {

        if (checkPermission(Manifest.permission.CALL_PHONE)) {
            timerStart();
        } else {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MAKE_CALL_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case MAKE_CALL_PERMISSION_REQUEST_CODE :
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    timerStart();
                }else {
                    finish();
                }
                return;
        }
    }
    private boolean checkPermission(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }
    private void timerStart() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, IntroAppActivity.class));
            finish();
        }, 4000);
    }
}
