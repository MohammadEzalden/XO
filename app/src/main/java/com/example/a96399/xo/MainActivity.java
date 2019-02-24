package com.example.a96399.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a96399.xo.offline.OffLineActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void offLineF(View view) {
        Intent intent=new Intent(this, OffLineActivity.class);
        startActivity(intent);

    }

    public void onLinef(View view) {
    }
}
