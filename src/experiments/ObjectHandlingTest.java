package experiments;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import resource.GameWorld;

public class ObjectHandlingTest extends BasicGame {
		GameWorld testWorld;
		Image testSprite;
		TestObject testObject;
		Input playerInput;
		int tempNum;
		int elapsedTime;
		
		final int COOLDOWN = 300;
	public ObjectHandlingTest() {
		super("Object Handling Test");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		testWorld = new GameWorld();
		testSprite = new Image("Assets/Graphics/testSprite64x64.png");
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		elapsedTime += delta;
		playerInput = gc.getInput();
		
		if(playerInput.isKeyDown(Input.KEY_SPACE) && elapsedTime >= COOLDOWN) {
			tempNum = (int)(Math.random() * (7 - 1 + 1)) + 1;
			genObject(tempNum);
			elapsedTime = 0;
		}
		else if(playerInput.isKeyDown(Input.KEY_C))
			testWorld.cleanWorld();
		
		testWorld.update(gc, delta);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		testWorld.render(gc, g);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer game = new AppGameContainer(new ObjectHandlingTest());
		game.setDisplayMode(800, 600, false);
		game.start();
	}
	
	public void genObject(int n) {
		float tempX, tempY;
		
		for(int i = 0; i < n; i++) {
			tempX = (float)(Math.random() * (800 - 64 + 1));
			tempY = (float)(Math.random() * (600 - 64 + 1));
			
			testObject = new TestObject(testSprite, tempX, tempY);
			testWorld.addObject(testObject);
		}
	}
}
