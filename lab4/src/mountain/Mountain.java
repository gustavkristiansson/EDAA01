package mountain;

import fractal.*;

public class Mountain extends Fractal{
	private Point a;
	private Point b;
	private Point c;
	private double dev;
	
	
	public Mountain(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String getTitle() {
		return "Mountain fractal";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, a, b, c, dev);
	}
	
	private void fractalTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
		double rand1 = RandomUtilities.randFunc(dev);
		double rand2 = RandomUtilities.randFunc(dev);
		double rand3 = RandomUtilities.randFunc(dev);
		
		if(order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.penDown();
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		} else {
			Point mLeft = new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
			Point mRight = new Point((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2);
			Point mBottom = new Point((a.getX() + c.getX()) / 2, (a.getY() + c.getY()) / 2);
			
			//Toppentriangeln
			fractalTriangle(turtle, order - 1, mLeft, b, mRight, dev);
			
			//Mitten
			fractalTriangle(turtle, order - 1, mLeft, mRight, mBottom, dev);
			
			//Nedre vänster
			fractalTriangle(turtle, order - 1, a, mLeft, mBottom, dev);
			
			//Nedre höger
			fractalTriangle(turtle, order - 1, mBottom, mRight, c, dev);
		}
	}
	
	private class Triangle {
		private Point[] points;
	
		
		public Triangle(Point A, Point B, Point C) {
			this.points = new Point[] {points[0], points[1], points[2]};
		}
		
		public Point[] getPoints() {
			return points;
		}
		
	}

}
