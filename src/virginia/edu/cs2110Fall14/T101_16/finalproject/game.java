package virginia.edu.cs2110Fall14.T101_16.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class game extends Activity {
	// MediaPlayer bgm = MediaPlayer.create(this, R.raw.moonlightsonata);
	private gameview a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// bgm.start();
		setContentView(R.layout.game);
		a = (gameview) findViewById(R.id.gameview);
		Button upbutton = (Button) findViewById(R.id.upbutton);
		Button downbutton = (Button) findViewById(R.id.downbutton);
		Button leftbutton = (Button) findViewById(R.id.leftbutton);
		Button rightbutton = (Button) findViewById(R.id.rightbutton);
		Button bombbutton=(Button) findViewById(R.id.bombbutton);
		Button attackbutton=(Button) findViewById(R.id.attackbutton);
		TextView tv=(TextView) findViewById(R.id.score);
		//tv.setText("The score now is "+a.getScore());

		bombbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//drop bomb
			}
		});
		
		attackbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//attack the enemy
			}
		});
		upbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a.up();
			}
		});

		downbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a.down();
			}
		});

		leftbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a.left();
			}
		});

		rightbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a.right();
			}
		});
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// bgm.release();
		a.resume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		a.pause();
	}

}
