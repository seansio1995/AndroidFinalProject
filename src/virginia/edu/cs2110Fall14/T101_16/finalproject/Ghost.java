package virginia.edu.cs2110Fall14.T101_16.finalproject;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Ghost {

	int x, y;
	int xSpeed, ySpeed;
	int height, width;
	Bitmap b;
	gameview ov;
	int currentFrame = 0;
	int direction;
	Random rand = new Random();
	Sprite player;
	
	public Ghost(gameview ourView, Bitmap blob,Sprite player) {
		// TODO Auto-generated constructor stub
		b = blob;
		this.player=player;
		ov = ourView;
		//4 rows
		height = b.getHeight()/4;
		width = b.getWidth()/3;
		direction = rand.nextInt(4);
		x=300;
		y=300;
//		this.x=x+rand.nextInt(40)+40;
//		this.y=y+rand.nextInt(40)+40;
		
		
	} 

	
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
		
	}
		
	public void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		int srcY = direction * height;
		int srcX = currentFrame * width;
		update();
		if(x-width<0 || x+width>ov.getWidth())
		{
			xSpeed*=-1;
		}
		
		if(y-height<0 || y+height>ov.getHeight())
		{
			ySpeed*=-1;
		}
		Rect src = new Rect (srcX, srcY, srcX+width, srcY+height);
		Rect dst = new Rect (x, y, x+width, y+height);
		canvas.drawBitmap(b, src, dst, null);
	}
	
	public void update()
	{
		if(x<player.getx())
		{
			xSpeed=10;
		}
		if(x>player.getx())
		{
			xSpeed=-10;
		}
		if(y<player.gety())
		{
			ySpeed=10;
		}
		
		if(y>player.gety())
		{
			ySpeed=-10;
		}
		
		currentFrame = ++currentFrame % 3;
		x += xSpeed;
		y += ySpeed;
		
		
	}
	
	

	public void changeDirection() {
		// TODO Auto-generated method stub
		
	/**	 * 0= up
		 * 1 = down
		 * 2 = left
		 * 3 = right
		**/
		//face down
		direction = rand.nextInt(4);
		switch(direction){
		case 0:
			if(y-10>0){
				xSpeed =0;
				ySpeed =-5;
			}
			else{
				xSpeed = 0;
				ySpeed = 5;
			}
			break;
		case 1:
			if(y+10+height<ov.getHeight()){
				xSpeed =0;
				ySpeed =5;
			}
			else{
				xSpeed =0;
				ySpeed =-5;
			}
			break;
		case 2:
			if(x-10>0){
				xSpeed=5;
				ySpeed=0;
			}
			else{
				xSpeed=-5;
				ySpeed=0;
			}
			break;
		case 3:
			if(x+10+width<ov.getWidth()){
				xSpeed=-5;
				ySpeed=0;
			}
			else{
				xSpeed = 5;
				ySpeed =0;
				
			}
			break;
		}
		/**if(x>ov.getWidth()-width-xSpeed){
			xSpeed = 0; 
			ySpeed = 5;
			direction = 1;
		}
		//going left[
		if(y > ov.getHeight()- height - ySpeed){
			xSpeed = -5;
			ySpeed = 0;
			direction = 2;
		}
		//going up
		if(x+xSpeed <0){
			x =0;
			xSpeed =0;
			ySpeed =-5;
			direction = 0;
		}
		//facing right
		if(y+ySpeed <0){
			y=0;
			xSpeed=5;
			ySpeed=0; 
			direction = 3;
		}
		**/
		
		currentFrame = ++currentFrame % 3;
		x += xSpeed;
		y += ySpeed;
		
	}
	
}