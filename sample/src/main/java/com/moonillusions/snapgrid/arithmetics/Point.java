package com.moonillusions.snapgrid.arithmetics;

public class Point {

	private final double x;
	private final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distance(Point point2) {
		double x1 = getX();
		double y1 = getY();
		double x2 = point2.getX();
		double y2 = point2.getY();
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

}
