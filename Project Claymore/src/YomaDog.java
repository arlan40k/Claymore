import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class YomaDog {
	public float x = 600.0f;
	public float y = 300.0f;
	public SpriteSheet image;
	public Animation anim;
	public int hp;
	
	public YomaDog() throws SlickException{
		image  = new SpriteSheet("Sprites/YomaDogWalk.png", 150, 69);
		anim = new Animation(image, 1000);
			
	}
	
	public void movement(){
		
	}
	

}
