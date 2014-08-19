
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


public class Claymore extends BasicGame { 
	TiledMap map;
	boolean collision[][] = new boolean[99][30];
	
	Sprite p1;
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

		map.render(0, 0 , (int)p1.bg_x, 0, 100, 30);
	
		p1.anim.draw(p1.x , p1.y);
		dog2.anim.draw(dog2.x,dog2.y);
	}
		
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new  TiledMap("Backgrounds/BG.tmx");	
		p1 = new Sprite();
	
		dog2 = new YomaDog();
		for(int indexX = 0; indexX < 100; indexX++){
		for(int indexY = 0; indexY < 30; indexY++){
		if(map.getTileId(indexX, indexY, 1) ==  3894  )
			collision[indexX][indexY] = true;
			
			
		}
	}
		

}
	
 
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		boolean checkR = false, 
				checkL = false,
				checkUp = false;
		Input input = container.getInput();
		//Start of Movement Commands for Player
		if(input.isKeyDown(Input.KEY_RIGHT)){
			checkR = true;
			p1.Motion(delta, checkR, checkL, checkUp, collision);
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			checkL = true;
			p1.Motion(delta, checkR, checkL, checkUp, collision);
		}	
			
			p1.gravity(delta, collision);
		
		if(input.isKeyDown(Input.KEY_UP)){
			checkUp = true;
			p1.Motion(delta, checkR, checkL, checkUp, collision);
			
		}
		//End of movement Commands for Player
		
		//Start of Attack Commands for Player
		if(input.isKeyDown(Input.KEY_Q))
			p1.spriteAnimation();
	
		dog2.motion(delta, p1);
		if(p1.anim.getFrame() == 9){
			p1.anim = p1.stand;
		}
		System.out.println(p1.anim.getFrame());
		
		
	}

}
