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

        tv2Info.setText("\t Scavenger Hunt app is a game where the user walks around the town and " +
                "visits specific landmarks in order to gain points. The points are calculated by" +
                "timing how long it took the user to get there, how many steps they had to take to get there, " +
                " how they traveled there eg. by foot or car (if it was by foot they will get extra marks " +
                " because they the point of the app is to get to know the city), the user could also complete " +
                "side tasks that you can be completed by long clicking on tasks and youll receive an option" +
                " to either complete task by taking a video or picture, each option has different amount" +
                " of points going for it. " +
                "\n \n \t The point of this app is that it is cheaper than having a guide show you around and it also is" +
                "more of a fun way to get to know the city.");
    }
}
