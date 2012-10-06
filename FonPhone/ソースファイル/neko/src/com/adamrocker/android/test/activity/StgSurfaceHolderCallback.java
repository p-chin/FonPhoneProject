

package com.adamrocker.android.test.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.SurfaceHolder;
import android.media.SoundPool;

public class StgSurfaceHolderCallback implements SurfaceHolder.Callback,Runnable {
	private SurfaceHolder holder = null;
	private Thread thread = null;
	private boolean isThreadrunning = true;
	private float touchx,touchy; // �^�b�`���ꂽx���W
	int vieww, viewh; // SurfaveView�̕��ƍ���
	private Paint paintlife, paintlife2;//���C�t�Ɣ�e���̌���
	private final int halfsizeofspaceship = 46; // �摜�̃T�C�Y 72x87
	private final int halfsizeofenemy = 32; // �摜�̃T�C�Y 65x9
	private long score=4; //�X�R�A�i�A�C�e�������̊֌W�ŏ����l��0�ɂł��Ȃ��j



	// �X���Z���T�[�p�̕ϐ�
	private float mmPitch;
	private float mmRoll;



	SoundPool sp;//SE�̓ǂݍ���




	/*jiki�̍��W*/
	float JikiX=150;
	float JikiY=350;
	/*tama�̍��W�R�����ƁA�R�v�`�x�e*/
	float JikiTamaX=JikiX+23;
	float JikiTamaY=JikiY-4;
	/*tama4�̍��W3*/
	float JikiTamaX4=JikiX+23;
	float JikiTamaY4=JikiY-4;
	/*tama5�̍��W3*/
	float JikiTamaX5=JikiX+23;
	float JikiTamaY5=JikiY-4;
	/*tama6�̍��W3*/
	float JikiTamaX6=JikiX+23;
	float JikiTamaY6=JikiY-4;

	//��������A��ܰ���ߒe//

	/*tama2�̍��W�p���[�A�b�v�J�E���g���P*/
	float JikiTamaX2=JikiX;
	float JikiTamaY2=JikiY-4;
	/*tama3�̍��W�p���[�A�b�v�J�E���g���Q*/
	float JikiTamaX3=JikiX+46;
	float JikiTamaY3=JikiY-4;


	//jikitama����
	float JikiTamaV = 40;
	float JikiTamaV2 = 40;
	float JikiTamaV3 = 40;
	float JikiTamaV4 = 20;
	float JikiTamaV5 = 30;
	float JikiTamaV6 = 50;

	int e12;//�G���f�B���O�iFin.�j�̍��W


	//�{�X�̏������W
	int BossX=150;
	int BossY=30;
	//����
	int Bossvx = 5;
	int Bossvy = 5;
	/*�{�X��tama1�̍��W*/
	float btx=BossX+20;
	float bty=BossY-10;





	float bosstamax1 = BossX+32;
	float bosstamax2 = BossX+32;
	float bosstamax3 = BossX+32;
	float bosstamax4 = BossX+32;

	float bosstamay1 = BossY+47;
	float bosstamay2 = BossY+47;
	float bosstamay3 = BossY+47;
	float bosstamay4 = BossY+47;

	int bosstamacount = 1;

	/*�{�X��tama1�̑��x*/
	float btvx=10;
	float btvy=20;



	//sdapple�̍��WAnd���x�iv�j
	float sdX;
	float sdY;
	float sdV=20;
	float sdX2;
	float sdY2;
	float sdX3;
	float sdY3;
	float sdV2=30;
	float sdXV3=20;
	float sdYV3=20;






	/*�G/�W�L�̗̓Q�[�W�̗̑�*/
	int BossHP = 280;
	int JikiHP = 279;

	//�U�R�̍��WAnd���x�iv�j
	float Zx;
	float Zy;
	float Zv=20;
	float Zx1;
	float Zy1;
	float Zx2;
	float Zy2;
	float Zv1=30;
	float Zxv2=20;
	float Zyv2=20;


	//�U�R�̔��]
	float hanten = -1;


	//�p���[�A�b�vItem���W�E���x
	float PUx=vieww/2;
	float PUy=-50;//���̏����ŏo������I�u�W�F�N�g�͉�ʊO�őҋ@
	float PUv=5;
	float powerupcount;//����p���[�A�b�v���Ă邩�J�E���g

	//score���_��pawerUpItem�������邩�ݒ肷��ϐ�
	//long�^�́A��ȏ���J�E���g�ł���
	long scorediv=40;

	//�U�R�������ʂ�������������J�E���g������
	 int zakocount = 0;


	 //�F�ϐ�,���߂����߂�
	 int colR = 255;
	 int colG = 255;
	 int colB = 255;
	 int colR2 = 255;
	 int colG2 = 255;
	 int colB2 = 255;
	 int colR3 = 255;
	 int colG3 = 255;
	 int colB3 = 255;
	 int colR4 = 255;
	 int colG4 = 255;
	 int colB4 = 255;
	 int colR5 = 255;
	 int colG5 = 255;
	 int colB5 = 255;
	 int colR6 = 255;
	 int colG6 = 255;
	 int colB6 = 255;
	 int colR7 = 255;
	 int colG7 = 255;
	 int colB7 = 255;
	 int colR8 = 255;
	 int colG8 = 255;
	 int colB8 = 255;
	 int colR9 = 255;
	 int colG9 = 255;
	 int colB9 = 255;
	 int colR10 = 255;
	 int colG10 = 255;
	 int colB10 = 255;
	 int fl =255;



	 //���́A���a�ϐ� + �~�̐F�ϐ�
	 int divCircle1;
	 int divCircle2;
	 int divCircle3;
	 int divCircle4;
	 int divCircle5;
	 int divCircle6;
	 int divCircle7;
	 int divCircle8;
	 int divCircle9;
	 int CirCol1=150;
	 int CirCol2=150;
	 int CirCol3=150;
	 int CirCol4=150;
	 int CirCol5=150;
	 int CirCol6;
	 int CirCol7;
	 int CirCol8;
	 int CirCol9;
	 int CirCol10;
	 int CirCol11;
	 int CirCol12;




////////////////////////////////////////////////////////////
////////////////�t���O�{�t���O�֌W�ϐ�//////////////////////
////////////////////////////////////////////////////////////

	/*�e�t���O�̐ݒ�*/
	public boolean tflag;
	/*�G�{�[���t���O�̐ݒ�*/
	public boolean tekiAtariflag=false;
	public boolean jikiAtariflag=false;
	public boolean 	patoricAtariflag=false;
	public boolean Bosstamaflag=false;
	//Jiki�̒e�����t���O
	public boolean 	JikiTamaflag=true;
	public boolean JikiTamaflag2=false;
	public boolean JikiTamaflag3=false;
	//teki�̒e�����t���O
	public boolean 	TekiTamaflag=true;
	public boolean Bossxyflag=false;
	//zako�̔����t���O
	public boolean zakoflag=true;
	public boolean zakoflag1=false;
	public boolean zakoflag2=false;
	public boolean zakocountflag=false;

	//�p���[�A�b�vItem�̔����t���O
	public boolean PUflag=false;


	//�G�p���[�A�b�v�t���O
	public boolean normal1=false;
	public boolean stage2power=false;
	public boolean normal2=false;
	public boolean stage1power=false;


	//��b��ʃt���O
	public boolean kaiwa;
	public boolean kaiwa01 = false;
	public boolean kaiwa02 = false;
	public boolean kaiwa03 = false;
	public boolean kaiwa04 = false;
	public boolean kaiwa05 = false;
	public boolean kaiwa06 = false;
	public boolean kaiwa07 = false;
	public boolean kaiwa08 = false;
	public boolean kaiwa09 = false;
	public boolean kaiwa10 = false;



	//��ʕ����ύX�˗��t���O
	public boolean tategamen = false;
	public boolean yokogamen = true;
	public boolean yokogamen2=false;


