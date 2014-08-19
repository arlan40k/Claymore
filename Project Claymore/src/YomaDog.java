import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class YomaDog {
	public float x = 600.0f;
	public float y = 300.0f;
	
	public Animation anim;
	public int hp;
	public Animation walk;
	public Animation attack;
	public YomaDog() throws SlickException{
		SpriteSheet image;
		image  = new SpriteSheet("Sprites/YomaDogWalk.png", 125, 69);
		walk = new Animation(image, 200);
		image  = new SpriteSheet("Sprites/YomaDogAttack.png", 140, 100);
		attack = new Animation(image, 200);
		anim = walk;
	}
	
	public void motion(int delta, Sprite p1) throws SlickException{
		
		
		if(Math.abs(p1.x - x) < 57)
			anim = attack;
		else
			anim = walk;
	
		if(p1.x + 57 <= x){
			
			x = x - delta * 0.08f;
			
		}else if(p1.x >= x){
			x = x + delta * 0.08f;
			
		}
		if(x > p1.x + 100){

		}
		if(y < 475){
			y = y + delta * 0.1f;
		}

	}
}