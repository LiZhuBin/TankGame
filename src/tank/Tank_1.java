package tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.util.Util;

public class Tank_1 extends Tank{
	
		public Tank_1(int Tank_x, int Tank_y, String TankPackagePath, int modelNum) {
		super(Tank_x, Tank_y, TankPackagePath, modelNum);
		// TODO Auto-generated constructor stub
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