	//��e����flash�t���O
	public boolean flash=false;


	//��b���e���̊Ԃ̃X���[�v�t���O
	public boolean sleep=true;

	//stage�t���O
	public boolean stage1 =false;
	public boolean stage2 =false;



	//�G���ŃG�t�F�N�g�t���O
	public boolean deleteA=false;

	//�G���f�B���O�t���O
	public boolean ending;



	//�G�ړ��t���O
	//���̃t���O��ŕ��̂̓�����ON/off����
	public boolean Tmove=true;


	//STAGE�I����ʃt���O
	public boolean stageselect = false;



	//�X���b�h�N���t���O
	public boolean gamestart = false;


	//�p���[�A�b�vItem�̔�������m��
	float PUpersent;

	// �R���X�g���N�^�i�󂯎M�j
	public StgSurfaceHolderCallback(){


	}


//////////////////////////////////////////////////////////////////

	// �X�����擾
	public void getSensorPosition(float mPitch,float mRoll){
		mmRoll = mRoll;
		mmPitch = mPitch;
	}






// �^�b�`���ꂽ�ʒu���擾
public void getTouchPosition(float x,float y){
	touchx = x;
	touchy = y;
}

//////////////////////////////////////////////////////////////////

// �R�[���o�b�N�֐�
// �T�[�t�F�C�X��������(SurfaceHolder.Callback�N���X�̃��\�b�h���p�����Ă���)
@Override
public void surfaceCreated(SurfaceHolder holder) {
// TODO Auto-generated method stub
// �e��̏��������B�X���b�h�̊J�n�O��
this.holder = holder;

// �X���b�h�̊J�n
thread = new Thread(this);
thread.start();


}

//////////////////////////////////////////////////////////////////

// �R�[���o�b�N�֐�
// �T�[�t�F�C�X�ύX����(SurfaceHolder.Callback�N���X�̃��\�b�h���p�����Ă���)
@Override
public void surfaceChanged(SurfaceHolder holder, int format, int width,
int height) {
// TODO Auto-generated method stub
}

//////////////////////////////////////////////////////////////////

// �R�[���o�b�N�֐�
// �T�[�t�F�C�X�j��(SurfaceHolder.Callback�N���X�̃��\�b�h���p�����Ă���)
@Override
public void surfaceDestroyed(SurfaceHolder holder) {
// TODO Auto-generated method stub
// �X���b�h�̏I��
boolean retry = true;
synchronized (this.holder) {
isThreadrunning = false;
}
while (retry) {
try {
thread.join();
retry = false;
} catch (InterruptedException e) {
}
}
thread = null;
}






////////////////////////////////���C�����[�v//////////////////////////////////

@Override
public void run() {
// TODO Auto-generated method stub
// �Q�[���̃��C�����[�v
while (isThreadrunning) {
synchronized (holder) {










////��b���I���ƃQ�[���X�^�[�g
	///���Ȃ݂ɂ���if���́@}�@����Canvas canvas = holder.lockCanvas();
	///�̑O�ɏ����Ȃ��Ɖ�b��ʂ���\�����Ȃ����璍�ӂ��K�v�ł�
	if(gamestart){




		if(sleep){
			 try{
					Thread.sleep(2000); // ����͂킴��2�b�ԃX���[�v
					} catch (InterruptedException ie){}
					sleep=false;

		}


		///�U�R���܉�ʂ�߂��邩�|�����̂�҂��܂��傤
		///����ƃ{�X������܂���,���񂿂����傤
		if(zakocount > 5){
			zakocountflag = true;
		}

		//�X�e�[�W�ȍĐ�
		Activity1.mp.start();




////////////Jiki�ړ�����///////////////

		if(mmPitch<0){//��
			JikiY+=8;
		}
		if(mmPitch>0){//��
			JikiY-=8;
		}
		if(mmRoll>0){//��
			JikiX-=8;
		}
		if(mmRoll<0){//�E
			JikiX+=8;
		}





	//��ʊO�֍s���Ȃ��ׂ�
	if(JikiX>=vieww-72){
		JikiX=vieww-72;
	}
	else if(JikiX<=0){
		JikiX=0;
	}
	if(JikiY>=viewh-87){
		JikiY=viewh-87;
	}
	else if(JikiY<=0){
		JikiY=0;
	}
/*
	// �E�ړ�
	if(JikiX + halfsizeofspaceship < touchx){
		float distance1 = touchx - JikiX + halfsizeofspaceship;
		JikiX = JikiX  + distance1 / 10;
	// ���ړ�
	}else if
		(JikiX + halfsizeofspaceship > touchx){
		 float distance2 = JikiX + halfsizeofspaceship - touchx;
		 JikiX = JikiX - distance2 / 10;
	}
	// ��ړ�
	if(JikiY + halfsizeofspaceship > touchy){
		 float distance3 =JikiY + halfsizeofspaceship - touchy;
			JikiY = JikiY - distance3 / 10;
	// ���ړ�
	}else if
		(JikiY + halfsizeofspaceship < touchy){
		 float distance4 =touchy - JikiY + halfsizeofspaceship;
			JikiY = JikiY + distance4 / 10;
	}
	*/

////////////Jiki�e�ړ�����///////////////

	JikiTamaY -= JikiTamaV;
	JikiTamaY4 -= JikiTamaV4;
	JikiTamaY5 -= JikiTamaV5;
	JikiTamaY6 -= JikiTamaV6;

	//��ʂ̊O�ɏo����e�������B5�͒e�̃T�C�Y
	//�ʂ�Y���W�̉�ʊO�ɂł���Ajiki����X���W��Y���W���擾���āA��������ł��o���܂�
	if((JikiTamaY > viewh || JikiTamaY < -5) || JikiTamaflag == false){
		JikiTamaX = JikiX+23;
		JikiTamaY = JikiY-4;
		JikiTamaflag=true;
	}
	if((JikiTamaY4 > viewh || JikiTamaY4 < -5) ){
		JikiTamaX4 = JikiX+23;
		JikiTamaY4 = JikiY-4;
	}
	if((JikiTamaY5 > viewh || JikiTamaY5 < -5) ){
		JikiTamaX5 = JikiX+23;
		JikiTamaY5 = JikiY-4;
	}
	if((JikiTamaY6 > viewh || JikiTamaY6 < -5) ){
		JikiTamaX6 = JikiX+23;
		JikiTamaY6 = JikiY-4;
	}

	//powerupcount�ɂ���āA�W�L�̒e�𑝂₷//
	//tama2
	if(powerupcount>=1){
		JikiTamaX2-=JikiTamaV2;
		JikiTamaY2-=JikiTamaV2;
	}
	if(JikiTamaX2<=0 && JikiTamaY2<=0){
		JikiTamaX2=JikiX;
		JikiTamaY2=JikiY-4;
	}
	//tama3
	if(powerupcount>=2){
		JikiTamaX3+=JikiTamaV3;
		JikiTamaY3-=JikiTamaV3;
	}
	if(JikiTamaX3>=vieww && JikiTamaY3<=0){
		JikiTamaX3=JikiX+46;
		JikiTamaY3=JikiY-4;
	}


////////////�{�X�G�ړ�����///////////////

	if(Tmove){

	//�U�R���ʂ肷����̂�҂�
	//���Ȃ݂ɂ��̃t���O�̓������\�b�h�̈�ԏ�Ŕ��肵�Ă��܂�
	if(zakocountflag){

	//�{�X�̍��W���w�肵�Ă��܂�
	BossX = BossX + Bossvx;
	BossY = BossY + Bossvy;

	if(BossX > vieww - halfsizeofenemy || BossX < -halfsizeofenemy){
		Bossvx = -Bossvx;
	}
	if(BossY > viewh - halfsizeofspaceship * 6 || BossY < -halfsizeofenemy){
		Bossvy = -Bossvy;
	}
	}//Tmove��


////////////�{�X�G�e�ړ�����///////////////

	if(Tmove){

		bty = bty + btvy;

	if(bty>viewh || bty<0 || TekiTamaflag==false){
		bty=BossY+10;
		btx=BossX+20;
		TekiTamaflag=true;
	}
	if(btx>vieww || btx<0 || TekiTamaflag==false){
		btx=BossX+20;
		bty=BossY+10;
		TekiTamaflag=true;
	}


	}//Tmove��




////�{�XHP�����ɔ����Ēe���x�t��////

	if(BossHP<=150){
		//btvy�Ƃ͒e�̑����ł�
		 btvy = 40;

		 //bosstxyflag�Ƃ͏\���e�Ǝ΂ߏ\���e�����݂ɑłׂ̃t���O�ł�
		 //�������ꂪtrue�̂Ƃ��͂��̏��������܂�
		 //true�̎��͎΂߂ɑł���܂�
		 if(Bossxyflag){
		 bosstamax1 = bosstamax1 + 20; //�E
		 bosstamay2 = bosstamay2 + 20; //��
		 bosstamax3 = bosstamax3 - 20; //��
		 bosstamay4 = bosstamay4 - 20; //��
		 }
		 //�����̏����̓t���O�ɂ͍��E���ꂸ��{�I�ɕς��Ȃ�
		 //���̏��������̎��́A�\���e���ł���܂�
		 bosstamay1 = bosstamay1 - 20;
		 bosstamax2 = bosstamax2 + 20;
		 bosstamay3 = bosstamay3 + 20;
		 bosstamax4 = bosstamax4 - 20;


		 //�����͏\���e�̎������̏����i�΂ߏ\���e�Ƃ͈ꏏ�ɏ����ł��Ȃ����߁j
		 //���ׂĂ̒e����ʊO�ɂł��������x���W�����Z�b�g���܂�
		 if(Bossxyflag == false){
		 if((bosstamay1 < 0)&&
		 (bosstamax2 > vieww)&&
		 (bosstamay3 > viewh)&&
		 (bosstamax4 < 0)
		 || TekiTamaflag == false){
			 bosstamax1 = BossX+32;
			 bosstamax2 = BossX+32;
			 bosstamax3 = BossX+32;
			 bosstamax4 = BossX+32;

			 bosstamay1 = BossY+47;
			 bosstamay2 = BossY+47;
			 bosstamay3 = BossY+47;
			 bosstamay4 = BossY+47;

			 //�����Ńt���O��؂�ւ��锻��̕ϐ���1�������܂�
			 bosstamacount++;

			 //���̎��́Abosstamacount��2�Ŋ����Ă��܂肪0��������
			 //Bossxyflag��true�������Ƃ��������ł�
			 //�܂�bosstamacount�������̎���true�Ŋ�̎���False�ɂȂ�܂�
			 if(bosstamacount % 2 ==0){
			 Bossxyflag = true;
			 }
			 else if(bosstamacount % 2 == 1){
			 Bossxyflag = false;
			 }
		 }
		 }
		 //�΂ߏ\���e�̏����ł�
		 //�S���̒e����ʊO����o���������x���W�����Z�b�g���܂�
		 if(Bossxyflag){
		 if((bosstamax1 > vieww && bosstamay1 < 0)&&
		 (bosstamax2 > vieww && bosstamay2 > viewh)&&
		 (bosstamax3 < 0 && bosstamay3 > viewh)&&
		 (bosstamax4 < 0 && bosstamay4 < 0)
		 || TekiTamaflag == false){
			 bosstamax1 = BossX+32;
			 bosstamax2 = BossX+32;
			 bosstamax3 = BossX+32;
			 bosstamax4 = BossX+32;

			 bosstamay1 = BossY+47;
			 bosstamay2 = BossY+47;
			 bosstamay3 = BossY+47;
			 bosstamay4 = BossY+47;

			 //��������̏����𓯂��ł�
			 bosstamacount++;
			 if(bosstamacount % 2 ==0){
			 Bossxyflag = true;
			 }
			 else if(bosstamacount % 2 == 1){
			 Bossxyflag = false;
			 }
		 }
		 }
	}

////////////�{�X�G�����蔻��///////////////


	//���ׂĂ̒e�ɓ������Ă��Ȃ��������Ŕ��肵�Ă��܂�
	if((JikiTamaX>BossX && JikiTamaX<BossX+50) && (JikiTamaY>BossY && JikiTamaY<BossY+90)){
		patoricAtariflag=true;
		BossHP--;
		JikiTamaflag=false;
	}
	if((JikiTamaX2>BossX && JikiTamaX2<BossX+50) && (JikiTamaY2>BossY && JikiTamaY2<BossY+90)){
		patoricAtariflag=true;
		BossHP--;
		JikiTamaX2=JikiX;
		JikiTamaY2=JikiY-4;
	}
	if((JikiTamaX3>BossX && JikiTamaX3<BossX+50) && (JikiTamaY3>BossY && JikiTamaY3<BossY+90)){
		patoricAtariflag=true;
		BossHP--;
		JikiTamaX3=JikiX+46;
		JikiTamaY3=JikiY-4;
	}
	if((JikiTamaX4>BossX && JikiTamaX4<BossX+50) && (JikiTamaY4>BossY && JikiTamaY4<BossY+90)){
		patoricAtariflag=true;
		BossHP--;
		JikiTamaX4=JikiX+23;
		JikiTamaY4=JikiY-4;
	}
	if((JikiTamaX5>BossX && JikiTamaX5<BossX+50) && (JikiTamaY5>BossY && JikiTamaY5<BossY+90)){
		patoricAtariflag=true;
		BossHP--;
		JikiTamaX5=JikiX+23;
		JikiTamaY5=JikiY-4;
	}
	if((JikiTamaX6>BossX && JikiTamaX6<BossX+50) && (JikiTamaY6>BossY && JikiTamaY6<BossY+90)){
		patoricAtariflag=true;
		BossHP--;
		JikiTamaX6=JikiX+23;
		JikiTamaY6=JikiY-4;
	}



////////////�{�X�̏o�����e�̓����蔻��///////////////

	if((btx>JikiX && btx<JikiX+40)&&(bty>JikiY && bty<JikiY+40)
			|| (bosstamax1 > JikiX && bosstamax1 < JikiX+40)
			&& (bosstamay1 > JikiY && bosstamay1 <JikiY+40)
			|| (bosstamax2 > JikiX && bosstamax2 < JikiX+40)
			&& (bosstamay2 > JikiY && bosstamay2 <JikiY+40)
			|| (bosstamax3 > JikiX && bosstamax3 < JikiX+40)
			&& (bosstamay3 > JikiY && bosstamay3 <JikiY+40)
			|| (bosstamax4 > JikiX && bosstamax4 < JikiX+40)
			&& (bosstamay4 > JikiY && bosstamay4 <JikiY+40))
		{
		//�e�̂ǂꂩ�ɂ���������HP����10�������܂�
			JikiHP -= 10;
		//�U�����܂�
			Activity1.vibrator.vibrate(16*3);
			//�p���[�A�b�v�|�C���g�����炵�܂�
			if(powerupcount>=0){
				powerupcount--;
			}
			TekiTamaflag=false;
		}
		else{
			TekiTamaflag=true;
		}


		}


////////////�U�R�ړ�����///////////////
if(Tmove){


	Zy+=Zv;
	//��ʊO�ɏo����G�̈ʒu�����Z�b�g���܂�
	if(Zy>=viewh || zakoflag==false){
		Zy=0;
		//�����_���ɓG���o�������܂�
		Zx=(float)Math.floor(Math.random()*vieww-40);
		zakoflag=true;
		//�U�R���ʂ�߂�����A�|���ꂽ�����J�E���g���܂�
		zakocount++;
	}


////////////�U�R�����蔻��///////////////


	//���ׂĂ̒e�ɓ������Ă��Ȃ��������Ŕ��肵�Ă��܂�
	if((JikiTamaX>Zx && JikiTamaX<Zx+74) && (JikiTamaY>Zy && JikiTamaY<Zy+74)){
		zakoflag=false;
		JikiTamaflag=false;
		score+=4;
	}
	if((JikiTamaX2>Zx && JikiTamaX2<Zx+74) && (JikiTamaY2>Zy && JikiTamaY2<Zy+74)){
		zakoflag=false;
		score+=4;
		JikiTamaX2=JikiX;
		JikiTamaY2=JikiY-4;
	}
	if((JikiTamaX3>Zx && JikiTamaX3<Zx+74) && (JikiTamaY3>Zy && JikiTamaY3<Zy+74)){
		zakoflag=false;
		score+=4;
		JikiTamaX3=JikiX+46;
		JikiTamaY3=JikiY-4;
	}
	if((JikiTamaX4>Zx && JikiTamaX4<Zx+74) && (JikiTamaY4>Zy && JikiTamaY4<Zy+74)){
		zakoflag=false;
		score+=4;
		JikiTamaX4=JikiX+23;
		JikiTamaY4=JikiY-4;
	}
	if((JikiTamaX5>Zx && JikiTamaX5<Zx+74) && (JikiTamaY5>Zy && JikiTamaY5<Zy+74)){
		zakoflag=false;
		score+=4;
		JikiTamaX5=JikiX+23;
		JikiTamaY5=JikiY-4;
	}
	if((JikiTamaX6>Zx && JikiTamaX6<Zx+74) && (JikiTamaY6>Zy && JikiTamaY6<Zy+74)){
		zakoflag=false;
		score+=4;
		JikiTamaX6=JikiX+23;
		JikiTamaY6=JikiY-4;
	}



////////////�U�R���̂̓����蔻��///////////////

	if((Zx>JikiX && Zx<JikiX+40)
			&& (Zy>JikiY && Zy<JikiY+50) ){
		//�U�R�����@�ɂԂ�������AHP��10�����܂�
		JikiHP -= 10;
		//�U�����܂�
		Activity1.vibrator.vibrate(16*3);
		zakoflag=false;
		JikiTamaflag=false;
		Activity1.vibrator.vibrate(16*3);

	}

////////////�U�R01�ړ�����//////////////


	Zy1+=Zv1;
	if(Zy1>=viewh || zakoflag1==false){
		Zy1=0;
		Zx1=(float)Math.floor(Math.random()*vieww-40);
		zakoflag1=true;
		zakocount++;
	}


////////////�U�R01�����蔻��///////////////


	if((JikiTamaX>Zx1 && JikiTamaX<Zx1+74) && (JikiTamaY>Zy1 && JikiTamaY<Zy1+74)){
		zakoflag1=false;
		JikiTamaflag=false;
		score+=4;

	}
	if((JikiTamaX2>Zx1 && JikiTamaX2<Zx1+74) && (JikiTamaY2>Zy1 && JikiTamaY2<Zy1+74)){
		zakoflag1=false;
		score+=4;
		JikiTamaX2=JikiX;
		JikiTamaY2=JikiY-4;

	}
	if((JikiTamaX3>Zx1 && JikiTamaX3<Zx1+74) && (JikiTamaY3>Zy1 && JikiTamaY3<Zy1+74)){
		zakoflag1=false;
		score+=4;
		JikiTamaX3=JikiX+46;
		JikiTamaY3=JikiY-4;

	}
	if((JikiTamaX4>Zx1 && JikiTamaX4<Zx1+74) && (JikiTamaY4>Zy1 && JikiTamaY4<Zy1+74)){
		zakoflag1=false;
		score+=4;
		JikiTamaX4=JikiX+23;
		JikiTamaY4=JikiY-4;

	}
	if((JikiTamaX5>Zx1 && JikiTamaX5<Zx1+74) && (JikiTamaY5>Zy1 && JikiTamaY5<Zy1+74)){
		zakoflag1=false;
		score+=4;
		JikiTamaX5=JikiX+23;
		JikiTamaY5=JikiY-4;

	}
	if((JikiTamaX6>Zx1 && JikiTamaX6<Zx1+74) && (JikiTamaY6>Zy1 && JikiTamaY6<Zy1+74)){
		zakoflag1=false;
		score+=4;
		JikiTamaX6=JikiX+23;
		JikiTamaY6=JikiY-4;

	}


////////////�U�R01���̂̓����蔻��///////////////

	if((Zx1>JikiX && Zx1<JikiX+40)
			&& (Zy1>JikiY && Zy1<JikiY+50) ){
		JikiHP -= 10;
		Activity1.vibrator.vibrate(16*3);
		zakoflag1=false;
		JikiTamaflag=false;
		Activity1.vibrator.vibrate(16*3);

	}


////////////�U�R02�ړ�����//////////////

	//�����̓G�́A�΂߂ɓ����悤�ɂȂ��Ă��܂�
	//�Ȃ̂�Y���ɂ��ϐ���������Ă��܂�

	Zy2 = Zy2 + Zyv2;
	Zx2 = Zx2 + Zxv2;

	//��ʒ[�܂ōs������A�܂����Α��̉�ʒ[����o�Ă���
	if(Zx2 > vieww){
		Zx2 = 0;
	}
	if(Zy2>=viewh || zakoflag2==false ){
		Zy2=0;
		Zx2=(float)Math.floor(Math.random()*vieww-40);
		zakoflag2=true;
		zakocount++;
	}


////////////�U�R02�����蔻��///////////////


	if((JikiTamaX>Zx2 && JikiTamaX<Zx2+74) && (JikiTamaY>Zy2 && JikiTamaY<Zy2+74)){
		zakoflag=false;
		JikiTamaflag2=false;
		score+=4;
		PUflag=true;

	}
	if((JikiTamaX2>Zx2 && JikiTamaX2<Zx2+74) && (JikiTamaY2>Zy2 && JikiTamaY2<Zy2+74)){
		zakoflag2=false;
		score+=4;
		JikiTamaX2=JikiX;
		JikiTamaY2=JikiY-4;
		PUflag=true;

	}
	if((JikiTamaX3>Zx2 && JikiTamaX3<Zx2+74) && (JikiTamaY3>Zy2 && JikiTamaY3<Zy2+74)){
		zakoflag2=false;
		score+=4;
		JikiTamaX3=JikiX+46;
		JikiTamaY3=JikiY-4;
		PUflag=true;

	}
	if((JikiTamaX4>Zx2 && JikiTamaX4<Zx2+74) && (JikiTamaY4>Zy2 && JikiTamaY4<Zy2+74)){
		zakoflag2=false;
		score+=4;
		JikiTamaX4=JikiX+23;
		JikiTamaY4=JikiY-4;
		PUflag=true;

	}
	if((JikiTamaX5>Zx2 && JikiTamaX5<Zx2+74) && (JikiTamaY5>Zy2 && JikiTamaY5<Zy2+74)){
		zakoflag2=false;
		score+=4;
		JikiTamaX5=JikiX+23;
		JikiTamaY5=JikiY-4;
		PUflag=true;

	}
	if((JikiTamaX6>Zx2 && JikiTamaX6<Zx2+74) && (JikiTamaY6>Zy2 && JikiTamaY6<Zy2+74)){
		zakoflag2=false;
		score+=4;
		JikiTamaX6=JikiX+23;
		JikiTamaY6=JikiY-4;
		PUflag=true;

	}


////////////�U�R02���̂̓����蔻��///////////////

	if((Zx2>JikiX && Zx2<JikiX+40)
			&& (Zy2>JikiY && Zy2<JikiY+50) ){
		JikiHP -= 10;
		Activity1.vibrator.vibrate(16*3);
		zakoflag2=false;
		JikiTamaflag=false;
		Activity1.vibrator.vibrate(16*3);

		}



}//Tmove







//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////�p���[�A�b�v///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

	//����score�ɒB���鎖�ɂ���āA�A�C�e���o��
	//screddiv�܂�score����������A�A�C�e���o��
	//���̂Ƃ���A40��������
	if(score == scorediv){
	PUflag=true;
	scorediv+=40;
	}
		//�ړ�
		if(PUflag==true){
			PUy+=PUv;
		}
		if(PUy>=viewh || PUflag==false){
			PUy=-50;
			PUx=(float)Math.floor(Math.random()*vieww);
			if(PUx>=vieww-40){
				PUx=vieww-40;
			}
			PUflag=false;
		}

	//�W�L�Ƃ̓����蔻��
		//72�́A�W�L�̉��T�C�Y
		if((PUx>JikiX && PUx<JikiX+72)
				&& (PUy>JikiY && PUy<JikiY+72) ){
			JikiHP += 30;
			if(JikiHP>=280){
				JikiHP=280;
			}
			//���ʉ�sp���Đ�
			sp.play(Activity1.mSounds[0], 1.0f, 1.0f, 0, 0, 1.0f);
			//Y������
			PUy=-50;
			PUx=(float)Math.floor(Math.random()*vieww-40);
			//�A�C�e�������ƁA�W�L�̒e�������Ȃ�܂�
			JikiTamaV+=5;
			powerupcount+=2;
			PUflag=false;

		}

	}












//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////stage1����///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

	//�X�e�[�W1��I�������stage1��true��������āA�����������܂�
	if(stage1){

		if(vieww-BossHP>vieww-35 && normal1){
			gamestart=false;
			Activity1.mp.stop();

			flash=true;
			BossHP=280;
			stage1power=true;
			normal1=false;

		}



	}



//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////stage2����///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

	//�X�e�[�W2��I�������stage2��true��������āA�����������܂�
	if(stage2){

		if(vieww-BossHP>vieww-35 && normal2){
			gamestart=false;


			flash=true;
			BossHP=280;
			stage2power=true;
			normal2=false;

		}



	}





// �`��̂��������
Canvas canvas = holder.lockCanvas(); // ���b�N��������
drawOnCanvas(canvas);
holder.unlockCanvasAndPost(canvas); // ���b�N������
}

}
//kaiwa3�t���O�J�b�R��
}












////////////�`�惁�\�b�h///////////////
public void drawOnCanvas(Canvas canvas){






//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////�w�i�𐶐�///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////



	//�����w�i
	Activity1.bgimage = Bitmap.createScaledBitmap(Activity1.bgimage, vieww, viewh, true);
	canvas.drawBitmap(Activity1.bgimage,0, 0, null);


	//�X�e�[�W�P�w�i
	if(stage1){
//�w�i���A��ʃT�C�Y�ɍ��킹��
Activity1.bgimage = Bitmap.createScaledBitmap(Activity1.bgimage, vieww, viewh, true);
//�w�i�`��
canvas.drawBitmap(Activity1.bgimage,0, 0, null);
	}

	//�X�e�[�W�Q�w�i
	if(stage2){
		//�w�i���A��ʃT�C�Y�ɍ��킹��
		Activity1.bgimage2 = Bitmap.createScaledBitmap(Activity1.bgimage2, vieww, viewh, true);
		//�w�i�`��
		canvas.drawBitmap(Activity1.bgimage2,0, 0, null);
			}


/////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////
///////////////////////////////////////////
////////////�L�����N�^�𐶐�///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////



if(gamestart){

canvas.drawBitmap(Activity1.jikiBitmap,JikiX,JikiY,null);

//���܂����˂̃{�X�@�G���G���ʂ�߂���̂�҂�
if((zakocountflag && normal1) ){
canvas.drawBitmap(Activity1.bossBitmap,BossX,BossY,null);
canvas.drawBitmap(Activity1.agauge,vieww-290,0,null);
}

if((zakocountflag && normal1) || stage1power && Tmove){
	canvas.drawBitmap(Activity1.tekitamaBitmap,btx,bty,null);
	}

if(stage1power){
	canvas.drawBitmap(Activity1.lastboss,BossX,BossY,null);
	canvas.drawBitmap(Activity1.agauge,vieww-290,0,null);
}


//���܂����˂̃{�X�@�G���G���ʂ�߂���̂�҂�
if(zakocountflag && normal2){
canvas.drawBitmap(Activity1.bossBitmap,BossX,BossY,null);
canvas.drawBitmap(Activity1.tekitamaBitmap,btx,bty,null);
canvas.drawBitmap(Activity1.agauge,vieww-290,0,null);
}


if(stage1power && Tmove){
	canvas.drawBitmap(Activity1.sdapple,Zx,Zy,null);
	canvas.drawBitmap(Activity1.sdapple,Zx1,Zy1,null);
	canvas.drawBitmap(Activity1.sdapple,Zx2,Zy2,null);
}


if(normal1 || normal2 || stage2power && Tmove){
canvas.drawBitmap(Activity1.zakoteki,Zx,Zy,null);
canvas.drawBitmap(Activity1.zakoteki,Zx1,Zy1,null);
canvas.drawBitmap(Activity1.zakoteki,Zx2,Zy2,null);
}


if(stage2power){
	canvas.drawBitmap(Activity1.dekaapple,BossX,BossY,null);
	canvas.drawBitmap(Activity1.agauge,vieww-290,0,null);
}

if(stage2power && Tmove){
	canvas.drawBitmap(Activity1.tekitamaBitmap,btx,bty,null);
}




if(BossHP <= 150 && Tmove ){
	canvas.drawBitmap(Activity1.tekitamaBitmap,bosstamax1,bosstamay1,null);
	canvas.drawBitmap(Activity1.tekitamaBitmap,bosstamax2,bosstamay2,null);
	canvas.drawBitmap(Activity1.tekitamaBitmap,bosstamax3,bosstamay3,null);
	canvas.drawBitmap(Activity1.tekitamaBitmap,bosstamax4,bosstamay4,null);
}


if(Tmove){
//�����ɕ����\�������悤�I
canvas.drawBitmap(Activity1.tamaBitmap,JikiTamaX,JikiTamaY,null);
canvas.drawBitmap(Activity1.tamaBitmap,JikiTamaX4,JikiTamaY4,null);
canvas.drawBitmap(Activity1.tamaBitmap,JikiTamaX5,JikiTamaY5,null);
canvas.drawBitmap(Activity1.tamaBitmap,JikiTamaX6,JikiTamaY6,null);

if(powerupcount>=1){
canvas.drawBitmap(Activity1.tamaBitmap,JikiTamaX2,JikiTamaY2,null);
}
if(powerupcount>=2){
canvas.drawBitmap(Activity1.tamaBitmap,JikiTamaX3,JikiTamaY3,null);
}

}//Tmove

canvas.drawBitmap(Activity1.powerup,PUx,PUy,null);

canvas.drawBitmap(Activity1.dgauge,0,viewh-37,null);





////////////���y����///////////////

sp = Activity1.mSoundPool;



////////////�G�E�W�L���C�t///////////////

//���C�t��`��
paintlife2=new Paint();
paintlife = new Paint();
paintlife.setStyle(Style.FILL);
paintlife.setARGB(100, 255, 0, 0);
paintlife2.setStyle(Style.FILL);
paintlife2.setARGB(100, 0, 255, 0);
//�G�̃{�X�̃��C�t���ŏ�����\������Ă�ςȂ̂ŏo�Ă��Ă���o���܂�
if(zakocountflag == true){
canvas.drawRect(vieww-BossHP,8,vieww-35,28,paintlife);
}
canvas.drawRect(39,viewh-26,JikiHP,viewh-6,paintlife2);



////////////�X�R�A///////////////


Paint Score = new Paint();
Score.setARGB(255,255,150,100);
Score.setTextSize(20);
canvas.drawText("score:", vieww-50,50, Score);
//������String�^�ɕϊ�
canvas.drawText(String.valueOf(score), vieww-50,70, Score);





































////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////�ȉ��A�����ȉ�ʕψ�/////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////




///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////GAMEOVER////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

if(JikiHP<=0){

	//�������A��ʃT�C�Y�ɍ��킹��
	Activity1.gameover = Bitmap.createScaledBitmap(Activity1.gameover, vieww, 61, true);
	canvas.drawBitmap(Activity1.gameover,0, viewh/2, null);


	Activity1.mp.stop();
	Activity1.mp5.stop();
	isThreadrunning = false;
}


//if(gamestart�̕��J�b�R
}


///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////���ɃV�e�l���////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

if(yokogamen){



	//�w�i���A��ʃT�C�Y�ɍ��킹��
	Activity1.yoko = Bitmap.createScaledBitmap(Activity1.yoko, vieww, viewh, true);
	canvas.drawBitmap(Activity1.yoko,0, 0, null);

	//�����蔻��́A���Ȃ�A�o�E�g!!
	//�{�^���̓����蔻��///
	if((touchx > vieww/3*2 && touchx < vieww) && (touchy > viewh/3*2 && touchy < viewh )){

		Activity1.mp3.start();
		Activity1.vibrator.vibrate(16*3);

		// ���Ԃ̂����鏈���������ɋL�q
		 try{
		Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
		} catch (InterruptedException ie){}



		touchx = 0;
		touchy = 0;

		yokogamen=false;
		kaiwa01=true;
		kaiwa=true;

	}



}
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////��b��ʐݒ�////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////


if(kaiwa){
	Paint skipbutton = new Paint();
	skipbutton.setTextSize(20);
	skipbutton.setARGB(255,255,255,255);



	canvas.drawText("SKIP",vieww/2-30,80,skipbutton);


	if((vieww/2-40 < touchx && vieww/2+50 > touchx)
		&& (80 < touchy && 120 > touchy)){
		kaiwa01 = false;
		kaiwa02 = false;
		kaiwa03 = false;
		kaiwa04 = false;
		kaiwa05 = false;
		kaiwa06 = false;
		kaiwa07 = false;
		kaiwa08 = false;
		kaiwa =  false;
		Activity1.mp4.stop();

		touchx = 0;
		touchy = 0;

		stageselect = true;
	}



if(kaiwa01){
	Activity1.mp4.start();

	Paint ui = new Paint();
	ui.setARGB(255,colR,colG,colB);
	if(colB>0 && colG>0){
	colB-=3;
	colG-=3;
	}
	Paint kaiwabun = new Paint();
	Paint kaiwabutton = new Paint();
	Paint kaiwawindow = new Paint();


	ui.setAntiAlias(true);
	ui.setStyle(Paint.Style.FILL_AND_STROKE);
	Path path = new Path();

	path.moveTo(vieww-80,viewh-140);
	path.lineTo(vieww-10,viewh-105);
	path.lineTo(vieww-80,viewh-70);
	path.lineTo(vieww-80,viewh-140);







	kaiwabun.setARGB(255,255,255,255);
	kaiwabun.setTextSize(25);
	kaiwabutton.setARGB(255,255,255,255);
	kaiwawindow.setARGB(100,255,0,0);


	canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
	canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
	canvas.drawText("�悭������E�E�E�E",10,viewh-100,kaiwabun);
	canvas.drawText("�A���^���h���C�h��!!",10,viewh-50,kaiwabun);
	canvas.drawPath(path, ui);



	if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

		Activity1.vibrator.vibrate(16*3);


	kaiwa01 = false;

	// ���Ԃ̂����鏈���������ɋL�q
	 try{
	Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
	} catch (InterruptedException ie){}


	touchx = 0;
	touchy = 0;




	//////kawai��true�ɂȂ�Ǝ��̉�b���\������܂�///
	kaiwa02 = true;
	}
}

if(kaiwa02){

	Paint ui = new Paint();
	ui.setARGB(255,colR2,colG2,colB2);
	if(colB2>0 && colR2>0){
	colB2-=3;
	colR2-=3;
	}

	/////////���ꕨ�����܂�////////////
	canvas.drawBitmap(Activity1.titledroid,-150,viewh-450,null);
	Paint kaiwabun02 = new Paint();
	Paint kaiwabutton02 = new Paint();
	Paint kaiwawindow02 = new Paint();

	ui.setAntiAlias(true);
	ui.setStyle(Paint.Style.FILL_AND_STROKE);
	Path path = new Path();

	path.moveTo(vieww-80,viewh-140);
	path.lineTo(vieww-10,viewh-105);
	path.lineTo(vieww-80,viewh-70);
	path.lineTo(vieww-80,viewh-140);


	////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
	kaiwabun02.setARGB(255,255,255,255);
	kaiwabun02.setTextSize(25);
	kaiwabutton02.setARGB(255,255,255,255);
	kaiwawindow02.setARGB(100,0,0,255);

	////////�����G�A���A�E�B���h��\�����܂�/////////////
	canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow02);
	canvas.drawText("�����A�A�b�v���̎s��x�z��",10,viewh-100,kaiwabun02);
	canvas.drawText("�~�߂邽�߂ɂ���Ă���",10,viewh-50,kaiwabun02);
	canvas.drawPath(path, ui);

	//�{�^���̓����蔻��///
	if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

		Activity1.vibrator.vibrate(16*3);

		// ���Ԃ̂����鏈���������ɋL�q
		 try{
		Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
		} catch (InterruptedException ie){}

		///////������touchx��touchy�������ɂ�������Ǝ��̏����ň�u�ŏI������̂ō��W���������炵�܂�
		///////���肩��x��y��ǂ��o��
		touchx = 0;
		touchy = 0;

	//////kaiwa02��False�ɂȂ�Ƃ��̕��������܂�
	kaiwa02 = false;

	kaiwa03 = true;

	}
}

	if(kaiwa03){

		Paint ui = new Paint();
		ui.setARGB(255,colR3,colG3,colB3);
		if(colB3>0 && colG3>0){
		colB3-=3;
		colG3-=3;
		}


		/////////���ꕨ�����܂�////////////
		Paint kaiwabun = new Paint();
		Paint kaiwabutton = new Paint();
		Paint kaiwawindow = new Paint();


		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("�A���^���ז����Ă��ꂽ�����ŁA",10,viewh-100,kaiwabun);
		canvas.drawText("�S�Ė��ʂɂȂ������������Ȃ��!!",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);

		//�{�^���̓����蔻��///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

		///////kaiwa01��False�ɂȂ�Ƃ��̕��������܂�//////
		kaiwa03 = false;


		///////������touchx��touchy�������ɂ�������Ǝ��̏����ň�u�ŏI������̂ō��W���������炵�܂�
		///////���肩��x��y��ǂ��o��
		touchx = 0;
		touchy = 0;

	//////kawai��true�ɂȂ�Ǝ��̉�b���\������܂�///
		kaiwa04 = true;



		}
	}

	if(kaiwa04){

		Paint ui = new Paint();
		ui.setARGB(255,colR4,colG4,colB4);
		if(colB4>0 && colR4>0){
		colB4-=3;
		colR4-=3;
		}

		/////////���ꕨ�����܂�////////////
		canvas.drawBitmap(Activity1.titledroid,-150,viewh-450,null);
		Paint kaiwabun02 = new Paint();
		Paint kaiwabutton02 = new Paint();
		Paint kaiwawindow02 = new Paint();


		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun02.setARGB(255,255,255,255);
		kaiwabun02.setTextSize(25);
		kaiwabutton02.setARGB(255,255,255,255);
		kaiwawindow02.setARGB(100,0,0,255);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow02);
		canvas.drawText("����ȏ�A�s����x�z����Ȃ�",10,viewh-100,kaiwabun02);
		canvas.drawText("�l�͌N���~�߂Ȃ����Ⴂ���Ȃ��I",10,viewh-50,kaiwabun02);
		canvas.drawPath(path, ui);

		//�{�^���̓����蔻��///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}


			///////������touchx��touchy�������ɂ�������Ǝ��̏����ň�u�ŏI������̂ō��W���������炵�܂�
			///////���肩��x��y��ǂ��o��
			touchx = 0;
			touchy = 0;

		//////kaiwa02��False�ɂȂ�Ƃ��̕��������܂�
		kaiwa04 = false;
		kaiwa05=true;


		}
	}


	if(kaiwa05){

		Paint ui = new Paint();
		ui.setARGB(255,colR5,colG5,colB5);
		if(colB5>0 && colG5>0){
		colB5-=3;
		colG5-=3;
		}


		/////////���ꕨ�����܂�////////////
		Paint kaiwabun = new Paint();
		Paint kaiwabutton = new Paint();
		Paint kaiwawindow = new Paint();

		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("���痊�������A�ł��A���^�@����",10,viewh-100,kaiwabun);
		canvas.drawText("�~�߂鎖���o����̂�����H",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);

		//�{�^���̓����蔻��///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

		///////kaiwa01��False�ɂȂ�Ƃ��̕��������܂�//////
		kaiwa05 = false;



		touchx = 0;
		touchy = 0;


		kaiwa06 = true;



		}
	}


	if(kaiwa06){

		Paint ui = new Paint();
		ui.setARGB(255,colR6,colG6,colB6);
		if(colB6>0 && colR6>0){
		colB6-=3;
		colR6-=3;
		}

		/////////���ꕨ�����܂�////////////
		canvas.drawBitmap(Activity1.titledroid,-150,viewh-450,null);
		Paint kaiwabun02 = new Paint();
		Paint kaiwabutton02 = new Paint();
		Paint kaiwawindow02 = new Paint();

		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun02.setARGB(255,255,255,255);
		kaiwabun02.setTextSize(25);
		kaiwabutton02.setARGB(255,255,255,255);
		kaiwawindow02.setARGB(100,0,0,255);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow02);
		canvas.drawText("�l�͕������Ȃ���!!",10,viewh-100,kaiwabun02);
		canvas.drawText("�X�}�[�g�t�H���s����~�����߂ɁE�E�I",10,viewh-50,kaiwabun02);
		canvas.drawPath(path, ui);

		//�{�^���̓����蔻��///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}


			///////������touchx��touchy�������ɂ�������Ǝ��̏����ň�u�ŏI������̂ō��W���������炵�܂�
			///////���肩��x��y��ǂ��o��
			touchx = 0;
			touchy = 0;

		//////kaiwa02��False�ɂȂ�Ƃ��̕��������܂�
		kaiwa06 = false;
		kaiwa07=true;


		}
	}


	if(kaiwa07){

		Paint ui = new Paint();
		ui.setARGB(255,colR7,colG7,colB7);
		if(colB7>0 && colG7>0){
		colB7-=3;
		colG7-=3;
		}


		/////////���ꕨ�����܂�////////////
		Paint kaiwabun = new Paint();
		Paint kaiwabutton = new Paint();
		Paint kaiwawindow = new Paint();

		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("�E�E�E�!?�A����������",10,viewh-100,kaiwabun);
		canvas.drawText("������ŗV�т͏I�����Ă��Ƃ�",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);
		//�{�^���̓����蔻��///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

		///////kaiwa01��False�ɂȂ�Ƃ��̕��������܂�//////
		kaiwa07 = false;



		touchx = 0;
		touchy = 0;


		kaiwa08 = true;



		}
	}


	if(kaiwa08){

		Paint ui = new Paint();
		ui.setARGB(255,colR8,colG8,colB8);
		if(colB8>0 && colG8>0){
		colB8-=3;
		colG8-=3;
		}


		/////////���ꕨ�����܂�////////////
		Paint kaiwabun = new Paint();
		Paint kaiwabutton = new Paint();
		Paint kaiwawindow = new Paint();

		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(35);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("�v���m�点�Ă��񂾂���!",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);
		//�{�^���̓����蔻��///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

		///////kaiwa01��False�ɂȂ�Ƃ��̕��������܂�//////
		kaiwa08 = false;
		Activity1.mp4.stop();



		touchx = 0;
		touchy = 0;


		stageselect = true;



		}
	}
}//kaiwa��

