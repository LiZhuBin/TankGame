package tank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import game.util.Constant;
import game.util.MyFrame;
import game.util.Util;
public class TankGameFrame extends MyFrame	{
	boolean fristDirection1=true;
	long startTime=0,endTime =0;
	int bulletNum=0;
	long time=0;
	boolean peng=false;
	Image bg=Util.getImage("images/bg.jpg");
	Tank p=new Tank_1(600,400,"images/enemy1U.gif");
	Tank p1=new Tank_2(100,400,"images/enemy2U.gif");
	Bullet b=new Bullet();
	Bullet b1=new Bullet();
	ArrayList<Bullet> bullets = new ArrayList<>();
	public void paint(Graphics g) {
		g.drawImage(bg,0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		if(p.live){
		drawAll(g,p);
		}else{
			DrawWord(g,"GAME OVER",50,100,100,Color.BLUE);
		}
		if(p1.live){
		drawAll(g,p1);
		}else{
			DrawWord(g,"赢了!",50, 100,100,Color.BLUE);
		}
		if(p.getRect().intersects(b1.getRect()))
		{
			boolean peng=true;
			if(peng){
			p.setLive(false);
		}
		}if(p1.getRect().intersects(b.getRect())){
			{
				boolean peng=true;
				if(peng){
				p1.setLive(false);
			}
		}
		}
	}
	public void drawAll(Graphics g,Tank p){   //画一 坦克
		p.draw(g);
		if(p.fire){
			
			bullets.add(new Bullet());
			if(fristDirection1){
				bullets.get(bulletNum).direction=p.Direction();
			fristDirection1=false;
			}
			if(p.live){
				if(p.num==1){
        	b.draw(g,p);
				}
				if(p.num==2){
					b1.draw(g,p);
				}
			}
        	//
        	bulletNum++;
		}
		//b.flag=true;
		
	}
	public void DrawWord(Graphics g,String str,int size,int x,int y,Color color){
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
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
