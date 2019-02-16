package com.example.panzq.a2019_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LindifyActivity extends AppCompatActivity {

    private TextView mTvContent;
    private EditText mEtContent;
    private Button mBtnLinkify;
    /*所有手机号码：regexp="^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    区号+座机号码+分机号码：regexp="^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$"*/
    private String regexp1 =  "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    private String regexp2= "^((0\\d{2,3})-)(\\d{7,8})(-(\\d{3,}))?$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lindify);
        mTvContent = findViewById(R.id.tv_content);
        mEtContent = findViewById(R.id.et_linkify);
        mBtnLinkify = findViewById(R.id.btn_Linkify);
        mBtnLinkify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linkify();
            }
        });
    }

    private void linkify() {
        mTvContent.setText(mEtContent.getText());
        Linkify.addLinks(mTvContent,
                Linkify.WEB_URLS |
                        Linkify.EMAIL_ADDRESSES|
                        Linkify.PHONE_NUMBERS);
    }

    private boolean isPhoneNumber(String text) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile(regexp1);
        Matcher matcher = pattern.matcher(text);
        Pattern pattern2 = Pattern.compile(regexp2);
        Matcher matcher2 = pattern2.matcher(text);
        if (matcher.matches() || matcher2.matches())
        {
            isValid = true;
        }
        Log.d("panzqww",text+"is phoneNumber ?"+isValid);
        return isValid;

    }
}
