
/*
 Name: Merve ��R�N Id:201626404
 Name: �rem �AH�NG�Z Id:201611051
 */

package merve_ve_iremin_oyunu.mob;

import java.awt.Graphics;
import java.util.Random;

import merve_ve_iremin_oyunu.entity.Entity;
import merve_ve_iremin_oyunu.mario.Game;
import merve_ve_iremin_oyunu.mario.Handler;
import merve_ve_iremin_oyunu.mario.Id;
import merve_ve_iremin_oyunu.tile.Tile;

public class Goomba extends Entity{

	private Random random=new Random();
	
	public Goomba(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
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
		g.drawImage(Game.goomba.getBufferedImage(), x, y, width ,height,null );
	}
	
	public void tick() {
		x+=velX;
		y+=velY;
		for(int i=0;i<handler.tile.size();i++) {
			Tile t=handler.tile.get(i);
			if(t.isSolid()) {
				
				//if(t.getId()==Id.wall) {
					if(getBoundsLeft().intersects(t.getBounds())) {
						setVelY(0);
						setVelX(-x);
						if(jumping) {
							jumping=false;
							gravity=0.8;
							falling=true;
						}
					}
				
				if(getBoundsBottom().intersects(t.getBounds())) {
					setVelY(0);
					//setVelX(-1);
				if(falling) falling=false;
					
				else if(!falling ) {
							gravity=0.8;
							falling=true;
				}
				}
					
				
				if(getBoundsLeft().intersects(t.getBounds())) {
					setVelX(5);
				
				}
				if(getBoundsRight().intersects(t.getBounds())) {
					setVelX(-5);
				
				}
				//}
			}
		}
		
		if(falling) {
			gravity+=0.1;
			setVelY((int)gravity);
		}
	}
}
