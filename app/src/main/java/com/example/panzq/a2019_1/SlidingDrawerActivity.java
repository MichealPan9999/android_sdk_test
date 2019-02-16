package com.example.panzq.a2019_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class SlidingDrawerActivity extends AppCompatActivity {

    private GridView gv;
    private SlidingDrawer sd;
    private ImageView im;
    private int[] icons = {R.drawable.apple_pic,R.drawable.banana_pic,R.drawable.cherry_pic};
    private String[] items = {"苹果","香蕉","樱桃"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_drawer);
        gv = findViewById(R.id.gv_myGridView);
        sd = findViewById(R.id.sd_mySlidingDrawer);
        im = findViewById(R.id.iv_myImage);
        MyGridviewAdapter adapter = new MyGridviewAdapter(this,items,icons);
        gv.setAdapter(adapter);
        sd.setOnDrawerOpenListener(new OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                im.setImageResource(R.drawable.open);
            }
        });
        sd.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                im.setImageResource(R.drawable.close);
            }
        });
    }
}
