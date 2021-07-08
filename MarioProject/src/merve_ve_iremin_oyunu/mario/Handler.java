
/*
 Name: Merve ��R�N Id:201626404
 Name: �rem �AH�NG�Z Id:201611051
 */

package merve_ve_iremin_oyunu.mario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import merve_ve_iremin_oyunu.entity.Entity;
import merve_ve_iremin_oyunu.entity.powerup.Mushroom;
import merve_ve_iremin_oyunu.mob.Goomba;
import merve_ve_iremin_oyunu.mob.Player;
import merve_ve_iremin_oyunu.tile.Coin;
import merve_ve_iremin_oyunu.tile.Princess;
import merve_ve_iremin_oyunu.tile.Tile;
import merve_ve_iremin_oyunu.tile.Wall;

public class Handler {

	public LinkedList<Entity> entity=new LinkedList<Entity>();
	
	public LinkedList<Tile> tile=new LinkedList<Tile>();
	
	public Handler() {
		
	}
	public void render(Graphics g) {
		for(Entity en:entity) {
			en.render(g);
			
		}
		
		for(Tile ti:tile) {
			ti.render(g);
			
		}
	}
	public void tick() {
		
		for(Entity en:entity) {
			
			en.tick();
			
		}
		
		for(Tile ti:tile) {
			ti.tick();
			
		}

		
	}
	
	public void addEntity(Entity en) {
		entity.add(en);
		
	}
	public void removeEntity(Entity en) {
		entity.remove(en);
	}
	
	public void addTile(Tile ti) {
		tile.add(ti);
		
	}
	public void removeTile(Tile ti) {
		tile.remove(ti);
	}
	
	public void createLevel(BufferedImage level) {
		int width=level.getWidth();
		int height=level.getHeight();
		for(int y=0; y<height ; y++) {
			
			for(int x=0; x<width ; x++) {
				int pixel=level.getRGB(x, y);
				int red=(pixel >> 16) & 0xff;
				int green=(pixel >> 8) & 0xff;
				int blue=(pixel) & 0xff;
				
				if(red==0 && green==0 && blue==0)
				{	addTile(new Wall(x*64,y*64,64,64,true,Id.wall,this));}
				if(red==0 && green==0 && blue==255)
					{addEntity(new Player(x*64,y*64,64,64,false,Id.player,this));}
				if(red==255 && green==250 && blue==0) {
					addTile(new Coin(x*64,y*64,64,64,true,Id.coin,this));
				
				if(red==255 && green==0 && blue==0) {
					addEntity(new Mushroom(x*64,y*64,64,64,true,Id.mushroom,this));
				}
				if(red==255 && green==127 && blue==39) {
					addEntity(new Goomba(x*64,y*64,64,64,true,Id.goomba,this));
				}
				}
				if(red==0 && green==255 && blue==0) {
					addTile(new Princess(x*64,y*64,64,64,true,Id.princess,this));
				
				}
			}
		}
	
}
}