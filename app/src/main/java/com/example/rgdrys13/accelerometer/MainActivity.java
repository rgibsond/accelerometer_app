package com.example.rgdrys13.accelerometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer{

    // instance data
    private TextView zAccelView;
    private AccelerometerHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zAccelView = (TextView) findViewById(R.id.z_accel_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler = new AccelerometerHandler(this);
    }

    public void newAccelZValue(float z){
        zAccelView.setText(Float.toString(z));
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
