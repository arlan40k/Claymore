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
	public void Motion(int delta, boolean checkLR, boolean checkUD ){
		
		// Right and Left movement
		if(checkLR){
			if(x <= 600)
				x = x + delta * .4f;
			else if(bg_x < 3200 - 800)
				bg_x = bg_x + delta *.4f;
			
			
		
				
		
		}
		else if(!checkLR)
			if(x  >= 200)
				x = x - delta * .4f;
			else if(bg_x > 0)
				bg_x = bg_x - delta * .4f;
			
		
		
		
		// Down and Up movement
		/*
		if(checkUD)
			y = y + delta * .04f;
			
		
		else if(!checkUD)
			y = y - delta* .04f;
		*/
		
		
		
	}
	public void SpriteAnimation(){
		
	}
}
