package com.example.rgdrys13.accelerometer;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

import java.util.Observable;

/**
 * Created by rgdrys13 on 9/6/2016.
 */
public class AccelerometerHandler implements SensorEventListener, Observable {

    // instance data
    private final static long ONE_SECOND_MILLISECONDS = 1000;
    private long prevTime;
    private SensorManager sensorManager;
    private Sensor accel;
    private MainActivity activity;

    public AccelerometerHandler(Activity activity){
        this.activity = (MainActivity) activity;
        // initialize SensorManager and Accelerometer
        sensorManager = (SensorManager) this.activity.getSystemService(Activity.SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_UI);

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        long currentTime = System.currentTimeMillis();

        if (currentTime - prevTime > ONE_SECOND_MILLISECONDS/2) {
            float z = sensorEvent.values[2];
            this.activity.newAccelZValue(z);
            prevTime=currentTime;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
