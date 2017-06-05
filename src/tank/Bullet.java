package tank;

import java.awt.Graphics;

import game.util.Constant;
import game.util.Util;

public class Bullet extends GameObject {
	double degree;
	boolean flag=true;
	int direction=2;

	public Bullet() {
		this.img=Util.getImage(Constant.BULLET_PATH);
		this.height=Constant.BULLET_HEIGHT;
		this.width=Constant.BULLET_WINTH;
		this.speed=Constant.BULLET_SPEED;
		
	}
	public void draw(Tank a,Graphics g){
		if(flag){ 
			this.x=a.x+Constant.TANK_WINTH/2-10;
			this.y=a.y+Constant.TANK_HEIGHT/2-10;
			this.direction=a.direction;
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