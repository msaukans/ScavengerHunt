package com.sample.maris.scavengerhunt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class StepCounter extends AppCompatActivity implements SensorEventListener{

    private SensorManager sense; //create sensor manager
    private TextView countTv;
    boolean working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        countTv = (TextView) findViewById(R.id.countTv);
        sense = (SensorManager) getSystemService(Context.SENSOR_SERVICE); //set up sensor manager
    }

    @Override
    protected void onResume() {
        super.onResume();
        working = true;
        Sensor countSensor = sense.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null) {
            sense.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Error has occurred!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        working = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(working) {
            countTv.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
