package tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import game.util.Constant;
import game.util.MyFrame;
import game.util.Util;
import tank.Tank.Bullet;
public class TankGameFrame extends MyFrame{
	Image bg=Util.getImage("images/bg.jpg");
	Tank p=new Tank_1(600,400,"images/enemy1U.gif");
	Tank p1=new Tank_2(100,400,"images/enemy2U.gif");
	Tank.Bullet b=p.new Bullet("images/bullet.gif");
	Tank.Bullet b1=p.new Bullet("images/bullet.gif");
	ArrayList<Bullet> bullets = new ArrayList<>();
	public void paint(Graphics g) {
		for(int i=0;i<100;i++){
			Tank.Bullet b1=p.new Bullet("images/bullet.gif");
			bullets.add(b1);
	}
		g.drawImage(bg,0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		p.draw(g);
		p1.draw(g);
		if(p.fire){
			p.direction=p.Direction();
        	b.draw(g);
		}
		if(p1.fire){
        	b1.draw(g);
        	p1.direction=p.Direction();
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
