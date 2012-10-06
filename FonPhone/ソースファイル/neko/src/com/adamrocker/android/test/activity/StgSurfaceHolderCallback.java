

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
	private float touchx,touchy; // タッチされたx座標
	int vieww, viewh; // SurfaveViewの幅と高さ
	private Paint paintlife, paintlife2;//ライフと被弾時の効果
	private final int halfsizeofspaceship = 46; // 画像のサイズ 72x87
	private final int halfsizeofenemy = 32; // 画像のサイズ 65x9
	private long score=4; //スコア（アイテム発生の関係で初期値は0にできない）



	// 傾きセンサー用の変数
	private float mmPitch;
	private float mmRoll;



	SoundPool sp;//SEの読み込み




	/*jikiの座標*/
	float JikiX=150;
	float JikiY=350;
	/*tamaの座標３つ揃うと、３ＷＡＹ弾*/
	float JikiTamaX=JikiX+23;
	float JikiTamaY=JikiY-4;
	/*tama4の座標3*/
	float JikiTamaX4=JikiX+23;
	float JikiTamaY4=JikiY-4;
	/*tama5の座標3*/
	float JikiTamaX5=JikiX+23;
	float JikiTamaY5=JikiY-4;
	/*tama6の座標3*/
	float JikiTamaX6=JikiX+23;
	float JikiTamaY6=JikiY-4;

	//ここから、ﾊﾟﾜｰｱｯﾌﾟ弾//

	/*tama2の座標パワーアップカウント＞１*/
	float JikiTamaX2=JikiX;
	float JikiTamaY2=JikiY-4;
	/*tama3の座標パワーアップカウント＞２*/
	float JikiTamaX3=JikiX+46;
	float JikiTamaY3=JikiY-4;


	//jikitama速さ
	float JikiTamaV = 40;
	float JikiTamaV2 = 40;
	float JikiTamaV3 = 40;
	float JikiTamaV4 = 20;
	float JikiTamaV5 = 30;
	float JikiTamaV6 = 50;

	int e12;//エンディング（Fin.）の座標


	//ボスの初期座標
	int BossX=150;
	int BossY=30;
	//速さ
	int Bossvx = 5;
	int Bossvy = 5;
	/*ボスのtama1の座標*/
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

	/*ボスのtama1の速度*/
	float btvx=10;
	float btvy=20;



	//sdappleの座標And速度（v）
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






	/*敵/ジキ体力ゲージの体力*/
	int BossHP = 280;
	int JikiHP = 279;

	//ザコの座標And速度（v）
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


	//ザコの反転
	float hanten = -1;


	//パワーアップItem座標・速度
	float PUx=vieww/2;
	float PUy=-50;//一定の条件で出現するオブジェクトは画面外で待機
	float PUv=5;
	float powerupcount;//何回パワーアップしてるかカウント

	//score何点でpawerUpItem発生するか設定する変数
	//long型は、千以上もカウントできる
	long scorediv=40;

	//ザコが何回画面から消えたかをカウントするやつ
	 int zakocount = 0;


	 //色変数,多過ぎきめぇ
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



	 //○の、半径変数 + 円の色変数
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
////////////////フラグ＋フラグ関係変数//////////////////////
////////////////////////////////////////////////////////////

	/*弾フラグの設定*/
	public boolean tflag;
	/*敵ボールフラグの設定*/
	public boolean tekiAtariflag=false;
	public boolean jikiAtariflag=false;
	public boolean 	patoricAtariflag=false;
	public boolean Bosstamaflag=false;
	//Jikiの弾発生フラグ
	public boolean 	JikiTamaflag=true;
	public boolean JikiTamaflag2=false;
	public boolean JikiTamaflag3=false;
	//tekiの弾発生フラグ
	public boolean 	TekiTamaflag=true;
	public boolean Bossxyflag=false;
	//zakoの発生フラグ
	public boolean zakoflag=true;
	public boolean zakoflag1=false;
	public boolean zakoflag2=false;
	public boolean zakocountflag=false;

	//パワーアップItemの発生フラグ
	public boolean PUflag=false;


	//敵パワーアップフラグ
	public boolean normal1=false;
	public boolean stage2power=false;
	public boolean normal2=false;
	public boolean stage1power=false;


	//会話画面フラグ
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



	//画面方向変更依頼フラグ
	public boolean tategamen = false;
	public boolean yokogamen = true;
	public boolean yokogamen2=false;


	//被弾時のflashフラグ
	public boolean flash=false;


	//会話→弾幕の間のスリープフラグ
	public boolean sleep=true;

	//stageフラグ
	public boolean stage1 =false;
	public boolean stage2 =false;



	//敵消滅エフェクトフラグ
	public boolean deleteA=false;

	//エンディングフラグ
	public boolean ending;



	//敵移動フラグ
	//このフラグ一つで物体の動きのON/off制御
	public boolean Tmove=true;


	//STAGE選択画面フラグ
	public boolean stageselect = false;



	//スレッド起動フラグ
	public boolean gamestart = false;


	//パワーアップItemの発生する確率
	float PUpersent;

	// コンストラクタ（受け皿）
	public StgSurfaceHolderCallback(){


	}


