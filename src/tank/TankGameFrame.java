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
	Image bg=Util.getImage("images/bg.jpg");
	Tank p=new Tank_1(600,400,"images/enemy1U.gif");
	Tank p1=new Tank_2(100,400,"images/enemy2U.gif");
	Wall w=new Wall(300,400,"walls/walls.gif");
	Bullet b=new Bullet();
	Bullet b1=new Bullet();
	ArrayList<Bullet> bullets = new ArrayList<>();
	public void paint(Graphics g) {
		g.drawImage(bg,0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		if(p.live){
		drawAll(g,p,b,w);
		}else{
			DrawWord(g,"GAME OVER",50,100,100,Color.BLUE);
		}
		if(p1.live){
		drawAll(g,p1,b1,w);
		}else{
			DrawWord(g,"Ӯ��!",50, 100,100,Color.BLUE);
		}
		JudgePeng(p,b1,w);
		JudgePeng(p1,b,w);
	}
	public void drawAll(Graphics g,Tank t,Bullet b,Wall w){   //��һ ̹��
		t.draw(g);
		if(t.fire){
			bullets.add(new Bullet());
			if(fristDirection1){
				bullets.get(bulletNum).direction=t.Direction();
			fristDirection1=false;
			}
			if(t.live){
        	b.draw(g,p);
			}
        	bulletNum++;
		}
		if(w.live){
			w.draw(g);
		}
	}
	public void JudgePeng(Tank t,Bullet b,Wall w){
		if(t.getRect().intersects(b.getRect()))
		{
			t.live=false;
		}
		if(b.getRect().intersects(w.getRect())){
			w.live=false;
		}
	}
	public void DrawWord(Graphics g,String str,int size,int x,int y,Color color){
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("����",Font.BOLD,size);
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
