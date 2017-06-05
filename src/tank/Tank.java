package tank;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.util.Constant;
import game.util.Util;
public class Tank extends GameObject {
	boolean left,right,up,down;
	static boolean fire=false;
	boolean live=true;
	String Tank_path=null;
	int direction=0;
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
		if(Tank_path=="images/enemy1R.gif"){
			return 1;
		}else if(Tank_path=="images/enemy1U.gif"){
		 return 2;
		}else if(Tank_path=="images/enemy1D.gif"){
			return 3;
		}
		return 0;
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
	class Bullet extends GameObject {

		double degree;
		boolean flag=true;
		public Bullet(String path) {
			this.img=Util.getImage(path);
			this.x=Tank.this.x+Constant.TANK_WINTH/2-20;
			this.y=Tank.this.y-30;
			this.height=Constant.BULLET_HEIGHT;
			this.width=Constant.BULLET_WINTH;
			this.speed=Constant.BULLET_SPEED;
		}
		public void draw(Graphics g){
			if(flag){ 
				this.x=Tank.this.x+Constant.TANK_WINTH/2-10;
				this.y=Tank.this.y+Constant.TANK_HEIGHT/2-10;
			   flag=false;
			}
			if(direction==0){
				this.x-=speed;
			}else if(direction==1){
				this.x+=speed;
			}else if(direction==2){
			this.y-=speed;
			}else if(direction==3){
				this.y+=speed;
			}
					g.drawImage(img,(int)x,(int)y,null);
		}
}
	
}
