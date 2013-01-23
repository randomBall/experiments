package experiments;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import resource.StaticObject;

public class TestObject extends StaticObject{
		int direction;
		float speed;
	
	public TestObject(Image sprite, float x, float y) {
		super(sprite, x, y);
		direction = (int)(Math.random() * (1 + 1 + 1)) - 1;
		speed = 0.1f;
	}

	@Override
	public void update(GameContainer gc, int delta) {
		x += speed * direction * delta;
		
		if(x < -sprite.getWidth() || x > gc.getWidth())
			active = false;
	}
}
