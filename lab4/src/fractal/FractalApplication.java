package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;
import tree.Tree;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[3];
		fractals[0] = new Tree(300);
		fractals[1] = new Koch(300);
		fractals[2] = new Mountain(new Point(50, 450), new Point(240, 120), new Point(450, 470), 50);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
