
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
	TiledMap map;
	int mapTile[][] = new int[99][30];
	boolean collision[][] = new boolean[99][30];
	
	Sprite p1 = new Sprite(100, 0) ;
	YomaDog dog2;
	
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
		map.render(0, 0 , 0, 0, 100, 30);
	
		p1.spriteAnimation.draw(p1.x , p1.y);
		dog2.anim.draw(dog2.x,dog2.y);
	}
		
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new  TiledMap("Backgrounds/bob.tmx");	
		p1.sprite[0] = new Image("Sprites/StandAni1.png");
		p1.sprite[1] = new Image("Sprites/StandAni2.png");
		p1.sprite[2] = new Image("Sprites/StandAni3.png");
		p1.sprite[3] = new Image("Sprites/StandAni4.png");
		p1.sprite[4] = new Image("Sprites/StandAni5.png");
		p1.sprite[5] = new Image("Sprites/StandAni5.png");
		p1.spriteAnimation = new Animation(p1.sprite, 1000);
		dog2 = new YomaDog();
		for(int indexX = 0; indexX < 100; indexX++){
		for(int indexY = 0; indexY < 30; indexY++){
		if(map.getTileId(indexX, indexY, 0) == 375  )
			collision[indexX][indexY] = true;
			
			
		}
		}
		

	}
	
 
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//p1.update(delta);
		//System.out.println(getTileProperty())
		//System.out.println(map.getTileId(27, 11, 0));
		System.out.println(p1.xTiles);
	
		boolean checkR = false, 
				checkL = false,
				checkUp = false;
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			checkR = true;
			p1.Motion(delta, checkR, checkL, checkUp, collision);
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			checkL = true;
			p1.Motion(delta, checkR, checkL, checkUp, collision);
		}
			//System.out.println(map.getTileId(27,10,1));
			
			
			
			p1.gravity(delta, collision);
		
		if(input.isKeyDown(Input.KEY_UP)){
			checkUp = true;
			p1.Motion(delta, checkR, checkL, checkUp, collision);
		}
		/*
		if(input.isKeyDown(input.KEY_DOWN)){
			checkLR = false;
			p1.Motion(delta, checkLR, checkUD);
		}
		*/
		

		
	}

}
