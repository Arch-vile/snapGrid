package com.moonillusions.snapgrid.arithmetics;

public class Vector {

	private final Point point;

	public Vector(Point point) {
		this.point = point;
	}

	public Vector(double x, double y) {
		this.point = new Point(x, y);
	}

	public double getX() {
		return this.point.getX();
	}

	public double getY() {
		return this.point.getY();
	}

	public Vector subtract(Vector subtract) {
		return new Vector(getX() - subtract.getX(), getY() - subtract.getY());
	}

	public Vector perpendicular() {
		return new Vector(-1 * getY(), getX());
	}

	public Vector unit() {
		return this.multiply(1d / this.magnitude());
	}

	public Double magnitude() {
		return Math.sqrt(getX() * getX() + getY() * getY());
	}

	public Vector multiply(double multiplier) {
		return new Vector(multiplier * getX(), multiplier * getY());
	}

	public Vector scale(double scale) {
		return this.unit().multiply(scale);
	}

	public Vector rotate(double degrees) {
		double radians = Math.toRadians(-1 * degrees);
		return new Vector(//
				getX() * Math.cos(radians) - getY() * Math.sin(radians), //
				getX() * Math.sin(radians) + getY() * Math.cos(radians));
	}

}
