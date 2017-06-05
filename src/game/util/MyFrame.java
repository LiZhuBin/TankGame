package game.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	/**
	 * 加载窗口
	 */
	public void launchFrame(){//加载我的窗口
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//定义窗口长宽
		setLocation(Constant.Location_x,Constant.Location_y);//设置窗口位置
		setVisible(true);//设置窗口可见，因为默认是不可见的
		
		new PaintThread().start();//启动重画线程
		
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {//重写一个方法
				System.exit(0);
			}//关窗口
			
		});
	}
	//消除闪烁
		private Image offScreenImage =null;
		public void update(Graphics g){
			if(offScreenImage==null)
				offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_WIDTH);
			 Graphics gOff=offScreenImage.getGraphics();
			 paint(gOff);
			  	g.drawImage(offScreenImage,0,0, null);
		}
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
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
				}//40毫秒
			}
		}
	}
}
