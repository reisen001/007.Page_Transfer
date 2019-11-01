package com.example.transfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitypageB extends AppCompatActivity {
    private Button mSent_to_pageA;

    private TextView show_TextB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitypage_b);
        Log.e("chiyonglai","===========22222222=========================");

        show_TextB =(TextView)findViewById(R.id.textView_showStringA);

        Bundle bundleA = getIntent().getExtras();

            String get_sentA = bundleA.getString("stringA");
            Log.e("chiyonglai", "===========" + get_sentA.toString() + "=========================");
            show_TextB.setText(get_sentA);

        mSent_to_pageA =(Button)findViewById(R.id.button_Transfer_B);
        mSent_to_pageA.setOnClickListener(mSent_to_pageAOnClick);

    }


   private View.OnClickListener mSent_to_pageAOnClick = (new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText sentTextB =(EditText)findViewById(R.id.Transfer_TextB);
            Intent intent = new Intent();
            intent.setClass(ActivitypageB.this, ActivitypageA.class);
            Bundle bundleB =new Bundle();
            bundleB.putString("stringB",sentTextB.getText().toString());
            intent.putExtras(bundleB);
            startActivity(intent);
        }

    });
}
