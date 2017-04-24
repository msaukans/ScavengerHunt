package com.sample.maris.scavengerhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    TextView tv1Info,tv2Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv1Info = (TextView) findViewById(R.id.tv1Info);
        tv2Info = (TextView) findViewById(R.id.tv2Info);

        tv2Info.setText("This app is basically.....");
    }
}
