package tank;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.util.Constant;
import game.util.Util;
public class Tank extends GameObject {
	boolean left,right,up,down;
	public boolean fire=false;
	boolean fristDirection1=true;
	boolean live=true;
	String Tank_path="images/enemy1U.gif";
	//int direction=2;
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,width,height);		
	}
	public void draw(Graphics g){//»­Ì¹
		if(true){
		g.drawImage(img,(int)x,(int)y,width,height, null);
		Move();
		}

	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int Direction(){
		if(Tank_path=="images/enemy1L.gif"){
			return 0;
		}else if(Tank_path=="images/enemy1R.gif"){
		 return 1;
		}else if(Tank_path=="images/enemy1D.gif"){
			return 3;
		}
		return 2;
	}
	public Tank(int Tank_x,int Tank_y,String Tank_path){
		super();
		this.x=Tank_x;
		this.y=Tank_y;
		this.img=Util.getImage(Tank_path);
		this.width=Constant.TANK_WINTH;
		this.height=Constant.TANK_HEIGHT;
		this.speed=Constant.TANK_SPEED;
		// TODO Auto-generated constructor stub
	}
	public void Move(){}
	public static void main(String[] args) {
	}
	
}
	
