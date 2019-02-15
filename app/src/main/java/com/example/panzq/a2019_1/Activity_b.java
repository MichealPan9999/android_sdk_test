package com.example.panzq.a2019_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_b extends AppCompatActivity {

    private final int RESULT_CODE = 0x200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Intent intent = new Intent();
        intent.putExtra("result","来自Activity b");
        Activity_b.this.setResult(RESULT_CODE,intent);
        Activity_b.this.finish();
    }
}
