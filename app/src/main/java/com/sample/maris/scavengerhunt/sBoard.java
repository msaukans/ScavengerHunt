package com.sample.maris.scavengerhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class sBoard extends AppCompatActivity {
    TextView tv1SBoard;
    ListView lv1SBoard;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_board);

        tv1SBoard = (TextView) findViewById(R.id.tv1SBoard);
        lv1SBoard = (ListView) findViewById(R.id.lv1SBoard);
    }
}
