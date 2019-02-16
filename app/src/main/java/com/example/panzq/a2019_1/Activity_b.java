package com.example.panzq.a2019_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ViewFlipper;

public class Activity_b extends AppCompatActivity {

    private final int RESULT_CODE = 0x200;
    private ViewFlipper myViewFlipper1;
    private float oldTouchValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_b);
        myViewFlipper1 = findViewById(R.id.myViewFlipper1);
        Intent intent = new Intent();
        intent.putExtra("result","来自Activity b");
        Activity_b.this.setResult(RESULT_CODE,intent);
        //Activity_b.this.finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                oldTouchValue = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = event.getX();
                Log.d("panzqww","oldTouchValue = "+oldTouchValue+" , currentX = "+currentX);
                if ((oldTouchValue - currentX <0 )&&Math.abs(oldTouchValue - currentX) > 120)
                {
                    myViewFlipper1.setInAnimation(AnimationHelper.inFromLeftAnimation());
                    myViewFlipper1.setOutAnimation(AnimationHelper.outToRightAnimation());
                    myViewFlipper1.showNext();
                }
                if ((oldTouchValue - currentX >0 )&&Math.abs(oldTouchValue - currentX) > 120)
                {
                    myViewFlipper1.setInAnimation(AnimationHelper.inFromRightAnimation());
                    myViewFlipper1.setOutAnimation(AnimationHelper.outToLeftAnimation());
                    myViewFlipper1.showPrevious();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
