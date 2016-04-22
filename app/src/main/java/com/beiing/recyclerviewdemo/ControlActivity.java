package com.beiing.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
    }

    public void goMainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void goFirstActivity(View view) {
        startActivity(new Intent(this, FirstActivity.class));
    }


    public void goGridLayoutActivity(View view) {
        startActivity(new Intent(this, GridLayoutActivity.class));
    }

    public void goStaggerActivity(View view) {
        startActivity(new Intent(this, StaggerActivity.class));
    }
}
