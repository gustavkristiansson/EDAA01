package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Point[] points = new Point[] {new Point(50, 500), new Point(250, 100), new Point(450, 500)};
		Fractal[] fractals = new Fractal[2];
		fractals[1] = new Koch(300);
		fractals[0] = new Mountain(points);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
