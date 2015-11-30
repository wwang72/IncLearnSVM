package lib.SimplifiedSMO;

public class SVMData {
	private double x[][];
	private int y[];
	
	public SVMData(double[][] x, int[] y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double[][] getX() {
		return x;
	}

	public void setX(double[][] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}
	
	
	
}
