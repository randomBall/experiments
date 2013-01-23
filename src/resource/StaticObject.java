package resource;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class StaticObject extends GameObject {
		public boolean renderable;
		protected Image sprite;	

	public StaticObject(Image sprite, float x, float y) {
		super(x, y, sprite.getWidth(), sprite.getHeight());
		this.sprite = sprite;
		renderable = true;
	}
	
	public void render(GameContainer gc, Graphics g) {
		if(renderable == true)
			sprite.draw(x, y);
	}
}
