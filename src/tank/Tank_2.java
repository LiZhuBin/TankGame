package tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.util.Util;

public class Tank_2 extends Tank{
	public Tank_2(int Tank_x, int Tank_y, String TankPackagePath, int modelNum) {
		super(Tank_x, Tank_y, TankPackagePath, modelNum);
		this.num=2;
		// TODO Auto-generated constructor stub
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
					this.fire=true;
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