//////////////////////////////////////////////////////////////////

	// 傾きを取得
	public void getSensorPosition(float mPitch,float mRoll){
		mmRoll = mRoll;
		mmPitch = mPitch;
	}






// タッチされた位置を取得
public void getTouchPosition(float x,float y){
	touchx = x;
	touchy = y;
}

//////////////////////////////////////////////////////////////////

// コールバック関数
// サーフェイス生成処理(SurfaceHolder.Callbackクラスのメソッドを継承している)
@Override
public void surfaceCreated(SurfaceHolder holder) {
// TODO Auto-generated method stub
// 各種の初期処理。スレッドの開始前に
this.holder = holder;

// スレッドの開始
thread = new Thread(this);
thread.start();


}

//////////////////////////////////////////////////////////////////

// コールバック関数
// サーフェイス変更処理(SurfaceHolder.Callbackクラスのメソッドを継承している)
@Override
public void surfaceChanged(SurfaceHolder holder, int format, int width,
int height) {
// TODO Auto-generated method stub
}

//////////////////////////////////////////////////////////////////

// コールバック関数
// サーフェイス破棄(SurfaceHolder.Callbackクラスのメソッドを継承している)
@Override
public void surfaceDestroyed(SurfaceHolder holder) {
// TODO Auto-generated method stub
// スレッドの終了
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






////////////////////////////////メインループ//////////////////////////////////

@Override
public void run() {
// TODO Auto-generated method stub
// ゲームのメインループ
while (isThreadrunning) {
synchronized (holder) {










////会話が終わるとゲームスタート
	///ちなみにこのif文の　}　←はCanvas canvas = holder.lockCanvas();
	///の前に書かないと会話画面すら表示しないから注意が必要です
	if(gamestart){




		if(sleep){
			 try{
					Thread.sleep(2000); // 今回はわざと2秒間スリープ
					} catch (InterruptedException ie){}
					sleep=false;

		}


		///ザコが五回通り過ぎるか倒されるのを待ちましょう
		///するとボスが現れますよ,こんちきしょう
		if(zakocount > 5){
			zakocountflag = true;
		}

		//ステージ曲再生
		Activity1.mp.start();




////////////Jiki移動処理///////////////

		if(mmPitch<0){//下
			JikiY+=8;
		}
		if(mmPitch>0){//上
			JikiY-=8;
		}
		if(mmRoll>0){//左
			JikiX-=8;
		}
		if(mmRoll<0){//右
			JikiX+=8;
		}





	//画面外へ行かない為に
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
	// 右移動
	if(JikiX + halfsizeofspaceship < touchx){
		float distance1 = touchx - JikiX + halfsizeofspaceship;
		JikiX = JikiX  + distance1 / 10;
	// 左移動
	}else if
		(JikiX + halfsizeofspaceship > touchx){
		 float distance2 = JikiX + halfsizeofspaceship - touchx;
		 JikiX = JikiX - distance2 / 10;
	}
	// 上移動
	if(JikiY + halfsizeofspaceship > touchy){
		 float distance3 =JikiY + halfsizeofspaceship - touchy;
			JikiY = JikiY - distance3 / 10;
	// 下移動
	}else if
		(JikiY + halfsizeofspaceship < touchy){
		 float distance4 =touchy - JikiY + halfsizeofspaceship;
			JikiY = JikiY + distance4 / 10;
	}
	*/

////////////Jiki弾移動処理///////////////

	JikiTamaY -= JikiTamaV;
	JikiTamaY4 -= JikiTamaV4;
	JikiTamaY5 -= JikiTamaV5;
	JikiTamaY6 -= JikiTamaV6;

	//画面の外に出たら弾を消す。5は弾のサイズ
	//玉がY座標の画面外にでたら、jikiからX座標とY座標を取得して、そこから打ち出します
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

	//powerupcountによって、ジキの弾を増やす//
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


////////////ボス敵移動処理///////////////

	if(Tmove){

	//ザコが通りすぎるのを待つ
	//ちなみにこのフラグはランメソッドの一番上で判定しています
	if(zakocountflag){

	//ボスの座標を指定しています
	BossX = BossX + Bossvx;
	BossY = BossY + Bossvy;

	if(BossX > vieww - halfsizeofenemy || BossX < -halfsizeofenemy){
		Bossvx = -Bossvx;
	}
	if(BossY > viewh - halfsizeofspaceship * 6 || BossY < -halfsizeofenemy){
		Bossvy = -Bossvy;
	}
	}//Tmove閉じ


////////////ボス敵弾移動処理///////////////

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


	}//Tmove閉じ




////ボスHP減少に伴って弾速度Ｕｐ////

	if(BossHP<=150){
		//btvyとは弾の速さです
		 btvy = 40;

		 //bosstxyflagとは十字弾と斜め十字弾を交互に打つ為のフラグです
		 //もしこれがtrueのときはこの処理をします
		 //trueの時は斜めに打たれます
		 if(Bossxyflag){
		 bosstamax1 = bosstamax1 + 20; //右
		 bosstamay2 = bosstamay2 + 20; //下
		 bosstamax3 = bosstamax3 - 20; //左
		 bosstamay4 = bosstamay4 - 20; //上
		 }
		 //ここの処理はフラグには左右されず基本的に変わらない
		 //この処理だけの時は、十字弾が打たれます
		 bosstamay1 = bosstamay1 - 20;
		 bosstamax2 = bosstamax2 + 20;
		 bosstamay3 = bosstamay3 + 20;
		 bosstamax4 = bosstamax4 - 20;


		 //ここは十字弾の時だけの処理（斜め十字弾とは一緒に処理できないため）
		 //すべての弾が画面外にでたらもう一度座標をリセットします
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

			 //ここでフラグを切り替える判定の変数に1をたします
			 bosstamacount++;

			 //この式は、bosstamacountを2で割ってあまりが0だったら
			 //Bossxyflagにtrueをいれるという処理です
			 //つまりbosstamacountが偶数の時はtrueで奇数の時はFalseになります
			 if(bosstamacount % 2 ==0){
			 Bossxyflag = true;
			 }
			 else if(bosstamacount % 2 == 1){
			 Bossxyflag = false;
			 }
		 }
		 }
		 //斜め十字弾の処理です
		 //全部の弾が画面外から出たらもう一度座標をリセットします
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

			 //ここも上の処理を同じです
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

////////////ボス敵当たり判定///////////////


	//すべての弾に当たっていないかここで判定しています
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



////////////ボスの出した弾の当たり判定///////////////

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
		//弾のどれかにあたったらHPから10を引きます
			JikiHP -= 10;
		//振動します
			Activity1.vibrator.vibrate(16*3);
			//パワーアップポイントを減らします
			if(powerupcount>=0){
				powerupcount--;
			}
			TekiTamaflag=false;
		}
		else{
			TekiTamaflag=true;
		}


		}


////////////ザコ移動処理///////////////
if(Tmove){


	Zy+=Zv;
	//画面外に出たら敵の位置をリセットします
	if(Zy>=viewh || zakoflag==false){
		Zy=0;
		//ランダムに敵を出現させます
		Zx=(float)Math.floor(Math.random()*vieww-40);
		zakoflag=true;
		//ザコが通り過ぎたり、倒された数をカウントします
		zakocount++;
	}


////////////ザコ当たり判定///////////////


	//すべての弾に当たっていないかここで判定しています
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



////////////ザコ自体の当たり判定///////////////

	if((Zx>JikiX && Zx<JikiX+40)
			&& (Zy>JikiY && Zy<JikiY+50) ){
		//ザコが自機にぶつかったら、HPを10引きます
		JikiHP -= 10;
		//振動します
		Activity1.vibrator.vibrate(16*3);
		zakoflag=false;
		JikiTamaflag=false;
		Activity1.vibrator.vibrate(16*3);

	}

////////////ザコ01移動処理//////////////


	Zy1+=Zv1;
	if(Zy1>=viewh || zakoflag1==false){
		Zy1=0;
		Zx1=(float)Math.floor(Math.random()*vieww-40);
		zakoflag1=true;
		zakocount++;
	}


////////////ザコ01当たり判定///////////////


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


////////////ザコ01自体の当たり判定///////////////

	if((Zx1>JikiX && Zx1<JikiX+40)
			&& (Zy1>JikiY && Zy1<JikiY+50) ){
		JikiHP -= 10;
		Activity1.vibrator.vibrate(16*3);
		zakoflag1=false;
		JikiTamaflag=false;
		Activity1.vibrator.vibrate(16*3);

	}


////////////ザコ02移動処理//////////////

	//ここの敵は、斜めに動くようになっています
	//なのでY軸にも変数が足されています

	Zy2 = Zy2 + Zyv2;
	Zx2 = Zx2 + Zxv2;

	//画面端まで行ったら、また反対側の画面端から出てくる
	if(Zx2 > vieww){
		Zx2 = 0;
	}
	if(Zy2>=viewh || zakoflag2==false ){
		Zy2=0;
		Zx2=(float)Math.floor(Math.random()*vieww-40);
		zakoflag2=true;
		zakocount++;
	}


////////////ザコ02当たり判定///////////////


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


////////////ザコ02自体の当たり判定///////////////

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
///////////パワーアップ///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

	//一定のscoreに達する事によって、アイテム出現
	//screddivまでscoreがいったら、アイテム出現
	//今のところ、40ずつ増える
	if(score == scorediv){
	PUflag=true;
	scorediv+=40;
	}
		//移動
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

	//ジキとの当たり判定
		//72は、ジキの横サイズ
		if((PUx>JikiX && PUx<JikiX+72)
				&& (PUy>JikiY && PUy<JikiY+72) ){
			JikiHP += 30;
			if(JikiHP>=280){
				JikiHP=280;
			}
			//効果音spを再生
			sp.play(Activity1.mSounds[0], 1.0f, 1.0f, 0, 0, 1.0f);
			//Y初期化
			PUy=-50;
			PUx=(float)Math.floor(Math.random()*vieww-40);
			//アイテムを取ると、ジキの弾が速くなります
			JikiTamaV+=5;
			powerupcount+=2;
			PUflag=false;

		}

	}












//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////stage1処理///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

	//ステージ1を選択するとstage1にtrueが入れられて、ここが動きます
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
///////////stage2処理///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

	//ステージ2を選択するとstage2にtrueが入れられて、ここが動きます
	if(stage2){

		if(vieww-BossHP>vieww-35 && normal2){
			gamestart=false;


			flash=true;
			BossHP=280;
			stage2power=true;
			normal2=false;

		}



	}





// 描画のちらつき処理
Canvas canvas = holder.lockCanvas(); // ロックをかける
drawOnCanvas(canvas);
holder.unlockCanvasAndPost(canvas); // ロックを解除
}

}
//kaiwa3フラグカッコ閉じ
}












