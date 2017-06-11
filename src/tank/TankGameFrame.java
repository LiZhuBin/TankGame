package tank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import game.util.Constant;
import game.util.MyFrame;
import game.util.Util;
public class TankGameFrame extends MyFrame	{
	static long gameTime =0;
	int bulletNum=0;
	boolean drawTime=true;
	long startTime=0;
	boolean flag=true;
	String time=null;
	String nowTime=null;
	Image bg=Util.getImage("images/bg.jpg");      
	Tank p=new Tank_1((Constant.BORDER_x2-Constant.BORDER_x1)/2,(Constant.BORDER_y2-Constant.BORDER_y1)/10,"tankImages1",1);
	Tank p1=new Tank_2((Constant.BORDER_x2-Constant.BORDER_x1)/2,(Constant.BORDER_y2-Constant.BORDER_y1)/10*9,"tankImages2",2);
	Bullet b=new Bullet("bullets/bullet1.gif");
	Bullet b1=new Bullet("bullets/bullet2.gif");
	static ArrayList<Wall> walls = new ArrayList<>();
	static ArrayList<Bullet> bullets = new ArrayList<>();
	public void paint(Graphics g) {
		g.drawImage(bg,0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		drawPoint(g,p,walls);
		drawPoint(g,p1,walls);
      if(p.getRect().intersects(p1.getRect())){  //�ж�̹�˼��Ƿ���ײ
    	  p.flag1=true;
    	  p1.flag1=true;
		}
		JudgePeng(p,b1,walls);
		JudgePeng(p1,b,walls);
			DrawWord(g,"̹��1���̷�����ƶ���SPACE���ڣ�",40, 50,100,Color.RED);
			DrawWord(g,"̹��2����A S W D���ƶ���F���ڣ�",40, 50,150,Color.RED);
	}
	public void drawPoint(Graphics g,Tank t,ArrayList<Wall> walls){   //�����������ʱ��
		if(t.live){
			drawAll(g,t,walls);
			}else{
				t.Blast(g);
				DrawWord(g,"̹��"+t.num+"Ӯ��!",100,200,400,Color.BLUE);
				if(drawTime){
					time=nowTime;
				drawTime=false;
				}
				DrawWord(g,"ʱ��"+time+"��",80,300,500,Color.RED);
			}
	}
	public void drawAll(Graphics g,Tank t,ArrayList<Wall> walls){   //�� ̹�ˡ��ӵ���ǽ
		Long time=new Date().getTime();
		 nowTime=Long.toString((time-startTime)/1000);
		DrawWord(g,nowTime+"��",40,50,200,Color.RED);
		for(int i=0;i<walls.size();i++){                     //����ǽ
			if(t.getRect().intersects(walls.get(i).getRect())){
				t.flag1=true;
			}
			if(walls.get(i).live==true){
			walls.get(i).draw(g);
			}
			if(walls.get(i).live==false){
				walls.remove(walls.get(i));
			}
			
		}
		t.draw(g);
		if(t.fire){
			if(b.x<Constant.BORDER_x1||b.x>Constant.BORDER_x2||b.y<Constant.BORDER_y1||b.y>Constant.BORDER_y2)	{//�ӵ���ǽ����̹��λ��
	    			b.x=t.x+15;
	    			b.y=t.y+10;
	    			b.direction=t.direction;
	    		}
			if(!b.live){                //�ӵ�����͸ʱ����̹��λ�ã��ػ�
				b.direction=t.direction;
				b.x=t.x+15;
    			b.y=t.y+10;
				b.live=true;
				t.fire=false;
				b.draw(g,t);
			}
			b.draw(g,t);
        	bulletNum++;
		}
	}
	public void JudgePeng(Tank t,Bullet b2,ArrayList<Wall> walls){       //�ж�̹��-ǽ���ӵ�-̹�ˡ��ӵ�-ǽ�Ƿ���ײ
		if(t.getRect().intersects(b2.getRect()))
		{
			t.live=false;
			b2.live=false;
				t.fire=false;
		}
		for(int i=0;i<walls.size();i++){
		if(b.getRect().intersects(walls.get(i).getRect())){
			if(walls.get(i).wallPath=="walls/softwall.gif"){         //�ӵ�����ǽ--��͸��ǽ��ʧ
			walls.get(i).live=false;
			}else{                                        //�ӵ���Ӳǽ--�޷���͸��ǽ����ʧ
				b2.live=false;
				b2.stop=true;
			}
		}
		if(walls.get(i).live==false){
				walls.remove(walls.get(i));
		}
		for(int j=i+1;j<walls.size();j++){
			if(walls.get(i).getRect().intersects(walls.get(j).getRect())){
				walls.get(i).live=false;
				walls.get(j).live=false;
			}
		}
		}
	}
	public void DrawWord(Graphics g,String str,int size,int x,int y,Color color){//����
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("����",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	public static void main(String[] args) throws Exception{
		for(int i=0;i<20;i++){          //��ʼǽ
			if(i%5==1){
				Wall w =new Wall(i*40,i*40,"walls/hardwall.gif");
				Wall w2 =new Wall(Constant.BORDER_x2-i*40,i*40,"walls/hardwall.gif");
				walls.add(w);
				walls.add(w2);
			}else{
			Wall w=new Wall(i*40,i*40,"walls/softwall.gif");
			Wall w2 =new Wall(Constant.BORDER_x2-i*40,i*40,"walls/softwall.gif");
			walls.add(w);
			walls.add(w2);
			}
		}
		new TankGameFrame().launchFrame();
	}
	public void launchFrame(){
		startTime=new Date().getTime();
		super.launchFrame();
		addKeyListener((KeyMonitor)p);//��̹�����Ӽ���Ч��
		addKeyListener((KeyMonitor)p1);
	}
}