///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////stageselect���////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

	if(stageselect){

		/////////���ꕨ�����܂�////////////
		Paint kaiwabun02 = new Paint();
		Paint kaiwabutton02 = new Paint();
		Paint kaiwawindow02 = new Paint();

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun02.setARGB(255,255,255,255);
		kaiwabun02.setTextSize(25);
		kaiwabutton02.setARGB(255,255,255,255);
		kaiwawindow02.setARGB(255,0,0,0);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawRect(0,0,vieww,viewh,kaiwawindow02);
		canvas.drawBitmap(Activity1.hardbotton,10,viewh/9,null);
		canvas.drawBitmap(Activity1.nomalbotton,10,viewh/9+130,null);
		canvas.drawText("",vieww/4,50,kaiwabun02);


		//stage1�{�^���̓����蔻��///
		if((touchx > 10 && touchx < 210) && (touchy > viewh/9 && touchy < viewh/9+110  )){

			Activity1.mp2.start();
			Activity1.vibrator.vibrate(16*3);

			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

			touchx = 0;
			touchy = 0;



		stageselect = false;
		stage1=true;
		normal1=true;
		tategamen=true;

		}

		//stage2�{�^���̓����蔻��///
		if((touchx > 10 && touchx < 210) && (touchy > viewh/9+130 && touchy < viewh/9+240 )){

			Activity1.mp2.start();
			Activity1.vibrator.vibrate(16*3);

			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

			touchx = 0;
			touchy = 0;


		stageselect = false;
		stage2=true;
		normal2=true;
		tategamen=true;
		kaiwa=false;

		}
	}

