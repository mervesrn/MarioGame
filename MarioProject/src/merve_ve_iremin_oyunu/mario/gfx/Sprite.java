
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.mario.gfx;

import java.awt.image.BufferedImage;


public class Sprite {
	public SpriteSheet sheet;
	public BufferedImage image;
	
	public Sprite(SpriteSheet sheet,int x,int y ) {
		
		image=sheet.getSprite(x,y);
	}
	
	public BufferedImage getBufferedImage() {
		
		return image;
	}
}
