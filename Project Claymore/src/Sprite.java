import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Sprite extends Animation {
	public float x;
	public float bg_x;
	public float y;
	public SpriteSheet sprite;
	public Animation spriteAnimation;
	
	public Sprite(float x, float y){
		this.x = x;
		this.y = y;
		
	}
	public void Motion(int delta, boolean checkR, boolean checkL, boolean checkUp ){
		
		
		// Right and Left movement
		if(checkR){
			if(x <= 3200){
				x = x + delta * .01f;
				checkR = false;
					bg_x += 0.01;
			}
			
		}
		
		
		
		else if(checkL){
			if(x  >= 200 ){
				x = x - delta * .01f;
				checkL = false;
				bg_x -= 0.01f * delta;
			}
		}
	}
		
		
				// Down and Up movement
		/*
		if(checkUD)
			y = y + delta * .04f;
			
		
		else if(!checkUD)
			y = y - delta* .04f;
		*/
		
		
		
	
	public void SpriteAnimation(){
		
	}
}
