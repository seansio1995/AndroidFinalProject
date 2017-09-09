package virginia.edu.cs2110Fall14.T101_16.finalproject;

import java.io.InputStream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.graphics.Matrix;
import android.media.MediaPlayer;

public class gameview extends SurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder holder;

	private MyThread thread;

	private boolean isrun;

	private MediaPlayer player;

	public Bitmap character;

	public Sprite protagonist;
	
	public Bitmap ghostpic;
	
	public Ghost ghost;

	int money;

	public gameview(Context context, AttributeSet attrs) {

		super(context, attrs);

		// TODO Auto-generated constructor stub

		holder = getHolder();

		holder.addCallback(this);

		money = 0;

		// MediaPlayer的初始化

		player = MediaPlayer.create(context, R.raw.moonlightsonata);
		player.setLooping(true);// 设置循环播放

	}
	
	public double getScore()
	{
		return protagonist.getScore();
	}

	public void up() {
		// isrun=true;
		protagonist.up();
		ghost.update();
		
		// isrun=false;
	}

	public void down() {
		// isrun=true;
		protagonist.down();
		ghost.update();
		// isrun=false;
	}

	public void left() {
		// isrun=true;
		protagonist.left();
		ghost.update();
	}

	public void right() {
		// isrun=true;
		protagonist.right();
		// isrun=false;
		ghost.update();
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub

		character = BitmapFactory.decodeResource(getResources(), 0x7f020003);

		protagonist = new Sprite(this, character);

		ghostpic = BitmapFactory.decodeResource(getResources(), 0x7f020003);
		
		ghost = new Ghost(this, ghostpic,protagonist);
		
		isrun = true;

		thread = new MyThread();

		thread.start();

	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		isrun = false;
	}

	public void pause() {
		isrun = false;
		player.release();
		while (true) {
			try {
				thread.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
		// thread = null;
	}

	public void resume() {
		isrun = true;
		thread = new MyThread();
		thread.start();
		player.start();

	}

	class MyThread extends Thread

	{

		@SuppressLint("WrongCall")
		public void run()

		{

			SurfaceHolder runholder = holder;

			while (isrun == true)

			{
				player.start();
				if (!holder.getSurface().isValid()) {
					continue;
				}

				Canvas canvas = runholder.lockCanvas();
				Paint p = new Paint();
				p.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
				canvas.drawPaint(p);
				protagonist.onDraw(canvas, 0);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				protagonist.onDraw(canvas, 1);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				protagonist.onDraw(canvas, 2);
				
				ghost.onDraw(canvas);
				

				runholder.unlockCanvasAndPost(canvas);

			}

			try {
				sleep(100);
			} catch (Exception ex) {

			}
		}

	}

}
