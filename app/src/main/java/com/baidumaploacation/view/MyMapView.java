package com.baidumaploacation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidumaploacation.move.MoveActivity;

public class MyMapView extends MapView {

	
	
	public MyMapView(Context arg0, AttributeSet arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		GeoPoint g = this.getProjection().fromPixels(MyIcon.w, MyIcon.h);
		Log.i("============", "wwwwwwwwww======" + MyIcon.w);
		Log.i("============", "hhhhhhhhhh======" + MyIcon.h);
		MoveActivity.getPosition(g);
		return super.onTouchEvent(arg0);
	}
}
