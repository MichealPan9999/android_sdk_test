package com.example.panzq.a2019_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_safr;
    TextView tv_show;
    EditText et_password;
    CheckBox cb_show_hide;
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
        et_password = findViewById(R.id.et_password);
        cb_show_hide = findViewById(R.id.cb_show_hide);
        cb_show_hide.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cb_show_hide.isChecked())
                {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    cb_show_hide.setText("隐藏密码");
                }else{
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    cb_show_hide.setText("显示密码");
                }
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
                openOptionDialogAbout();
                break;
            case 1:
                openOptionDialogExit();
                break;
        }
        return true;
    }

    private void openOptionDialogAbout() {
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
    private void openOptionDialogExit() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.exit)
                .setMessage("确定要退出吗")
                .setPositiveButton(R.string.yes
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                .setNegativeButton(R.string.no,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
    }
}
