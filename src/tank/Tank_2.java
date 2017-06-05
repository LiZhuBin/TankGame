package tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.util.Util;

public class Tank_2 extends Tank{

	public Tank_2(int Tank_x, int Tank_y, String Tank_path) {
		super(Tank_x, Tank_y, Tank_path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		// TODO Auto-generated method stub
		super.Move();
		if(left){
			x-=speed;
			
		Tank_path="images/enemy2L.gif";
		img=Util.getImage(Tank_path);
		}
		if(right){
			x+=speed;
		Tank_path="images/enemy2R.gif";
		img=Util.getImage(Tank_path);
		}
		if(up){
			y-=speed;
			Tank_path="images/enemy2U.gif";
			img=Util.getImage(Tank_path);
		}
		if(down){
			y+=speed;
			Tank_path="images/enemy2D.gif";
			img=Util.getImage(Tank_path);
		}
		
	}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
				switch(e.getKeyCode()){
				case KeyEvent.VK_A:
					left=true;
					break;
				case KeyEvent.VK_S:
					down=true;
					break;
				case KeyEvent.VK_D:
					right=true;
					break;
				case KeyEvent.VK_W:
					up=true;
					break;
				case KeyEvent.VK_F:
					fire=true;
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()){
			case KeyEvent.VK_A:
				left=false;
				break;
			case KeyEvent.VK_S:
				down=false;
				break;
			case KeyEvent.VK_D:
				right=false;
				break;
			case KeyEvent.VK_W:
				up=false;
				break;
		}
		}
		
		
	}
