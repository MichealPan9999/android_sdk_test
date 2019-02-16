package com.example.panzq.a2019_1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AnalogClock;
import android.widget.TextView;

import java.util.Calendar;

public class ClockActivity extends AppCompatActivity {

    private static final int GUINOTIFIER = 0x1234;

    private TextView mTextView;
    private AnalogClock mAnalogClock;
    private Calendar mCalendar;
    private int mMinutes;
    private int mHour;
    private int mSeconds;
    private Handler mHandler;
    private Thread mClockThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        mTextView = findViewById(R.id.tv_showClock);
        mAnalogClock = findViewById(R.id.ac_myAnalogClock);

        mHandler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {

                switch (msg.what)
                {
                    case GUINOTIFIER:
                        mTextView.setText(mHour+":"+mMinutes+":"+mSeconds);
                        break;
                }
                super.handleMessage(msg);
            }
        };
        mClockThread = new LooperThread();
        mClockThread.start();
    }

    class LooperThread extends Thread
    {
        @Override
        public void run() {
            super.run();
            try{

                do {
                    long time = System.currentTimeMillis();
                    mCalendar = Calendar.getInstance();
                    mCalendar.setTimeInMillis(time);
                    mHour = mCalendar.get(Calendar.HOUR);
                    mMinutes = mCalendar.get(Calendar.MINUTE);
                    mSeconds = mCalendar.get(Calendar.SECOND);
                    Thread.sleep(1000);
                    Message m = new Message();
                    m.what = GUINOTIFIER;
                    mHandler.sendMessage(m);
                }while(LooperThread.interrupted() == false);
            }catch(Exception e){
                e.printStackTrace();
            }


        }
    }
}

