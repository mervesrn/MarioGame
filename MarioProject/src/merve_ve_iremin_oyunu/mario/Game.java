
/*
 Name: Merve ÞÝRÝN Id:201626404
 Name: Ýrem ÞAHÝNGÖZ Id:201611051
 */

package merve_ve_iremin_oyunu.mario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import merve_ve_iremin_oyunu.entity.Entity;
import merve_ve_iremin_oyunu.entity.powerup.Mushroom;
import merve_ve_iremin_oyunu.mario.gfx.Sprite;
import merve_ve_iremin_oyunu.mario.gfx.SpriteSheet;
import merve_ve_iremin_oyunu.mario.input.KeyInput;
import merve_ve_iremin_oyunu.mob.Goomba;

import java.awt.Canvas;
import java.awt.Color;


public class Game extends Canvas implements Runnable {

	public static final int WIDTH=270;
	public static final int  HEIGHT =WIDTH/14*10;
	public static final int SCALE=4;
	public static final String TITLE="Mario";
	private boolean running =false;
	private BufferedImage image;
	
	public static int coins=0;
	
	public static Handler handler;
	private Thread thread;
	public static SpriteSheet sheet;
	
	public static Sprite grass;
	
	public static Sprite mushroom;
	
	public static Sprite coin;
	public static Sprite goomba;
	
	public static Sprite player;
	public static Camera cam;
	public static Sprite princess;
	
	public Game() {
		Dimension size=new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);	
	}
	
	private void init() {
		handler=new Handler();
		
		addKeyListener(new KeyInput());
		sheet=new SpriteSheet("/spritesheet.png");
		grass=new Sprite(sheet,2,1);
		player=new Sprite(sheet,6,1);
		coin= new Sprite(sheet,3,1);
		mushroom= new Sprite(sheet,4,1);
		goomba=new Sprite(sheet,5,1);
		princess=new Sprite(sheet,7,1);
	
		handler.addEntity(new Mushroom(500,512,64,64,true,Id.mushroom,handler));
		
		handler.addEntity(new Goomba(300,512,64,64,true,Id.goomba,handler));	

		handler.addEntity(new Mushroom(900,512,64,64,true,Id.mushroom,handler));
		
		handler.addEntity(new Goomba(930,512,64,64,true,Id.goomba,handler));
		
		handler.addEntity(new Mushroom(1400,512,64,64,true,Id.mushroom,handler));
		
		handler.addEntity(new Goomba(1300,512,64,64,true,Id.goomba,handler));
		
		cam=new Camera();
		
		try {
			image=ImageIO.read(getClass().getResource("/level.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		handler.createLevel(image);
	}
	private synchronized void start() {
		if(running) return;
		running=true;
		thread=new Thread(this,"Thread");
		thread.start();
	
	}
	
	private synchronized void stop() {
		if(!running) return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		init();
		requestFocus();
		long lastTime=System.nanoTime();
		long timer=System.currentTimeMillis();
		double delta=0.0;
		double ns=1000000000.0/60.0;
		int frames=0;
		int ticks=0;
		
		
		while(running) {
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			while(delta>=1) {
				tick();
				ticks++;
				delta--;
				
			}
			
			
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				System.out.println(frames + "Frames Per Second" + ticks + "Updates Per Second");
				frames=0;
				ticks=0;
				
			}
			
		}
		stop();
		
	}
	public void render() {
		
		BufferStrategy bs=getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(3);
			return;	
		}
		
		Graphics g=bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0 , getWidth(), getHeight());
		g.drawImage(Game.coin.getBufferedImage(), 20, 20, 75, 75, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier",Font.BOLD,20));
		g.drawString("x"+ coins , 110, 95);
		g.translate(cam.getX(), cam.getY());
		handler.render(g);
		
		g.dispose();
		
		bs.show();
		
	}
	public void tick() {
		handler.tick();
		for(Entity e: handler.entity) {
			if(e.getId()==Id.player) {
				cam.tick(e);
			}
		}
	}
	
public int getFrameWidth() {
		
		return WIDTH*SCALE;
	}

public int getFrameHeight() {
		
		return HEIGHT*SCALE;
	}
	
	
	public static void main(String[] args) {
		Game game=new Game();
		
		JFrame frame=new JFrame(TITLE);
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
		
	}


	
}

