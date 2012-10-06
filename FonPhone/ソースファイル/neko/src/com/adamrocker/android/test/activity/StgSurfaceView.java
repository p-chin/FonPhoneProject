package com.adamrocker.android.test.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.MotionEvent;

/**
 *描画用ｸﾗｽ
 */
public class StgSurfaceView extends SurfaceView  {
	private StgSurfaceHolderCallback cb = null;

	// 傾きセンサー用の変数
	private SensorManager mSensorManager;
	private float mPitch;
	private float mRoll;



	public StgSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		SurfaceHolder holder = getHolder();
		//cbには、pSurfaceHolderCallbackクラスの情報が
		//全て詰まっている
		//「new」で入れている
		cb = new StgSurfaceHolderCallback();
		holder.addCallback(cb);
		 initialize(context);
	}






	@Override // SurfaceViewのサイズを取得
	protected void onSizeChanged(int w, int h, int oldw, int oldh){
		cb.vieww = w; cb.viewh = h;
	}

	@Override // タッチされた位置を取得
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX(); // 座標を取得
		float y = event.getY(); // 座標を取得
		cb.getTouchPosition(x,y);
		return true;
	}



	 private void initialize(Context context) {

			// 傾きを初期化
	    	mPitch = 0;
	    	mRoll = 0;

			// SensorManagerを取得
			mSensorManager = (SensorManager)context.getSystemService(
					Context.SENSOR_SERVICE);

			// イベントハンドラを登録
			mSensorManager.registerListener(
				new SensorEventListener() {
					@Override
					public void onAccuracyChanged(
						Sensor sensor, int accuracy) {
					}

					@Override
					public void onSensorChanged(
						SensorEvent event) {
						// 傾きを更新
						mPitch = event.values[SensorManager.DATA_Y];
						mRoll = event.values[SensorManager.DATA_Z];
						//コールバックに、情報送る
						cb.getSensorPosition(mPitch,mRoll);

					}
				},
				//センサーの速さを、設定
				mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);
	 }
}