package tank;

import game.util.Util;

public class Wall extends GameObject{
	public String wallPath=null;
	public Wall(double x,double y,String wallPath) {
		super();
		this.x=x;
		this.y=y;
		this.height=40;
		this.width=40;
		this.wallPath=wallPath;
		this.img=Util.getImage(wallPath);
	}
	
}
