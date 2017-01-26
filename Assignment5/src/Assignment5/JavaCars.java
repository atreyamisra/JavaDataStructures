//Name: Atreya Misra
//UTEID: Am73676
package Assignment5;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.Color;
public class JavaCars extends Applet {
	protected ArrayList<CarObject> cars = new ArrayList<CarObject>();
	public void init(){
		Color burntOrange = new Color(191, 87, 0);
		Integer i = 1;
		for(i = 1; i<6; i++){
			cars.add(new CarObject(0, 50*(i-1), burntOrange, i.toString()));
		}
	} 
	public void paint(Graphics g){
		Graphics2D drawing = (Graphics2D)g;
		StopWatch timer = new StopWatch();
	    timer.start();
		 for(int i=0; i<5; i++){
			 cars.get(i).drawCar(g, i + 1);
			 }
		 timer.stop();
		 long initialization = timer.getElapsedTime();
		 timer.start();
		 for(int i=0; i<5; i++){
			 cars.get(i).updateX();
			 }
		 try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 int x = 0;
		 int finisher = 0;
		 for(int i=0; i<5; i++){
			 Point2D.Double r1 = cars.get(i).getR1();
			 if(r1.x > 770){
				 x = 1;
				 finisher = i + 1;
				 break;
			 }				 
		 }
		 if(x == 0)
			 repaint();
		 if(x==1){
			 timer.stop();
			 long travelTime = timer.getElapsedTime();
			 cars.get(finisher).finished(g, finisher, initialization, travelTime);
		 }
	 }
	
}

