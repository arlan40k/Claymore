import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;


public class Sprite extends Animation {
	public float x;
	public float bg_x;
	public float lastY;
	public float lastX;
	public int yTiles = 0;
	public int xTiles = 5;
	public float y;
	public Image[] sprite = new Image[6];
	public Animation spriteAnimation;
	
	public Sprite(float x, float y){
		this.x = x;
		this.y = y;
		lastY = y;
		lastX = x;
		
	}
	public void Motion(int delta, boolean checkR, boolean checkL, boolean checkUp, boolean collision[][] ){
		
		
		// Right and Left movement
		if(checkR){
			if(x <= 3200){
				if(collision[xTiles][yTiles] != true){
				x = x + delta * .2f;
				checkR = false;
					bg_x += 0.01;
					if(x > 30 + lastX){
						xTiles += 1;
						lastX = x;					}
				}
			}
			
		}
		
		
		
		 if(checkL){
			 if(x >= 0){
				
				x =  x - delta * .2f;
				checkL = false;
				bg_x -= 0.01 * delta;
				if(x < lastX - 30){
				xTiles -= 1;
				lastX = x;
				}
				}
			 }
		
	
		
		
				// Down and Up movement
		/*
		if(checkUD)
			y = y + delta * .04f;
			
		*/
	 if(checkUp){
			y = y - delta* .1f;
		checkUp = false;
			if(y < lastY + - 20){
			yTiles -= 1;
			lastY = y;
			}
	 }
		
	}	
		
		
	
	public void spriteAnimation(){
		
	}
	
	public void gravity(int delta, boolean[][] collision){
		
		if(collision[xTiles][yTiles] != true)
		y = y + delta * 0.1f;
		if(y   > 20 + lastY){
			yTiles +=1;
			lastY = y ;
		}
		
	
	}
}
