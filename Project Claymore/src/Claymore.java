
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
public class Claymore extends BasicGame {
	Image background; 


	
	Sprite p1 = new Sprite(200, 200) ;

	
	public Claymore() {
		super("Claymore");

	}

	public static void main(String[] args) {
		try
        {
            AppGameContainer app = new AppGameContainer(new Claymore());
            app.setDisplayMode(800, 600, false);
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {

		//g.drawImage(background, 0, 0);
		
		g.drawImage(background, 0, 0, p1.bg_x, 0, p1.bg_x + 800*4, 600);
		p1.spriteAnimation.draw(p1.x - 172 / 2, p1.y);
		
		
	}
		
	@Override
	public void init(GameContainer container) throws SlickException {
		background = new Image("Backgrounds/dungeon.png");
		p1.sprite = new SpriteSheet("Sprites/YomaWinged2.png", 172 ,200);
		p1.spriteAnimation = new Animation(p1.sprite, 350);
		
	}
	
 
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//p1.update(delta);
		boolean checkLR = false, 
				checkUD = false;
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			checkLR = true;
			p1.Motion(delta, checkLR, checkUD);
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			checkLR = false;
			p1.Motion(delta, checkLR, checkUD);
		}
		/*
		if(input.isKeyDown(input.KEY_UP)){
			checkUD = true;
			p1.Motion(delta, checkLR, checkUD);
		}
		if(input.isKeyDown(input.KEY_DOWN)){
			checkLR = false;
			p1.Motion(delta, checkLR, checkUD);
		}*/
		
		

		
	}

}