////////////描画メソッド///////////////
public void drawOnCanvas(Canvas canvas){






//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////背景を生成///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////



	//初期背景
	Activity1.bgimage = Bitmap.createScaledBitmap(Activity1.bgimage, vieww, viewh, true);
	canvas.drawBitmap(Activity1.bgimage,0, 0, null);


	//ステージ１背景
	if(stage1){
//背景を、画面サイズに合わせる
Activity1.bgimage = Bitmap.createScaledBitmap(Activity1.bgimage, vieww, viewh, true);
//背景描画
canvas.drawBitmap(Activity1.bgimage,0, 0, null);
	}

	//ステージ２背景
	if(stage2){
		//背景を、画面サイズに合わせる
		Activity1.bgimage2 = Bitmap.createScaledBitmap(Activity1.bgimage2, vieww, viewh, true);
		//背景描画
		canvas.drawBitmap(Activity1.bgimage2,0, 0, null);
			}


/////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////
///////////////////////////////////////////
////////////キャラクタを生成///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////



if(gamestart){

canvas.drawBitmap(Activity1.jikiBitmap,JikiX,JikiY,null);

//おまちかねのボス　雑魚敵が通り過ぎるのを待つ
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


//おまちかねのボス　雑魚敵が通り過ぎるのを待つ
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
//強引に複数表示させよう！
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





////////////音楽生成///////////////

sp = Activity1.mSoundPool;



////////////敵・ジキライフ///////////////

//ライフを描画
paintlife2=new Paint();
paintlife = new Paint();
paintlife.setStyle(Style.FILL);
paintlife.setARGB(100, 255, 0, 0);
paintlife2.setStyle(Style.FILL);
paintlife2.setARGB(100, 0, 255, 0);
//敵のボスのライフが最初から表示されてる変なので出てきてから出します
if(zakocountflag == true){
canvas.drawRect(vieww-BossHP,8,vieww-35,28,paintlife);
}
canvas.drawRect(39,viewh-26,JikiHP,viewh-6,paintlife2);



////////////スコア///////////////


Paint Score = new Paint();
Score.setARGB(255,255,150,100);
Score.setTextSize(20);
canvas.drawText("score:", vieww-50,50, Score);
//数字をString型に変換
canvas.drawText(String.valueOf(score), vieww-50,70, Score);





































////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////以下、強引な画面変移/////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////




///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////GAMEOVER////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

if(JikiHP<=0){

	//横幅を、画面サイズに合わせる
	Activity1.gameover = Bitmap.createScaledBitmap(Activity1.gameover, vieww, 61, true);
	canvas.drawBitmap(Activity1.gameover,0, viewh/2, null);


	Activity1.mp.stop();
	Activity1.mp5.stop();
	isThreadrunning = false;
}


//if(gamestartの閉じカッコ
}


///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////横にシテネ画面////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

if(yokogamen){



	//背景を、画面サイズに合わせる
	Activity1.yoko = Bitmap.createScaledBitmap(Activity1.yoko, vieww, viewh, true);
	canvas.drawBitmap(Activity1.yoko,0, 0, null);

	//当たり判定は、かなりアバウト!!
	//ボタンの当たり判定///
	if((touchx > vieww/3*2 && touchx < vieww) && (touchy > viewh/3*2 && touchy < viewh )){

		Activity1.mp3.start();
		Activity1.vibrator.vibrate(16*3);

		// 時間のかかる処理をここに記述
		 try{
		Thread.sleep(1000); // 今回はわざと3秒間スリープ
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
/////////////////////////////////会話画面設定////////////////////////////////////
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
	canvas.drawText("よく来たわ・・・・",10,viewh-100,kaiwabun);
	canvas.drawText("アンタがドロイドね!!",10,viewh-50,kaiwabun);
	canvas.drawPath(path, ui);



	if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

		Activity1.vibrator.vibrate(16*3);


	kaiwa01 = false;

	// 時間のかかる処理をここに記述
	 try{
	Thread.sleep(1000); // 今回はわざと3秒間スリープ
	} catch (InterruptedException ie){}


	touchx = 0;
	touchy = 0;




	//////kawaiがtrueになると次の会話が表示されます///
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

	/////////入れ物を作ります////////////
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


	////////会話の文の色や大きさやウィンドの大きさを決めます///
	kaiwabun02.setARGB(255,255,255,255);
	kaiwabun02.setTextSize(25);
	kaiwabutton02.setARGB(255,255,255,255);
	kaiwawindow02.setARGB(100,0,0,255);

	////////立ち絵、文、ウィンドを表示します/////////////
	canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow02);
	canvas.drawText("あぁ、アップルの市場支配を",10,viewh-100,kaiwabun02);
	canvas.drawText("止めるためにやってきた",10,viewh-50,kaiwabun02);
	canvas.drawPath(path, ui);

	//ボタンの当たり判定///
	if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

		Activity1.vibrator.vibrate(16*3);

		// 時間のかかる処理をここに記述
		 try{
		Thread.sleep(1000); // 今回はわざと3秒間スリープ
		} catch (InterruptedException ie){}

		///////そしてtouchxとtouchyがここにいつずけると次の処理で一瞬で終了するので座標を少しずらします
		///////判定からxとyを追い出す
		touchx = 0;
		touchy = 0;

	//////kaiwa02がFalseになるとこの文が消えます
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


		/////////入れ物を作ります////////////
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

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("アンタが邪魔してくれたせいで、",10,viewh-100,kaiwabun);
		canvas.drawText("全て無駄になっちゃったじゃないｯ!!",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);

		//ボタンの当たり判定///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}

		///////kaiwa01がFalseになるとこの文が消えます//////
		kaiwa03 = false;


		///////そしてtouchxとtouchyがここにいつずけると次の処理で一瞬で終了するので座標を少しずらします
		///////判定からxとyを追い出す
		touchx = 0;
		touchy = 0;

	//////kawaiがtrueになると次の会話が表示されます///
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

		/////////入れ物を作ります////////////
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

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun02.setARGB(255,255,255,255);
		kaiwabun02.setTextSize(25);
		kaiwabutton02.setARGB(255,255,255,255);
		kaiwawindow02.setARGB(100,0,0,255);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow02);
		canvas.drawText("これ以上、市場を支配するなら",10,viewh-100,kaiwabun02);
		canvas.drawText("僕は君を止めなくちゃいけない！",10,viewh-50,kaiwabun02);
		canvas.drawPath(path, ui);

		//ボタンの当たり判定///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}


			///////そしてtouchxとtouchyがここにいつずけると次の処理で一瞬で終了するので座標を少しずらします
			///////判定からxとyを追い出す
			touchx = 0;
			touchy = 0;

		//////kaiwa02がFalseになるとこの文が消えます
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


		/////////入れ物を作ります////////////
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

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("あら頼もしい、でもアンタ如きに",10,viewh-100,kaiwabun);
		canvas.drawText("止める事が出来るのかしら？",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);

		//ボタンの当たり判定///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}

		///////kaiwa01がFalseになるとこの文が消えます//////
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

		/////////入れ物を作ります////////////
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

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun02.setARGB(255,255,255,255);
		kaiwabun02.setTextSize(25);
		kaiwabutton02.setARGB(255,255,255,255);
		kaiwawindow02.setARGB(100,0,0,255);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow02);
		canvas.drawText("僕は負けられないよ!!",10,viewh-100,kaiwabun02);
		canvas.drawText("スマートフォン市場を救うために・・！",10,viewh-50,kaiwabun02);
		canvas.drawPath(path, ui);

		//ボタンの当たり判定///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}


			///////そしてtouchxとtouchyがここにいつずけると次の処理で一瞬で終了するので座標を少しずらします
			///////判定からxとyを追い出す
			touchx = 0;
			touchy = 0;

		//////kaiwa02がFalseになるとこの文が消えます
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


		/////////入れ物を作ります////////////
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

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("・・・ｯ!?、もういいわ",10,viewh-100,kaiwabun);
		canvas.drawText("ここらで遊びは終わりってことを",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);
		//ボタンの当たり判定///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}

		///////kaiwa01がFalseになるとこの文が消えます//////
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


		/////////入れ物を作ります////////////
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

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(35);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		canvas.drawText("思い知らせてやるんだからｯ!",10,viewh-50,kaiwabun);
		canvas.drawPath(path, ui);
		//ボタンの当たり判定///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);


			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}

		///////kaiwa01がFalseになるとこの文が消えます//////
		kaiwa08 = false;
		Activity1.mp4.stop();



		touchx = 0;
		touchy = 0;


		stageselect = true;



		}
	}
}//kaiwa閉じ

