package tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject extends KeyMonitor{
	public double x,y;
	 int width,height;
	 int speed=10;
	 boolean live=true;
	  Image img=null;
	  String direction="up";
	  public Rectangle getRect(){
			return new Rectangle((int)x,(int)y,width,height);		
		}
	  public void draw(Graphics g){//»­Ì¹
			if(true){
			g.drawImage(img,(int)x,(int)y,width,height, null);
	
			}
		}
}
