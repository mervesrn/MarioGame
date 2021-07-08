
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.mario.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import merve_ve_iremin_oyunu.entity.Entity;
import merve_ve_iremin_oyunu.mario.Game;
import merve_ve_iremin_oyunu.mario.Id;

public class KeyInput implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int key =e.getKeyCode();
		for(Entity en:Game.handler.entity) {
			
			if(en.getId()==Id.player) {
				switch(key) {
				case KeyEvent.VK_W:
					if(!en.jumping) 
					{
						en.jumping=true;
						en.gravity=10.0;
					}
					//en.setVelY(-5);
					break;
				case KeyEvent.VK_S:
					en.setVelY(0);
					break;
				case KeyEvent.VK_A:
					en.setVelX(-5);
					break;
				case KeyEvent.VK_D:
					en.setVelX(5);
					break;
				
				}
			}
		}
		
	}
	
public void keyReleased(KeyEvent e) {
	
	int key =e.getKeyCode();
	
	for(Entity en:Game.handler.entity) {
		if(en.getId()==Id.player) {
		switch(key) {
		case KeyEvent.VK_W:
			en.setVelY(0);
			break;
		
		case KeyEvent.VK_S:
			en.setVelY(0);
			break;
		case KeyEvent.VK_A:
			en.setVelX(0);
			break;
		case KeyEvent.VK_D:
			en.setVelX(0);
			break;
		}
			
		}
	}
	}


public void keyTyped(KeyEvent arg0) {
		
		//not using
	}

	

	
	

}

