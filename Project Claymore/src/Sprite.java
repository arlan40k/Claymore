import java.sql.Time;


import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Sprite extends Animation {
	public float x = 0;
	public float y = 0;
	public float bg_x;
	public float lastY;
	public float lastX;
	public int yTiles = 0;
	public int xTiles = 0;
	
	public SpriteSheet sprite;
	public Animation anim;
	public Animation attack;
	public Animation stand;
	
	public Sprite() throws SlickException{
		this.x = x;
		this.y = y;
		sprite = new SpriteSheet("Sprites/StandStillAnimation.png", 45, 59);
		anim = new Animation(sprite, 500);
		stand = anim;
		sprite = new SpriteSheet("Sprites/basicAttack.png", 80, 77);
		attack = new Animation(sprite, 100);
		lastY = y;
		lastX = x;
		
		
	}
	public void Motion(int delta, boolean checkR, boolean checkL, boolean checkUp, boolean collision[][] ){
		
		
		// Right and Left movement
		if(checkR){
			if(x <= 3200){
				if(collision[xTiles+1][yTiles+1] != true){
				x = x + delta * .2f;
				checkR = false;
					bg_x += 0.01;
				}
					if(x > 30 + lastX){
						xTiles += 1;
						lastX = x;					
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
	
	 if(checkUp){
			y = y - delta* .1f;
			checkUp = false;
			
				if(y < lastY  - 30){
					yTiles -= 1;
					lastY = y;
			}
	 }
		
	}	
		
		
	
	public void spriteAnimation(){
		anim = attack;
	}
	
	public void gravity(int delta, boolean[][] collision){
		 
		if(y <= 510.0f)
			y = y + delta * 0.1f;
/*		if(collision[xTiles+1][yTiles+1] != true)
			y = y + delta * 0.1f;
			if(y   > 30 + lastY){
				yTiles +=1;
				lastY = y ;
			}
*/		
		
	
	}
}
