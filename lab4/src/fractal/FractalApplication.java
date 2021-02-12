package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Point[] points = new Point[] {new Point(50, 450), new Point(240, 120), new Point(450, 470)};
		Fractal[] fractals = new Fractal[2];
		fractals[1] = new Koch(300);
		fractals[0] = new Mountain(points[0], points[1], points[2]);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
