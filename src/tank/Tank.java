package tank;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.util.Constant;
import game.util.Util;
public class Tank extends Bullet {
	boolean left,right,up,down;
	public boolean fire=false;
	boolean fristDirection1=true;
	boolean live=true;
	String Tank_path=null;
	//int direction=2;
	int num;
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
	public int Direction(){
		if(Tank_path=="images/enemy1U.gif"||Tank_path=="images/enemy2U.gif"){
			return 2;
		}else if(Tank_path=="images/enemy1L.gif"||Tank_path=="images/enemy2L.gif"){
			return 0;
		}else if(Tank_path=="images/enemy1R.gif"||Tank_path=="images/enemy2R.gif"){
		 return 1;
		}else if(Tank_path=="images/enemy1D.gif"||Tank_path=="images/enemy2D.gif"){
			return 3;
		}
		return 2;
	}
	public Tank(int Tank_x,int Tank_y,String Tank_path){    //¹¹Ôìº¯Êý
		super();
		this.x=Tank_x;
		this.y=Tank_y;
		this.img=Util.getImage(Tank_path);
		this.width=Constant.TANK_WINTH;
		this.height=Constant.TANK_HEIGHT;
		this.speed=Constant.TANK_SPEED;
		// TODO Auto-generated constructor stub
	}
	public void Move(){
		if(x<Constant.Location_x){
			x=Constant.Location_x;
		}
		if(x>Constant.Location_x+Constant.GAME_WIDTH-Constant.TANK_WINTH){
			x=Constant.Location_x+Constant.GAME_WIDTH-Constant.TANK_WINTH;
		}
	   if(y<Constant.Location_x){
		   y=Constant.Location_y;
	   }
	   if(y>Constant.Location_y+Constant.GAME_HEIGHT-Constant.TANK_HEIGHT){
		   y=Constant.Location_y+Constant.GAME_HEIGHT-Constant.TANK_HEIGHT;
		}
	}
	
}
	
