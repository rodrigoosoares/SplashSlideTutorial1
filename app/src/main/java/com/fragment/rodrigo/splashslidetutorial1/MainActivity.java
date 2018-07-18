package com.fragment.rodrigo.splashslidetutorial1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Main);
        toolbar = findViewById(R.id.toolbar);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

    }
}
