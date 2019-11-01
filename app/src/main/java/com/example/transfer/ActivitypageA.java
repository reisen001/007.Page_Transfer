package com.example.transfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitypageA extends AppCompatActivity {
    private Button mSent_to_pageB;

    private TextView show_TextB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitypage_a);
        show_TextB =(TextView)findViewById(R.id.textView_showStringB);
        mSent_to_pageB =(Button)findViewById(R.id.button_Transfer_A);
        mSent_to_pageB.setOnClickListener(mSent_to_pageBOnClick);

        Bundle bundleB = getIntent().getExtras();

        if (bundleB != null) {
            String get_sentB = bundleB.getString("stringB");
            show_TextB.setText(get_sentB);
        }



    }
    private View.OnClickListener mSent_to_pageBOnClick = (new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText sentText =(EditText)findViewById(R.id.Transfer_TextA);
            Intent intent = new Intent();
            intent.setClass(ActivitypageA.this, ActivitypageB.class);
            Bundle bundleA =new Bundle();
            bundleA.putString("stringA",sentText.getText().toString());
            intent.putExtras(bundleA);
            Log.e("chiyonglai","===========1111111111111=========================");

            startActivity(intent);



        }

    });

}
