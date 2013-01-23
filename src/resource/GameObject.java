package resource;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public abstract class GameObject {
		public boolean active;
		public float x, y;	
		public float width, height;
		
		float boxOffsetX, boxOffsetY;
		Rectangle box;
		
	public GameObject() {
		active = true;
		box = new Rectangle(0, 0, 0, 0);
		x = 0;
		y = 0;
		width = 0;
		height = 0;
		boxOffsetX = 0;
		boxOffsetY = 0;
	}
	
	public GameObject(float x, float y, float width, float height) {
		active = true;
		box = new Rectangle(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		boxOffsetX = 0;
		boxOffsetY = 0;
	}
	
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		box.setLocation(x + boxOffsetX, y + boxOffsetY);
	}
	
	public void setBoxOffset(float x, float y) {
		boxOffsetX = x;
		boxOffsetY = y;
		box.setLocation(this.x + boxOffsetX, this.y + boxOffsetY);
		box.setWidth(width - boxOffsetX);
		box.setHeight(height - boxOffsetY);
	}
	
	public abstract void update(GameContainer gc, int delta);
	public abstract void render(GameContainer gc, Graphics g);
}
