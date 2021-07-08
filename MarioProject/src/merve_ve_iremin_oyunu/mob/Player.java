
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.mob;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;


import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextField;

import merve_ve_iremin_oyunu.entity.Entity;
import merve_ve_iremin_oyunu.mario.Game;
import merve_ve_iremin_oyunu.mario.Handler;
import merve_ve_iremin_oyunu.mario.Id;
import merve_ve_iremin_oyunu.tile.Tile;

public class Player extends Entity{

	public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Game.player.getBufferedImage(), x, y, width ,height,null );
		//deï¿½isecek
	}

	@SuppressWarnings("deprecation")
	public void tick() {
		x+=velX;
		y+=velY;
		if(x<=0) x=0;
		if(y<=0) y=0;
		if(x+width>=2500) x=2500-width;
		if(y+height>=2000) y=2000-height;
		
		for(int i=0;i<handler.tile.size();i++) {
			Tile t=handler.tile.get(i);
			if(!t.solid)
				break;

				if(getBoundsTop().intersects(t.getBounds()) && t.getId()!=Id.coin && t.getId()!=Id.princess) {
					setVelY(0);
					if(jumping) {
						jumping=false;
						gravity=0.8;
						falling=true;
					}
				}
				if(getBoundsBottom().intersects(t.getBounds()) && t.getId()!=Id.coin && t.getId()!=Id.princess) {
					setVelY(0);
					if(falling) 
					{
						falling=false;
					}
				}else if(!falling && !jumping) {
							gravity=0.8;
							falling=true;
				}
						
					
				
				if(getBoundsLeft().intersects(t.getBounds()) && t.getId()!=Id.coin && t.getId()!=Id.princess) {
					setVelY(0);
					x=t.getX()+t.width;
					System.out.println(getBoundsLeft());
				}
				if(getBoundsRight().intersects(t.getBounds()) && t.getId()!=Id.coin && t.getId()!=Id.princess) {
					setVelY(0);
					x=t.getX()-t.width;
					System.out.println(getBoundsRight());
				}
			
				if(getBounds().intersects(t.getBounds()) && t.getId()==Id.coin && t.getId()!=Id.princess) {
					Game.coins++;
					t.die();
				}
				if(getBounds().intersects(t.getBounds()) && t.getId()==Id.princess) {
					t.die();
					die();
					 int WIDTH=270;
						int  HEIGHT =WIDTH/14*10;
						int SCALE=4;
					JFrame frm=new JFrame();
					Dimension size=new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
					frm.setPreferredSize(size);
					frm.setMaximumSize(size);
					frm.setMinimumSize(size);	
					frm.setLayout(new BorderLayout());
					
					frm.setBackground(Color.PINK);
					JPanel p=new JPanel();
					
					JTextField text=new JTextField("YOU WIN --------THE HAPPY END----------");
					text.setEditable(false);
					text.setPreferredSize(size);
					text.setMaximumSize(size);
					text.setMinimumSize(size);
					

					text.setFont(new Font("Courier",Font.BOLD,36));
					text.setBackground(Color.MAGENTA);

					
					p.add(text, BorderLayout.WEST);
					
					frm.add(p, BorderLayout.CENTER);
					frm.pack();
					frm.setResizable(true);
					frm.setLocationRelativeTo(null);
					frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frm.setVisible(true);
				}
		
		}
		
		for(int i=0;i<handler.entity.size();i++) {
			Entity e = handler.entity.get(i);
	
			if(e.getId()==Id.mushroom) {
				if(getBounds().intersects(e.getBounds())) {
					int tpX=getX();
					int tpY=getY();
					width*=2;
					height*=2;
					setX(tpX-width);
					setY(tpY-height);
					e.die();
				}
			}
			else if(e.getId()==Id.goomba) {
				 int WIDTH=270;
				int  HEIGHT =WIDTH/14*10;
				int SCALE=4;
				
				if(getBounds().intersects(e.getBoundsTop())) {
					e.die();	
				}				
				else if(getBounds().intersects(e.getBounds())) {
					die();
					
	
					
					JFrame frm=new JFrame();
					Dimension size=new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
					frm.setPreferredSize(size);
					frm.setMaximumSize(size);
					frm.setMinimumSize(size);	
					frm.setLayout(new BorderLayout());
					
					frm.setBackground(Color.RED);
					JPanel p=new JPanel();
//					p.setSize(1080, (1080/14)*10);
					
					JTextField text=new JTextField("GAME OVER!!!");
					text.setEditable(false);
					text.setPreferredSize(size);
					text.setMaximumSize(size);
					text.setMinimumSize(size);
					
//					text.setCaretColor(Color.red);
					text.setFont(new Font("Courier",Font.BOLD,72));
					text.setBackground(Color.orange);
					text.setCaretColor(Color.CYAN);
					
					p.add(text, BorderLayout.WEST);
					frm.add(p, BorderLayout.CENTER);
					frm.pack();
					frm.setResizable(true);
					frm.setLocationRelativeTo(null);
					frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frm.setVisible(true);
				
		
					
				}
			}
		}
		
		if(jumping) {
			gravity-=0.1;
			setVelY((int)-gravity);
			if(gravity<=0.0)
			{
				jumping=false;
				falling=true;
			}
		}
		if(falling) {
			
			gravity+=0.1;
			setVelY((int)gravity);
	
		}
	}
	

}

