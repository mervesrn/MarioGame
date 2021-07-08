
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.tile;

import java.awt.Color;
import java.awt.Graphics;

import merve_ve_iremin_oyunu.mario.Game;
import merve_ve_iremin_oyunu.mario.Handler;
import merve_ve_iremin_oyunu.mario.Id;

public class Wall extends Tile{

	public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Game.grass.getBufferedImage(), x, y, width ,height,null );
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
