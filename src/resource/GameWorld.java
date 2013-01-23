package resource;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameWorld {
		public List<GameObject> objectList;
		
	public GameWorld() {
		objectList = new ArrayList<GameObject>();
	}
	
	public void addObject(GameObject object) {
		objectList.add(object);
	}
	
	public void cleanWorld() {
		objectList.clear();
	}
	
	public void update(GameContainer gc, int delta) {
		for(int i = 0; i < objectList.size(); i++) {
			if(!objectList.get(i).active)
				objectList.remove(i);
			else
				objectList.get(i).update(gc, delta);
		}
	}
	
	public void render(GameContainer gc, Graphics g) {
		for(int i = 0; i < objectList.size(); i++) {
			objectList.get(i).render(gc, g);
		}
	}
}
