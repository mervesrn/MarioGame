
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.entity.powerup;

import java.awt.Graphics;
import java.util.Random;

import merve_ve_iremin_oyunu.entity.Entity;
import merve_ve_iremin_oyunu.mario.Game;
import merve_ve_iremin_oyunu.mario.Handler;
import merve_ve_iremin_oyunu.mario.Id;
import merve_ve_iremin_oyunu.tile.Tile;

public class Mushroom extends Entity{
	
	private Random random=new Random();

	public Mushroom(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		// TODO Auto-generated constructor stub
		
		int dir=random.nextInt(2);
		switch(dir) {
			case 0:
				setVelX(-5);
				break;
			case 1:
				setVelX(5);
				break;	
		}
	}
	public void render(Graphics g) {
		g.drawImage(Game.mushroom.getBufferedImage(), x, y, width, height, null);
	}

	public void tick() {

		x+=velX;
		y+=velY;
		for(int i=0;i<handler.tile.size();i++) {
			Tile t=handler.tile.get(i);
			if(t.isSolid()) {
				
		
				if(getBoundsBottom().intersects(t.getBounds())) {
					setVelY(0);
					
				if(falling) falling=false;
					
				}else if(!falling ) {
							gravity=0.8;
							falling=true;
				}

				if(getBoundsLeft().intersects(t.getBounds())) {
					setVelX(5);
				
				}
				if(getBoundsRight().intersects(t.getBounds())) {
					setVelX(-5);
				
				}
			}
		}
		
		if(falling) {
			gravity+=0.1;
			setVelY((int)gravity);
		}
	}
}
