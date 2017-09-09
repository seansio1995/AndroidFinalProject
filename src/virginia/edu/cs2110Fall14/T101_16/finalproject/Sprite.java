package virginia.edu.cs2110Fall14.T101_16.finalproject;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	int x, y;
	int xSpeed, ySpeed;
	int height, width;
	Bitmap b;
	gameview ov;
	int currentFrame = 0;
	int direction = 3;
	double score=0;
	double money;
	
	public Sprite(gameview ourView, Bitmap blob) {
		// TODO Auto-generated constructor stub
		b = blob;
		ov = ourView;
		//4 rows
		height = b.getHeight()/4;
		width = b.getWidth()/3;
		x = y = 0;
	} 
	
	public void setScore(double s)
	{
		score=s;
	}
	
	public double getScore()
	{
		return score;
	}

	public void up(){
			y-=10;
			direction = 0;
		
	}
	
	public void down(){
			y+=10;
			direction = 1;
	}
	
	public void left(){
			x-=10;
			direction = 2;
			}
	
	public void right(){
		
			x+=10;
			direction = 3;
			}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
		
	}
		
	public void onDraw(Canvas canvas, int tag) {
		// TODO Auto-generated method stub
		int srcY = direction * height;
		int srcX = tag * width;
		
//		update();
		Rect src = new Rect (srcX, srcY, srcX+width, srcY+height);
		Rect dst = new Rect (x, y, x+width, y+height);
		canvas.drawBitmap(b, src, dst, null);
	}
	
	
	

	/**private void update() {
		// TODO Auto-generated method stub
		
		 * 0= up
		 * 1 = down
		 * 2 = left
		 * 3 = right
		
		//face down
		if(x>ov.getWidth()-width-xSpeed){
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
		
		
		currentFrame = ++currentFrame % 3;
		x += xSpeed;
		y += ySpeed;
		
	}**/

}
