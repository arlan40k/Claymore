
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

// Jonathan was here!
public class Claymore extends BasicGame {
	Image background; 
	TiledMap blaza;

	
	Sprite p1 = new Sprite(200, 100) ;

	
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
		
		//THIS TOOK WAY TO LONG JJ!!!!! Errg I hate programming lol, but I refuse to lose!
		blaza.render(0, 0 , (int)p1.bg_x, 1, 100, 200);
	
		p1.spriteAnimation.draw(p1.x - 172 / 2, p1.y);
		g.translate(p1.x, 0);
	}
		
	@Override
	public void init(GameContainer container) throws SlickException {
		blaza = new  TiledMap("Backgrounds/Urg.tmx");
	//	background = new Image("Backgrounds/dungeon.png");	
		p1.sprite = new SpriteSheet("Sprites/YomaWinged2.png", 172 ,200);
		p1.spriteAnimation = new Animation(p1.sprite, 350);

	}
	
 
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//p1.update(delta);
		
		boolean checkR = false, 
				checkL = false,
				checkUp = false;
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			checkR = true;
			p1.Motion(delta, checkR, checkL, checkUp);
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			checkL = true;
			p1.Motion(delta, checkR, checkL, checkUp);
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