///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////�c�ɃV�e�l���////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

	if(tategamen){

		//�w�i���A��ʃT�C�Y�ɍ��킹��
		Activity1.tate = Bitmap.createScaledBitmap(Activity1.tate, vieww, viewh, true);
		canvas.drawBitmap(Activity1.tate,0, 0, null);

		//�����蔻��́A���Ȃ�A�o�E�g!!
		//�{�^���̓����蔻��///
		if((touchx > vieww/3*2 && touchx < vieww) && (touchy > viewh/3*2 && touchy < viewh )){

			Activity1.mp3.start();
			Activity1.vibrator.vibrate(16*3);//�U��

			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

			touchx = 0;
			touchy = 0;

			tategamen=false;
			gamestart=true;//�Q�[���X�^�[�g!!

		}
	}




	//�퓬��̉�ʕψڂ�������
	//�����A���Ȃ苭���ȕ��@���ƁE�E
	if((vieww-BossHP>vieww-35 && stage1power) || (vieww-BossHP>vieww-35 && stage2power)){
		deleteA=true;
	}

///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////���ɃV�e�l���////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

	if(yokogamen2){

		Activity1.mp6.stop();

		Activity1.mp5.stop();

		//�w�i���A��ʃT�C�Y�ɍ��킹��
		Activity1.yoko = Bitmap.createScaledBitmap(Activity1.yoko, vieww, viewh, true);
		canvas.drawBitmap(Activity1.yoko,0, 0, null);

		//�����蔻��́A���Ȃ�A�o�E�g!!
		//�{�^���̓����蔻��///
		if((touchx > vieww/3*2 && touchx < vieww) && (touchy > viewh/3*2 && touchy < viewh )){

			Activity1.mp3.start();
			Activity1.vibrator.vibrate(16*3);//�U��

			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}

			touchx = 0;
			touchy = 0;

			yokogamen2=false;
			kaiwa09=true;

		}



	}


	if(kaiwa09){

		yokogamen2 = false;
		gamestart=false;

		Paint ui = new Paint();
		ui.setARGB(255,colR9,colG9,colB9);
		if(colB9>0 && colG9>0){
		colB9-=3;
		colG9-=3;
		}

		/////////���ꕨ�����܂�////////////
		Paint kaiwabun = new Paint();
		Paint kaiwabutton = new Paint();
		Paint kaiwawindow = new Paint();


		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		////////��b�̕��̐F��傫����E�B���h�̑傫�������߂܂�///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////�����G�A���A�E�B���h��\�����܂�/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		if(stage1power){
		canvas.drawText("���̉e���g�̏p��",10,viewh-100,kaiwabun);
		canvas.drawText("��Ԃ���Ȃ�āE�E",10,viewh-50,kaiwabun);
		}
		if(stage2power){
			canvas.drawText("�Ȃ�Ă�Ȃ́E�E!!",10,viewh-100,kaiwabun);
			canvas.drawText("���̃A�b�v���}�V�����E�E",10,viewh-50,kaiwabun);
			}
		canvas.drawPath(path, ui);

		//�{�^���̓����蔻��///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);

			// ���Ԃ̂����鏈���������ɋL�q
			 try{
			Thread.sleep(1000); // ����͂킴��3�b�ԃX���[�v
			} catch (InterruptedException ie){}


		///////kaiwa01��False�ɂȂ�Ƃ��̕��������܂�//////

			kaiwa09 = false;

		touchx = 0;
		touchy = 0;


		//////kawai��true�ɂȂ�Ǝ��̉�b���\������܂�///
		kaiwa10 = true;

		}
	}

	if(kaiwa10){

		kaiwa09 = false;

		Paint ui = new Paint();
		ui.setARGB(255,colR10,colG10,colB10);
		if(colB10>0 && colR10>0){
		colB10-=3;
		colR10-=3;
		}

		canvas.drawBitmap(Activity1.titledroid,-150,viewh-450,null);
		Paint kaiwabun02 = new Paint();
		Paint kaiwabutton02 = new Paint();
		Paint kaiwawindow02 = new Paint();

		ui.setAntiAlias(true);
		ui.setStyle(Paint.Style.FILL_AND_STROKE);
		Path path = new Path();

		path.moveTo(vieww-80,viewh-140);
		path.lineTo(vieww-10,viewh-105);
		path.lineTo(vieww-80,viewh-70);
		path.lineTo(vieww-80,viewh-140);

		kaiwabun02.setARGB(255,255,255,255);
		kaiwabun02.setTextSize(25);
		kaiwabutton02.setARGB(255,255,255,255);
		kaiwawindow02.setARGB(100,0,0,255);

		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow02);
		canvas.drawText("�������E�E�������E�E",10,viewh-100,kaiwabun02);
		canvas.drawText("Android�̎��オ�������!!",10,viewh-50,kaiwabun02);
		canvas.drawPath(path, ui);

		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70  )){
			Activity1.vibrator.vibrate(16*3);

			 try{
			Thread.sleep(1000);
			} catch (InterruptedException ie){}

			touchx = 0;
			touchy = 0;

		kaiwa10 = false;
		ending=true;
		}
	}





