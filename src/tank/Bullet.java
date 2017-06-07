package tank;

import java.awt.Graphics;

import game.util.Constant;
import game.util.Util;

public class Bullet extends GameObject {
	 private boolean flag=true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Bullet() {
		this.img=Util.getImage(Constant.BULLET_PATH);
		this.height=Constant.BULLET_HEIGHT;
		this.width=Constant.BULLET_WINTH;
		this.speed=Constant.BULLET_SPEED;
		
	}
	public void draw(Graphics g,Tank a){
		
		if(flag){ 
			this.x=a.x+Constant.TANK_WINTH/2-10;
			this.y=a.y+Constant.TANK_HEIGHT/2-10;
			this.direction=a.direction;
		   this.setFlag(false);
		}
		if(direction=="left"){
			this.x-=speed;
		}else if(direction=="right"){
			this.x+=speed;
		}else if(direction=="up"){
		this.y-=speed;
		}else if(direction=="down"){
			this.y+=speed;
		}
		
				g.drawImage(img,(int)x,(int)y,null);
			if(this.y<0){
				a.fire=false;
			}
		
	}
	}
	