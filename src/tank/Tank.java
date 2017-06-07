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
	double old_x,old_y;
	int num=0;
	String TankPackagePath=null;
	public void draw(Graphics g){//»­Ì¹
		super.draw(g);
		Move();
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public Tank(int Tank_x,int Tank_y,String TankPackagePath,int modelNum){    //¹¹Ôìº¯Êý
		super();
		this.x=Tank_x;
		this.y=Tank_y;
	this.TankPackagePath=TankPackagePath;
		Tank_path=TankPackagePath+"/enemyU.gif";
		this.img=Util.getImage(Tank_path);
	//	this.modelNum=modelNum;
		this.width=Constant.TANK_WINTH;
		this.height=Constant.TANK_HEIGHT;
		this.speed=Constant.TANK_SPEED;
		// TODO Auto-generated constructor stub
	}
	public void Move(){
		if(x<Constant.BORDER_x1||x>Constant.BORDER_x2){
			x=old_x;
		}
		if(y<Constant.BORDER_y1||y>Constant.BORDER_y2){
			y=old_y;
		}
		old_x=x;
		old_y=y;
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
	
