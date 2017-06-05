package tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.util.Util;

public class Tank_1 extends Tank{
	
	public Tank_1(int Tank_x, int Tank_y, String Tank_path) {
		super(Tank_x, Tank_y, Tank_path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		// TODO Auto-generated method stub
		super.Move();
		if(left){
			x-=speed;
		Tank_path="images/enemy1L.gif";
		img=Util.getImage(Tank_path);
		}
		if(right){
			x+=speed;
		Tank_path="images/enemy1R.gif";
		img=Util.getImage(Tank_path);
		}
		if(up){
			y-=speed;
			Tank_path="images/enemy1U.gif";
			img=Util.getImage(Tank_path);
		}
		if(down){
			y+=speed;
			Tank_path="images/enemy1D.gif";
			img=Util.getImage(Tank_path);
		}
		
	}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					left=true;
					break;
				case KeyEvent.VK_DOWN:
					down=true;
					break;
				case KeyEvent.VK_RIGHT:
					right=true;
					break;
				case KeyEvent.VK_UP:
					up=true;
					break;
				case KeyEvent.VK_SPACE:
					this.fire=true;
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				left=false;
				break;
			case KeyEvent.VK_DOWN:
				down=false;
				break;
			case KeyEvent.VK_RIGHT:
				right=false;
				break;
			case KeyEvent.VK_UP:
				up=false;
				break;
			
		}
		}
	
		
	}
