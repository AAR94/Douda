package douda;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame{
	Panneau pan=new Panneau();
	JTextField j=new JTextField();
	boolean b=false;
	String direction="";
	boolean left,right,up,down;
	public Fenetre(){
		JPanel container=new JPanel();
		this.setSize(397,400);
		this.setTitle("Douda");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		j.addKeyListener(new ClavierListener());
		container.setLayout(new BorderLayout());
		container.add(pan,BorderLayout.CENTER);
		container.add(j,BorderLayout.SOUTH);
		this.setContentPane(container);
	}

	
	
	public class ClavierListener implements KeyListener{
		
		/*  public void keyPressed(KeyEvent event) {
		      System.out.println("Code touche pressée : " +
		event.getKeyCode() + " - caractère touche pressée : " +
		event.getKeyChar());
		    }
		    public void keyReleased(KeyEvent event) {
		      System.out.println("Code touche relâchée : " +
		event.getKeyCode() + " - caractère touche relâchée : " +
		event.getKeyChar());         
		    }
		    public void keyTyped(KeyEvent event) {
		      System.out.println("Code touche tapée : " + event.getKeyCode() 
		+ " - caractère touche tapée : " + event.getKeyChar());
		    } */
		    
		public void keyReleased(KeyEvent e){
			//System.out.println("hello");

		}
		
		public void keyPressed(KeyEvent e){
			if(e.getKeyChar()=='q' && direction!="left" && direction!="right"){			
				j.setText("Left");
				direction="left";
				Thread t=new Thread(new PlayAnimation());
				t.start();
				//moving();
			}
			else if(e.getKeyChar()=='d' && direction!="right" && direction!="left"){
				j.setText("Right");			
				direction="right";
				Thread t=new Thread(new PlayAnimation());
				t.start();

			}
			else if(e.getKeyChar()=='z' && direction!="up" && direction!="down"){
				j.setText("Up");
				direction="up";
				Thread t=new Thread(new PlayAnimation());
				t.start();
			}
			else if(e.getKeyChar()=='s' && direction!="down" && direction!="up" ){
				j.setText("Down");				
				direction="down";
				Thread t=new Thread(new PlayAnimation());
				t.start();			}
		}
		
		public void keyTyped(KeyEvent e){
			System.out.println(e.getKeyChar()+"");

		}
	}
	
	
	public void moving(){
		
		if(direction=="left"){
			up=false;
			right=false;
			down=false;
			left=true;
			while(left && pan.getPosX()>0){
				pan.setPosX(pan.getPosX()-20);
				pan.repaint();
				try{
					Thread.sleep(200);
				}catch(Exception e){}
			}
		}else if(direction=="right"){
			up=false;
			right=true;
			down=false;
			left=false;
			while(right && pan.getPosX()<360){
				pan.setPosX(pan.getPosX()+20);
				pan.repaint();
				try{
					Thread.sleep(200);
				}catch(Exception e){}
			}

		}else if(direction=="up"){
			right=false;
			left=false;
			down=false;
			up=true;
			while(up && pan.getPosY()>0){
				pan.setPosY(pan.getPosY()-20);
				pan.repaint();
				try{
					Thread.sleep(200);
				}catch(Exception e){}
			}			

		}else if(direction=="down"){
			up=false;
			right=false;
			left=false;
			down=true;
			while(down && pan.getPosY()<pan.getHeight()-25 ){
				pan.setPosY(pan.getPosY()+20);
			    pan.repaint();
				try{
					Thread.sleep(200);
				}catch(Exception e){}
			}
		}
	}
	public static void main(String[] args) {
		Fenetre f=new Fenetre();
		f.setVisible(true);
	}

	public class PlayAnimation implements Runnable{
		public void run(){
			moving();
		}
	}
		  
	
}