///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////stageselect画面////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

	if(stageselect){

		/////////入れ物を作ります////////////
		Paint kaiwabun02 = new Paint();
		Paint kaiwabutton02 = new Paint();
		Paint kaiwawindow02 = new Paint();

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun02.setARGB(255,255,255,255);
		kaiwabun02.setTextSize(25);
		kaiwabutton02.setARGB(255,255,255,255);
		kaiwawindow02.setARGB(255,0,0,0);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawRect(0,0,vieww,viewh,kaiwawindow02);
		canvas.drawBitmap(Activity1.hardbotton,10,viewh/9,null);
		canvas.drawBitmap(Activity1.nomalbotton,10,viewh/9+130,null);
		canvas.drawText("",vieww/4,50,kaiwabun02);


		//stage1ボタンの当たり判定///
		if((touchx > 10 && touchx < 210) && (touchy > viewh/9 && touchy < viewh/9+110  )){

			Activity1.mp2.start();
			Activity1.vibrator.vibrate(16*3);

			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}

			touchx = 0;
			touchy = 0;



		stageselect = false;
		stage1=true;
		normal1=true;
		tategamen=true;

		}

		//stage2ボタンの当たり判定///
		if((touchx > 10 && touchx < 210) && (touchy > viewh/9+130 && touchy < viewh/9+240 )){

			Activity1.mp2.start();
			Activity1.vibrator.vibrate(16*3);

			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
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
/////////////////////////////////縦にシテネ画面////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

	if(tategamen){

		//背景を、画面サイズに合わせる
		Activity1.tate = Bitmap.createScaledBitmap(Activity1.tate, vieww, viewh, true);
		canvas.drawBitmap(Activity1.tate,0, 0, null);

		//当たり判定は、かなりアバウト!!
		//ボタンの当たり判定///
		if((touchx > vieww/3*2 && touchx < vieww) && (touchy > viewh/3*2 && touchy < viewh )){

			Activity1.mp3.start();
			Activity1.vibrator.vibrate(16*3);//振動

			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}

			touchx = 0;
			touchy = 0;

			tategamen=false;
			gamestart=true;//ゲームスタート!!

		}
	}




	//戦闘後の画面変移を強引に
	//多分、かなり強引な方法かと・・
	if((vieww-BossHP>vieww-35 && stage1power) || (vieww-BossHP>vieww-35 && stage2power)){
		deleteA=true;
	}

