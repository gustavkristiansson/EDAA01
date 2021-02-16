package mountain;

import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal{
	private Point a;
	private Point b;
	private Point c;
	private double dev;
	private HashMap<Side, Point> sideMap = new HashMap<>();
	//private double random = RandomUtilities.randFunc(dev);
	private double random = 0;
	
	public Mountain(Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
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
		
		if(order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.penDown();
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		} else {
			random = (int)RandomUtilities.randFunc(dev);
			Point mLeft = midPoint(a, b);
			Point mBottom = midPoint(a, c);
			Point mRight = midPoint(b, c);
			
			//Lower left
			fractalTriangle(turtle, order - 1, a, mLeft, mBottom, dev/2);
			
			//Top triangle
			fractalTriangle(turtle, order - 1, mLeft, b, mRight, dev/2);
			
			//Lower right
			fractalTriangle(turtle, order - 1, mBottom, mRight, c, dev/2);
			
			//Middle
			fractalTriangle(turtle, order - 1, mRight, mBottom, mLeft, dev/2);
		}
	}
	
	private Point midPoint(Point a, Point b) {
		Side newSide = new Side(a, b);
		if(sideMap.containsKey(newSide)) {
			Point point = sideMap.get(newSide);
			sideMap.remove(newSide);
			return point;
		} else {
			int x = a.getX() + (b.getX() - a.getX()) / 2; 
			//int x = (a.getX() + b.getX()) / 2;
			//int y = (int)(a.getY() + b.getY() + random) / 2;
			int y = (int)((a.getY() + (b.getY() - a.getY())/ 2) + random);
			Point nPoint = new Point(x, y);
			sideMap.put(newSide, nPoint);
			return nPoint;
		}
	}
}
