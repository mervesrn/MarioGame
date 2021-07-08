
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.mario.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
private BufferedImage sheet;
public SpriteSheet(String path) {
	try {
		sheet= ImageIO.read(getClass().getResource(path));
		
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
 public BufferedImage getSprite(int x,int y) {
	 
	 return sheet.getSubimage(x*32-32, y*32-32, 32, 32);
 }

	
}