///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////横にシテネ画面////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

	if(yokogamen2){

		Activity1.mp6.stop();

		Activity1.mp5.stop();

		//背景を、画面サイズに合わせる
		Activity1.yoko = Bitmap.createScaledBitmap(Activity1.yoko, vieww, viewh, true);
		canvas.drawBitmap(Activity1.yoko,0, 0, null);

		//当たり判定は、かなりアバウト!!
		//ボタンの当たり判定///
		if((touchx > vieww/3*2 && touchx < vieww) && (touchy > viewh/3*2 && touchy < viewh )){

			Activity1.mp3.start();
			Activity1.vibrator.vibrate(16*3);//振動

			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
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

		/////////入れ物を作ります////////////
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

		////////会話の文の色や大きさやウィンドの大きさを決めます///
		kaiwabun.setARGB(255,255,255,255);
		kaiwabun.setTextSize(25);
		kaiwabutton.setARGB(255,255,255,255);
		kaiwawindow.setARGB(100,255,0,0);

		////////立ち絵、文、ウィンドを表示します/////////////
		canvas.drawBitmap(Activity1.titleapple,vieww-340,viewh-450,null);
		canvas.drawRect(0,viewh-150,vieww,viewh,kaiwawindow);
		if(stage1power){
		canvas.drawText("私の影分身の術が",10,viewh-100,kaiwabun);
		canvas.drawText("やぶられるなんて・・",10,viewh-50,kaiwabun);
		}
		if(stage2power){
			canvas.drawText("なんてやつなの・・!!",10,viewh-100,kaiwabun);
			canvas.drawText("私のアップルマシンが・・",10,viewh-50,kaiwabun);
			}
		canvas.drawPath(path, ui);

		//ボタンの当たり判定///
		if((touchx > vieww-80 && touchx < vieww-10) && (touchy > viewh-140 && touchy < viewh-70 )){

			Activity1.vibrator.vibrate(16*3);

			// 時間のかかる処理をここに記述
			 try{
			Thread.sleep(1000); // 今回はわざと3秒間スリープ
			} catch (InterruptedException ie){}


		///////kaiwa01がFalseになるとこの文が消えます//////

			kaiwa09 = false;

		touchx = 0;
		touchy = 0;


		//////kawaiがtrueになると次の会話が表示されます///
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
		canvas.drawText("勝った・・来たんや・・",10,viewh-100,kaiwabun02);
		canvas.drawText("Androidの時代が来たんや!!",10,viewh-50,kaiwabun02);
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
/////////////////////////////////エンドロール////////////////////////////////////
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

				//「fin.」が上からフェードイン
				canvas.drawText("fin.",vieww/3,e12+30,Dmoji);
				if(e12<=viewh/2){
					e12+=10;
				}
				//「fin.」が画面中心にきたら
				if(e12>=viewh/2){
					canvas.drawText("Thank you for playing!!",10,viewh-53,Kmoji);
					canvas.drawText("Please push BACK button",10,viewh-30,Kmoji);
				isThreadrunning = false;
				}

			}

//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////フラッシュ効果設定///////////////
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
	fl-=4;//フラッシュが晴れる速度
}
if(fl<=0){
this.flash=false;
gamestart = true;
}
}




