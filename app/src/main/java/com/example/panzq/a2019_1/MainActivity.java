package com.example.panzq.a2019_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_safr;
    TextView tv_show;
    private final int REQUEST_CODE = 0x100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDiaplayMetrics();

        btn_safr = findViewById(R.id.btn_safr);
        tv_show = findViewById(R.id.tv_show);
        btn_safr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_b.class);
                startActivityForResult(intent, REQUEST_CODE);
                tv_show.setTypeface(Typeface.createFromAsset(getAssets(), "BinnerD.ttf"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String result = data.getExtras().getString("result");
            Log.d("panzqww", "requestCode = " + requestCode + ", resultCode = " + resultCode + " , result = " + result);
        }
    }

    private void getDiaplayMetrics() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        String strMetrics = "手机分辨率为：" + dm.widthPixels + " * " + dm.heightPixels;
        String strdm = " 手机屏幕信息：" + dm.toString();
        Log.d("panzqww", strMetrics);
        Log.d("panzqww", strdm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, R.string.about);
        menu.add(0, 1, 1, R.string.exit);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                openOptionDialog();
                break;
            case 1:
                finish();
                break;
        }
        return true;
    }

    private void openOptionDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage("版本号 V1.1.8")
                .setPositiveButton(R.string.confirm
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
    }
}
