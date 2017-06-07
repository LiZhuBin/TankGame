package tank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import game.util.Constant;
import game.util.MyFrame;
import game.util.Util;
public class TankGameFrame extends MyFrame	{
	boolean fristDirection1=true;
	long startTime=0,endTime =0;
	int bulletNum=0;
	long time=0;
	double old_x,old_y;
	Image bg=Util.getImage("images/bg.jpg");
	Tank p=new Tank_1(600,400,"tankImages1",1);
	Tank p1=new Tank_2(100,400,"tankImages2",2);
	Bullet b=new Bullet();
	Bullet b1=new Bullet();
	static ArrayList<Wall> walls = new ArrayList<>();
	static ArrayList<Bullet> bullets = new ArrayList<>();
	public void paint(Graphics g) {   
		g.drawImage(bg,0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		if(p.live){
		drawAll(g,p,b,walls);
		}else{
			p.Blast(g);
			DrawWord(g,"GAME OVER",100,400,400,Color.BLUE);
		}
		if(p1.live){
		drawAll(g,p1,b1,walls);
		}else{
			p1.Blast(g);
			DrawWord(g,"赢了!",100, 400,400,Color.BLUE);
		}
      if(p.getRect().intersects(p1.getRect())){
    	  p.flag1=true;
    	  p1.flag1=true;
		}
		JudgePeng(p,b1,walls);
		JudgePeng(p1,b,walls);
			DrawWord(g,"坦克1键盘方向键移动，SPACE发炮；",40, 50,100,Color.RED);
			DrawWord(g,"坦克2键盘A S W D键移动，F发炮；",40, 50,150,Color.RED);
			DrawWord(g,"每只坦克只限一发炮",40, 50,200,Color.RED);
	}
	public void drawAll(Graphics g,Tank t,Bullet b,ArrayList<Wall> walls){   //画 坦克、子弹、墙
		for(int i=0;i<walls.size();i++){                     //遍历墙
			//Wall w=(Wall)iterator.next();
			if(t.getRect().intersects(walls.get(i).getRect())){
				t.flag1=true;
			}
			if(walls.get(i).live==true){
			walls.get(i).draw(g);
			}
			if(walls.get(i).live==false){
				walls.remove(walls.get(i));
			}
			
		}
		t.draw(g);
		if(t.fire){
			bullets.add(new Bullet());
			if(fristDirection1){
				bullets.get(bulletNum).direction=t.direction;
			fristDirection1=false;
			}
			if(b.live){
				if(b.x<Constant.BORDER_x1||b.x>Constant.BORDER_x2)	{
	    			b.x=t.x;
	    		}
	    		if(b.y<Constant.BORDER_y1||b.y>Constant.BORDER_y2){	
	    		b.y=t.y;
	    		}
        	b.draw(g,t);
			}
        	bulletNum++;
		}
	}
	public void JudgePeng(Tank t,Bullet b,ArrayList<Wall> walls){       //判断坦克-墙、子弹-坦克、子弹-墙是否碰撞
		if(t.getRect().intersects(b.getRect()))
		{
			t.live=false;
			b.live=false;
		}
		for(int i=0;i<walls.size();i++){
		if(b.getRect().intersects(walls.get(i).getRect())){
			if(walls.get(i).wallPath=="walls/softwall.gif"){         //子弹击弱墙--穿透，墙消失
			walls.get(i).live=false;
			}else{                                        //子弹击硬墙--无法穿透、墙不消失
				b.live=false;
			}
		}
		if(walls.get(i).live==false){
				walls.remove(walls.get(i));
		}
		}
		
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
		for(int i=0;i<18;i++){          //初始墙
			if(i>7&&i<9){
				Wall w =new Wall(i*50,i*50,"walls/hardwall.gif");
				walls.add(w);
			}else{
			Wall w=new Wall(i*50,i*50,"walls/softwall.gif");
			walls.add(w);
			}
		}
		for(int i=0;i<100;i++){
			Bullet b=new Bullet();
			bullets.add(b);
		}
		new TankGameFrame().launchFrame();
	}
	public void launchFrame(){
		super.launchFrame();
		addKeyListener((KeyMonitor)p);
		addKeyListener((KeyMonitor)p1);
		
	}
	
}
