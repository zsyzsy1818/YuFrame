package com.yu.yuframe.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.yu.yuframe.R;

/**
 * Created by Yu on 2016/4/26.
 * Email:zhaoshiyu900310@163.com
 */
public class BaseMap2DActivity extends AppCompatActivity {

    private AMap aMap;
    private com.amap.api.maps2d.MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_gaode_basemap2d_activity);
        this.mapView = (MapView) findViewById(R.id.test_gaode_basemap2d_activity_MapViewId);
        if (mapView != null) {
            mapView.onCreate(savedInstanceState);
            aMap = mapView.getMap();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}

