package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.kuanhsien.app.sample.android_mvvm_demo.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        greeting();
    }

    // may check app version, user-token, privilege, privacy policy or else in background
    private void greeting() {

        // simulate greeting for 3 seconds
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}
