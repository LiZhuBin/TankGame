package game.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	/**
	 * ���ش���
	 */
	public void launchFrame(){//�����ҵĴ���
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//���崰�ڳ���
		setLocation(Constant.Location_x,Constant.Location_y);//���ô���λ��
		setVisible(true);//���ô��ڿɼ�����ΪĬ���ǲ��ɼ���
		
		new PaintThread().start();//�����ػ��߳�
		
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {//��дһ������
				System.exit(0);
			}//�ش���
			
		});
	}
	//������˸
		private Image offScreenImage =null;
		public void update(Graphics g){
			if(offScreenImage==null)
				offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_WIDTH);
			 Graphics gOff=offScreenImage.getGraphics();
			 paint(gOff);
			  	g.drawImage(offScreenImage,0,0, null);
		}
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 * @author 10619
	 *
	 */
	class PaintThread extends Thread{
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//40����
			}
		}
	}
}