///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////�G���h���[��////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

	if(ending){
		Paint Dmoji=new Paint();
		Dmoji.setARGB(255, 255, 255, 255);
		Dmoji.setTextSize(100);
		Paint Kmoji=new Paint();
		Kmoji.setARGB(255, 255, 255, 255);
		Kmoji.setTextSize(20);
		Dmoji.setAntiAlias(true);
		Kmoji.setAntiAlias(true);

				//�ufin.�v���ォ��t�F�[�h�C��
				canvas.drawText("fin.",vieww/3,e12+30,Dmoji);
				if(e12<=viewh/2){
					e12+=10;
				}
				//�ufin.�v����ʒ��S�ɂ�����
				if(e12>=viewh/2){
					canvas.drawText("Thank you for playing!!",10,viewh-53,Kmoji);
					canvas.drawText("Please push BACK button",10,viewh-30,Kmoji);
				isThreadrunning = false;
				}

			}

//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////�t���b�V�����ʐݒ�///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////


if(flash){
Paint flash = new Paint();
flash.setAntiAlias(true);
Activity1.mp.stop();
Activity1.mp5.start();

flash.setARGB(fl, 255, 255, 255);
canvas.drawRect(0,0,vieww,viewh,flash);
if(fl>=0){
	fl-=4;//�t���b�V��������鑬�x
}
if(fl<=0){
this.flash=false;
gamestart = true;
}
}




