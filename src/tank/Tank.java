package tank;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.util.Constant;
import game.util.Util;
public class Tank extends Bullet {
	boolean left,right,up,down;
	public boolean fire=false;
	boolean fristDirection1=true;
	String Tank_path=null;
	boolean flag1=false;
	int num=0;
	String TankPackagePath=null;
	public void draw(Graphics g){//画坦
		super.draw(g);
		Move();
		
	}
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public Tank(int Tank_x,int Tank_y,String TankPackagePath,int modelNum){    //构造函数
		super();
		this.x=Tank_x;
		this.y=Tank_y;
	this.TankPackagePath=TankPackagePath;
		Tank_path=TankPackagePath+"/enemyU.gif";
		this.img=Util.getImage(Tank_path);
		this.width=Constant.TANK_WINTH;
		this.height=Constant.TANK_HEIGHT;
		this.speed=Constant.TANK_SPEED;
	}
	public void Blast(Graphics g){
			for(int i=1;i<9;i++){
				g.drawImage(Util.getImage("blasts/blast"+i+".gif"),(int)x,(int)y,width,height, null);
			}
	}
	public void Move(){                     
		//如果在窗口边界或与物体碰撞，则返回原来位置--不穿透
		if(x<Constant.BORDER_x1||x>Constant.BORDER_x2||flag1){
			x=old_x;
		}
		if(y<Constant.BORDER_y1||y>Constant.BORDER_y2||flag1){
			y=old_y;
		}
		old_x=x;
		old_y=y;
		flag1=false;
		if(left){
			x-=speed;
		Tank_path=TankPackagePath+"/enemyL.gif";
		img=Util.getImage(Tank_path);
		direction="left";
		}
		if(right){
			x+=speed;
		Tank_path=TankPackagePath+"/enemyR.gif";
		img=Util.getImage(Tank_path);
		direction="right";
		}
		if(up){
			y-=speed;
			Tank_path=TankPackagePath+"/enemyU.gif";
			img=Util.getImage(Tank_path);
			direction="up";
		}
		if(down){
			y+=speed;
			Tank_path=TankPackagePath+"/enemyD.gif";
			img=Util.getImage(Tank_path);
			direction="down";
		}
	}
	
}
	
