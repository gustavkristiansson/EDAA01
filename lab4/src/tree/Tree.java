package tree;

import fractal.*;
import fractal.TurtleGraphics;

public class Tree extends Fractal{
	private int length;
	private double alpha1 = Math.PI / 4, alpha2 = Math.PI / 4;
	
	public Tree(int length) {
		super();
		this.length = length;
	}
	
	@Override
	public String getTitle() {
		return "Tree fractal";
	}

	@Override
	public void draw(TurtleGraphics g) {
		g.moveTo(g.getWidth() - length,
				g.getHeight());
		fractalLine(g, order, length, 90);
		//fractalLine(g, order, length, 45);
	}
	
	private void fractalLine(TurtleGraphics turtle, int order, double length, int alpha) {
		if(order == 0) {
			//turtle.forwardTo(300, 600);
			turtle.penDown();
			turtle.setDirection(alpha);
			turtle.forward(length);
		} else {
			double x = turtle.getX();
			double y = turtle.getY();
			turtle.moveTo(x, y);
			fractalLine(turtle, order - 1, length / 2, alpha+45);
			fractalLine(turtle, order - 1, length / 2, alpha-45);
			//turtle.setDirection(alpha2);
		}
	}

}
