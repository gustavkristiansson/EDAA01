package ext20190318;

public class Squares {
	
	
	public void squares(int order, int x, int y, int side) {
		recSquares(order, x, y, side, true);
	}
	
	private void recSquares(int order, int x, int y, int side, boolean filled) {
		if(order == 0) {
			drawSquare(x, y, side, filled);
		} else {
			recSquares(order - 1, x , y, side / 2, false);
			recSquares(order - 1, x + side / 2, y, side / 2, true);
			recSquares(order - 1, x, y + side / 2, side / 2, true);
			recSquares(order - 1, x + side / 2, y + side / 2, side / 2, false);
		}
	}
	
	public void drawSquare(int x, int y, int side, boolean filled) {
		
	}
	

}