//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////�G���Ŏ�����///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

if(deleteA){

	//Tmove�ŁA��ʏ�̃L�����B���~�߂�
	//�U�R��A�e���\���ɂ����肷��
	Tmove=false;


	Activity1.mp6.start();

	 Paint deleteA  = new Paint();
	 Paint deleteA2  = new Paint();
	 Paint deleteA3 = new Paint();
	 Paint deleteA4  = new Paint();
	 Paint deleteA5  = new Paint();

	 deleteA.setAntiAlias(true);
	 deleteA2.setAntiAlias(true);
	 deleteA3.setAntiAlias(true);
	 deleteA4.setAntiAlias(true);
	 deleteA5.setAntiAlias(true);

	 deleteA.setStyle(Paint.Style.FILL);
	 deleteA2.setStyle(Paint.Style.FILL);
	 deleteA3.setStyle(Paint.Style.FILL);
	 deleteA4.setStyle(Paint.Style.FILL);
	 deleteA5.setStyle(Paint.Style.FILL);

	 // �F�̓I�����W
	 deleteA.setARGB(CirCol1,255,160,0);
	 deleteA2.setARGB(CirCol2,255,160,0);
	 deleteA3.setARGB(CirCol3,255,160,0);
	 deleteA4.setARGB(CirCol4,255,160,0);
	 deleteA5.setARGB(CirCol5,255,160,0);

	 //���W���U�炷�I
     canvas.drawCircle(BossX,BossY, divCircle1, deleteA);
     canvas.drawCircle(BossX+30,BossY, divCircle2, deleteA);
     canvas.drawCircle(BossX,BossY+40, divCircle3, deleteA);
     canvas.drawCircle(BossX+40,BossY+30, divCircle4, deleteA);
     canvas.drawCircle(BossX+50,BossY+70, divCircle5, deleteA);


     //���̑傫���Ȃ�^�C�~���O�E����
     divCircle1+=2;			//1
     if(divCircle1>=40){
    	 Activity1.mp5.stop();//2
    	 divCircle2+=2;
     }
     if(divCircle2>=30){	//3
    	 divCircle3+=2;

     }
     if(divCircle3>=50){	//4
    	 divCircle4+=2;
     }
     if(divCircle4>=50){	//5
    	 divCircle5+=10;
     }


     //�ǂ�ǂ񔖂��Ȃ�Alfa�I
     if(divCircle1>=2){
    	 CirCol1-=5;
     }
     if(divCircle2>=2){
    	 CirCol2-=5;
     }
     if(divCircle3>=2){
    	 CirCol3-=5;
     }
     if(divCircle4>=2){
    	 CirCol4-=5;
     }
     if(divCircle5>=2){
    	 CirCol5-=5;
     }







     //�Ō�́A�f�J�������I��ƁA�J�n
     if(CirCol5==0){

    	 try{
 			Thread.sleep(2000); // ����͂킴��2�b�ԃX���[�v
 			} catch (InterruptedException ie){}

 			touchx=0;touchy=0;
    	 yokogamen2=true;
 		Activity1.mp.stop();
 		gamestart = false;
 		BossHP=280;

 		this.deleteA=false;
     }








}//deleteA��

//�������ɁA������`���񂾁I
		}



public void invalidate() {
	// TODO �����������ꂽ���\�b�h�E�X�^�u

}
}





