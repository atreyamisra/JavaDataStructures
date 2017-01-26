package Assignment5;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.color.*;


public class CarObject {
	Graphics g = null;
	Rectangle body;
	Ellipse2D.Double frontTire;
	Ellipse2D.Double rearTire;
	Point2D.Double r1;
	Point2D.Double r2;
	Point2D.Double r3;
	Point2D.Double r4;
	Line2D.Double frontWindshield;
	Line2D.Double roofTop;
	Line2D.Double rearWindshield;
	Color burntOrange = new Color(191, 87, 0);
	Color black = new Color(0,0,0);
	
public Graphics getG() {
		return g;
	}


	public void setG(Graphics g) {
		this.g = g;
	}


	public Rectangle getBody() {
		return body;
	}


	public void setBody(Rectangle body) {
		this.body = body;
	}


	public Ellipse2D.Double getFrontTire() {
		return frontTire;
	}


	public void setFrontTire(Ellipse2D.Double frontTire) {
		this.frontTire = frontTire;
	}


	public Ellipse2D.Double getRearTire() {
		return rearTire;
	}


	public void setRearTire(Ellipse2D.Double rearTire) {
		this.rearTire = rearTire;
	}


	public Point2D.Double getR1() {
		return r1;
	}


	public void setR1(Point2D.Double r1) {
		this.r1 = r1;
	}


	public Point2D.Double getR2() {
		return r2;
	}


	public void setR2(Point2D.Double r2) {
		this.r2 = r2;
	}


	public Point2D.Double getR3() {
		return r3;
	}


	public void setR3(Point2D.Double r3) {
		this.r3 = r3;
	}


	public Point2D.Double getR4() {
		return r4;
	}


	public void setR4(Point2D.Double r4) {
		this.r4 = r4;
	}


	public Line2D.Double getFrontWindshield() {
		return frontWindshield;
	}


	public void setFrontWindshield(Line2D.Double frontWindshield) {
		this.frontWindshield = frontWindshield;
	}


	public Line2D.Double getRoofTop() {
		return roofTop;
	}


	public void setRoofTop(Line2D.Double roofTop) {
		this.roofTop = roofTop;
	}


	public Line2D.Double getRearWindshield() {
		return rearWindshield;
	}


	public void setRearWindshield(Line2D.Double rearWindshield) {
		this.rearWindshield = rearWindshield;
	}


public CarObject (int X, int Y, Color color, String carNumber){
	Graphics2D g2 = (Graphics2D)g;
	 // create the car body
	 body = new Rectangle(X + 10, Y + 20, 60, 10);
	 // create the car tires
	 frontTire = new Ellipse2D.Double(X + 20, Y + 30, 10, 10);
	 rearTire = new Ellipse2D.Double(X + 50, Y + 30, 10, 10);
	 // create the 4 points connecting the windshields and roof
	 r1 = new Point2D.Double(X + 20, Y + 20);
	 r2 = new Point2D.Double(X + 30, Y + 10);
	 r3 = new Point2D.Double(X + 50, Y + 10);
	 r4 = new Point2D.Double(X + 60, Y + 20);
	 // create the windshields and roof of the car
	 frontWindshield = new Line2D.Double(r1, r2);
	 roofTop = new Line2D.Double(r2, r3);
	 rearWindshield = new Line2D.Double(r3, r4);
	 

	 // draw all of the car parts on the screen

	}
public void drawCar(Graphics g, int i){
	 frontWindshield = new Line2D.Double(r1, r2);
	 roofTop = new Line2D.Double(r2, r3);
	 rearWindshield = new Line2D.Double(r3, r4);
	 Point2D.Double r5 = new Point2D.Double(80, 0);
	 Point2D.Double r6 = new Point2D.Double(80, 300);
	 Line2D.Double startLine = new Line2D.Double(r5, r6);
	 r5.x = 720;
	 r6.x = 720;
	 Line2D.Double finishLine = new Line2D.Double(r5, r6);
	Graphics2D g2 = (Graphics2D)g;
	g2.draw(body);
	g2.setColor(burntOrange);
	g2.fill(body);
	g2.draw(frontTire);
	g2.setColor(black);
	g2.fill(frontTire);
	g2.draw(rearTire);
	g2.fill(rearTire);
	g2.setColor(burntOrange);
	g2.draw(frontWindshield);
	g2.draw(roofTop);
	g2.draw(rearWindshield);
	g2.setColor(black);
	g2.draw(startLine);
	g2.draw(finishLine);
	if(i == 1)
		g2.drawString("1", (int) (r1.x + 5), 30);
	if(i == 2)
		g2.drawString("2", (int) (r1.x + 5), 80);
	if(i == 3)
		g2.drawString("3", (int) (r1.x + 5), 130);
	if(i == 4)
		g2.drawString("4", (int) (r1.x + 5), 180);
	if(i == 5)
		g2.drawString("5", (int) (r1.x + 5), 230);
}


public void updateX() {
	// TODO Auto-generated method stub
	int random = (int)(Math.random() * 100);
	body.x += random;
	frontTire.x += random;
	rearTire.x += random;
	r1.x += random;
	r2.x += random;
	r3.x += random;
	r4.x += random;
}
public void finished(Graphics g, int i, long initial, long travel){
	Graphics2D g2 = (Graphics2D)g;
	g2.drawString("Congrats to Car #" + i + " on winning!", 300, 300);
	g2.drawString("The initialization of the cars took " + initial + " millisecond and the race took " + travel + " milliseconds.", 0, 270);
}





}