//////////////////////////////////////////////////////////
///////////////////////////////////////////
///////////敵消滅時効果///////////////
///////////////////////////////////////////
//////////////////////////////////////////////////////////

if(deleteA){

	//Tmoveで、画面上のキャラ達を止める
	//ザコや、弾を非表示にしたりする
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

	 // 色はオレンジ
	 deleteA.setARGB(CirCol1,255,160,0);
	 deleteA2.setARGB(CirCol2,255,160,0);
	 deleteA3.setARGB(CirCol3,255,160,0);
	 deleteA4.setARGB(CirCol4,255,160,0);
	 deleteA5.setARGB(CirCol5,255,160,0);

	 //座標を散らす！
     canvas.drawCircle(BossX,BossY, divCircle1, deleteA);
     canvas.drawCircle(BossX+30,BossY, divCircle2, deleteA);
     canvas.drawCircle(BossX,BossY+40, divCircle3, deleteA);
     canvas.drawCircle(BossX+40,BossY+30, divCircle4, deleteA);
     canvas.drawCircle(BossX+50,BossY+70, divCircle5, deleteA);


     //○の大きくなるタイミング・順番
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


     //どんどん薄くなるAlfa！
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







     //最後の、デカい爆発終ると、開始
     if(CirCol5==0){

    	 try{
 			Thread.sleep(2000); // 今回はわざと2秒間スリープ
 			} catch (InterruptedException ie){}

 			touchx=0;touchy=0;
    	 yokogamen2=true;
 		Activity1.mp.stop();
 		gamestart = false;
 		BossHP=280;

 		this.deleteA=false;
     }








}//deleteA閉じ

//これより上に、処理を描くんだ！
		}



public void invalidate() {
	// TODO 自動生成されたメソッド・スタブ

}
}





