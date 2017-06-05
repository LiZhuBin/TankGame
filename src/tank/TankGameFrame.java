package tank;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import game.util.Constant;
import game.util.MyFrame;
import game.util.Util;
public class TankGameFrame extends MyFrame	{
	boolean fristDirection1=true;
	boolean fristDirection2=true;
	int bulletNum=0;
	Image bg=Util.getImage("images/bg.jpg");
	Tank p=new Tank_1(600,400,"images/enemy1U.gif");
	Tank p1=new Tank_2(100,400,"images/enemy2U.gif");
	Bullet b=new Bullet();
	Bullet b1=new Bullet();
	
	
	public void paint(Graphics g) {
	
		g.drawImage(bg,0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		drawAll(g,p);
		drawAll(g,p1);
	}
	public void drawAll(Graphics g,Tank p){
		p.draw(g);
		
			
				
		if(p.fire){
			ArrayList<Bullet> bullets = new ArrayList<>();
			bullets.add(new Bullet());
			if(fristDirection1){
				bullets.get(bulletNum).direction=p.Direction();
			fristDirection1=false;
			}
        	b.draw(g,p);
        	bulletNum++;
		}
	}
	public static void main(String[] args) throws Exception{
		new TankGameFrame().launchFrame();
	}
	public void launchFrame(){
		super.launchFrame();
		addKeyListener((KeyMonitor)p);
		addKeyListener((KeyMonitor)p1);
		
	}
	
}
