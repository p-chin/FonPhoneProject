package com.adamrocker.android.test.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Window;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class Activity1 extends Activity {

	//�F�X�ƁA�ǂݍ��ޏ����I�I
	//static�́A���N���X�Ƃ̘A�g���M���I
	static Paint jikimaePaint = new Paint();
	static Paint BossPaint = new Paint();
	static Paint ballPaint = new Paint();
	static Paint tamaPaint = new Paint();
	static Paint lifePaint = new Paint();
	static Bitmap jikiBitmap;
	static Bitmap bossBitmap;
	static Bitmap tekikiaBitmap;
	static Bitmap tamaBitmap;
	static Bitmap tekitamaBitmap;
	static Bitmap lifeBitmap;
	static Bitmap bgimage0;
	static Bitmap bgimage;
	static Bitmap bgimage2;
	static Bitmap zakoteki;
	static Bitmap powerup;
	static Bitmap agauge;
	static Bitmap dgauge;
	static Bitmap titleapple;
	static Bitmap titledroid;
	static Bitmap hardbotton;
	static Bitmap nomalbotton;
	static Bitmap tekibosstamaBitmap;
	static Bitmap tate;
	static Bitmap yoko;
	static Bitmap gameover;
	static Bitmap dekaapple;
	static Bitmap sdapple;
	static Bitmap lastboss;

	static SoundPool mSoundPool;
	static int[] mSounds = new int[5];

	static MediaPlayer mp;
	static MediaPlayer mp2;
	static MediaPlayer mp3;
	static MediaPlayer mp4;
	static MediaPlayer mp5;
	static MediaPlayer mp6;

	static Vibrator vibrator;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //��̃^�C�g���̂������
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //�o�C�u���[�^�ݒ�
        setContentView(new StgSurfaceView(this));
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        //���y�̓ǂݍ���
        //MP�́Aloop���邵�Ȃ��̐ݒ�ł���
        //�X�ɁA�f�J���t�@�C���ɂ��Ή�
        mp = MediaPlayer.create(this,R.raw.stage);
        mp.setLooping(true);
        mp2 = MediaPlayer.create(this,R.raw.select);
        mp2.setLooping(false);
        mp3 = MediaPlayer.create(this,R.raw.gamestart);
        mp3.setLooping(false);
        mp4 = MediaPlayer.create(this,R.raw.kaiwa);
        mp4.setLooping(true);
        mp5 = MediaPlayer.create(this,R.raw.boss);
        mp5.setLooping(true);
        mp6 = MediaPlayer.create(this,R.raw.bakuhatu);
        mp6.setLooping(true);


    }
    @Override // Activity�̃��C�t�T�C�N���̃��\�b�h
    public void onResume(){
    	super.onResume();
    	Resources res = getResources();
    	// ���\�[�X����摜�t�@�C����ǂݍ���
    	bgimage0 = BitmapFactory.decodeResource(res, R.drawable.shokihaikei);
    	bgimage = BitmapFactory.decodeResource(res, R.drawable.earthrise);
    	bgimage2 = BitmapFactory.decodeResource(res, R.drawable.bgimage2);
		jikiBitmap = BitmapFactory.decodeResource(res,R.drawable.spaceship);
		bossBitmap = BitmapFactory.decodeResource(res,R.drawable.enemy);
		tamaBitmap = BitmapFactory.decodeResource(res,R.drawable.mybullet);
		tekitamaBitmap = BitmapFactory.decodeResource(res,R.drawable.bullet);
		zakoteki = BitmapFactory.decodeResource(res,R.drawable.zakoteki);
		powerup = BitmapFactory.decodeResource(res,R.drawable.thunder);
		agauge = BitmapFactory.decodeResource(res,R.drawable.agauge);
		dgauge = BitmapFactory.decodeResource(res,R.drawable.dgauge);
		titleapple = BitmapFactory.decodeResource(res,R.drawable.titleapple);
		titledroid = BitmapFactory.decodeResource(res,R.drawable.titledroid);
		hardbotton = BitmapFactory.decodeResource(res,R.drawable.hard);
		nomalbotton = BitmapFactory.decodeResource(res,R.drawable.normal);
		tekibosstamaBitmap = BitmapFactory.decodeResource(res,R.drawable.tekitama2);
		tate = BitmapFactory.decodeResource(res,R.drawable.tate);
		yoko = BitmapFactory.decodeResource(res,R.drawable.yoko);
		gameover = BitmapFactory.decodeResource(res,R.drawable.gameover);
		dekaapple = BitmapFactory.decodeResource(res,R.drawable.dekaapple);
		sdapple = BitmapFactory.decodeResource(res,R.drawable.sdapple);
		lastboss = BitmapFactory.decodeResource(res,R.drawable.lastboss);



		 // �������[�h���Ă���
		//SP�́A�Z���t�@�C���iSE�j�ɂ悭�g��
		//���[�v�́A���Ȃ�
		mSoundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		mSounds[0] = mSoundPool.load(this, R.raw.powerup, 1);














    }
@Override  // Activity�̃��C�t�T�C�N���̃��\�b�h
public void onPause(){
	super.onPause();
	finish(); // onDestroy()���Ă΂��
}
}