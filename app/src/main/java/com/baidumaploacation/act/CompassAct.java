package com.baidumaploacation.act;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidumaploacation.R;

/**
 * Created by Administrator on 2018/3/15.
 */
public class CompassAct extends Activity {

    TextView textview;
    ImageView zhizhen;
    private SensorManager sm;
    private Sensor aSensor;
    private Sensor mSensor;

    float[] accelerometerValues = new float[3];
    float[] magneticFieldValues = new float[3];
    float[] values = new float[3];

    float[] R2 = new float[9];
    Matrix matrix = new Matrix();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compass);
        textview = (TextView) findViewById(R.id.weidu);
        zhizhen = (ImageView) findViewById(R.id.zhizhen);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        aSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(myListener, aSensor,
                SensorManager.SENSOR_DELAY_GAME);
        sm.registerListener(myListener, mSensor,
                SensorManager.SENSOR_DELAY_GAME);
    }


    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(myListener);

    }

    final SensorEventListener myListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                accelerometerValues = event.values;
            }
            if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                magneticFieldValues = event.values;
            }
            // 调用getRotaionMatrix获得变换矩阵R[]
            SensorManager.getRotationMatrix(R2, null, accelerometerValues,
                    magneticFieldValues);
            SensorManager.getOrientation(R2, values);
            // 经过SensorManager.getOrientation(R, values);得到的values值为弧度
            // 转换为角度
            values[0] = (float) Math.toDegrees(values[0]);

            textview.setText("x=" + Math.round(values[0]));
            zhizhen.setRotation(-(Math.round(values[0]) / 5 * 5));
        }
    };

}
