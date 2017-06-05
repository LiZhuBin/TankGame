package tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import game.util.Constant;
import game.util.MyFrame;
import game.util.Util;
public class TankGameFrame extends MyFrame{
	boolean fristDirection1=true;
	boolean fristDirection2=true;
	int i=0;
	Image bg=Util.getImage("images/bg.jpg");
	Tank p=new Tank_1(600,400,"images/enemy1U.gif");
	Tank p1=new Tank_2(100,400,"images/enemy2U.gif");
	ArrayList<Bullet> bullets = new ArrayList<>();
	public void paint(Graphics g) {
		Bullet b=new Bullet();
			bullets.add(b);
		g.drawImage(bg,0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		p.draw(g);
		p1.draw(g);
		if(p.fire){
			if(fristDirection1){
			p.direction=p.Direction();
			fristDirection1=false;
			}
        	b.draw(p,g);
		}
		if(p1.fire){
			if(fristDirection2){
        	bullets.get(i).draw(p1,g);
        	i++;
        	p1.direction=p.Direction();
        	fristDirection1=false;
			}
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
