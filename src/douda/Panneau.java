package douda;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	int length=0;
	ArrayList<Point> listPoint=new ArrayList<Point>();
	private int x=0,y=0;
	private int xT,yT;
	private boolean random=true; 
	int oldX,oldY;
	boolean inside=false;
	
	 public void paintComponent(Graphics g) {
		    g.setColor(Color.white);
		    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		    if(xT*20==x && yT*20==y){
				   random=true;
		    }
		    if(random){
		    	for(int i=0;i<listPoint.size();i++){
		    		if(i==0)
		    			randomPoint();
		    		if(xT==listPoint.get(i).getX() && yT==listPoint.get(i).getY())
		    			inside=true;
				    	
				    if(i==listPoint.size()-1 && inside==true)
				    	if(xT!=x && yT!=y)
				    		i=0;
		    	}
		    	listPoint.add(new Point(xT,yT));
		    	inside=false;
		    	
		    }
		    
		    g.setColor(Color.red);		    
		    g.fillRect(x,y, 20, 20);
		    g.setColor(Color.black);
		    for(int i=listPoint.size()-1;i>=1;i--){
		    	listPoint.get(i).setX(listPoint.get(i-1).getX());
		    	listPoint.get(i).setY(listPoint.get(i-1).getY());

		    }
		    listPoint.get(0).setX(oldX);
	    	listPoint.get(0).setY(oldY);
	    	
		    for(Point p : listPoint)
			    g.fillRect(p.getX(),p.getY(),20, 20);

		   
		    
		    System.out.println(x+"??"+xT+" ======= "+y+" ?? "+yT);
			   g.setColor(Color.blue);
		   g.fillRect(xT*20, yT*20, 20,20);
		  /* for(int i=0;i<getWidth();i+=20)
			   for(int j=0;j<getWidth();j+=20)
				    g.drawRect(i, j, 20, 20);
*/
		   
		  
		    
}
	
	public int getPosX(){
		return x;
	}
	public int getPosY(){
		return y;
	}
	public void setPosX(int x){
		oldX=x;
	   this.x=x;
	}
	public void setPosY(int y){
	  oldY=y;
	  this.y=y;
	}
	
	public void randomPoint(){
		xT=(int)(Math.random()*19);
    	yT=(int)(Math.random()*17);
    	random=false;
	}

}
