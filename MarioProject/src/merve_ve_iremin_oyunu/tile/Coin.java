
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.tile;

import java.awt.Graphics;

import merve_ve_iremin_oyunu.mario.Game;
import merve_ve_iremin_oyunu.mario.Handler;
import merve_ve_iremin_oyunu.mario.Id;

public class Coin extends Tile{

	public Coin(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		// TODO Auto-generated constructor stub
	}

	
	public void render(Graphics g) {
		g.drawImage(Game.coin.getBufferedImage(), x, y, width, height, null);
		
	}


	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
