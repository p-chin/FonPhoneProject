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
 *�`��p�׽
 */
public class StgSurfaceView extends SurfaceView  {
	private StgSurfaceHolderCallback cb = null;

	// �X���Z���T�[�p�̕ϐ�
	private SensorManager mSensorManager;
	private float mPitch;
	private float mRoll;



	public StgSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		SurfaceHolder holder = getHolder();
		//cb�ɂ́ApSurfaceHolderCallback�N���X�̏��
		//�S�ċl�܂��Ă���
		//�unew�v�œ���Ă���
		cb = new StgSurfaceHolderCallback();
		holder.addCallback(cb);
		 initialize(context);
	}






	@Override // SurfaceView�̃T�C�Y���擾
	protected void onSizeChanged(int w, int h, int oldw, int oldh){
		cb.vieww = w; cb.viewh = h;
	}

	@Override // �^�b�`���ꂽ�ʒu���擾
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX(); // ���W���擾
		float y = event.getY(); // ���W���擾
		cb.getTouchPosition(x,y);
		return true;
	}



	 private void initialize(Context context) {

			// �X����������
	    	mPitch = 0;
	    	mRoll = 0;

			// SensorManager���擾
			mSensorManager = (SensorManager)context.getSystemService(
					Context.SENSOR_SERVICE);

			// �C�x���g�n���h����o�^
			mSensorManager.registerListener(
				new SensorEventListener() {
					@Override
					public void onAccuracyChanged(
						Sensor sensor, int accuracy) {
					}

					@Override
					public void onSensorChanged(
						SensorEvent event) {
						// �X�����X�V
						mPitch = event.values[SensorManager.DATA_Y];
						mRoll = event.values[SensorManager.DATA_Z];
						//�R�[���o�b�N�ɁA��񑗂�
						cb.getSensorPosition(mPitch,mRoll);

					}
				},
				//�Z���T�[�̑������A�ݒ�
				mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);
	 }
}