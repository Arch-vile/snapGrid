package com.moonillusions.snapgrid.arithmetics;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VectorTest {

	@Test
	public void create_from_point() {
		Vector v = new Vector(new Point(100, 200));
		assertThat(v.getX(), equalTo(100d));
		assertThat(v.getY(), equalTo(200d));
	}

	@Test
	public void subtract() {
		Vector subtractFrom = new Vector(20, 30);
		Vector subtract = new Vector(11, 35);
		Vector result = subtractFrom.subtract(subtract);

		assertThat(result.getX(), equalTo(9d));
		assertThat(result.getY(), equalTo(-5d));
	}

	@Test
	public void add() {
		Vector addTo = new Vector(20, 30);
		Vector add = new Vector(11, 35);
		Vector result = addTo.add(add);

		assertThat(result.getX(), equalTo(31d));
		assertThat(result.getY(), equalTo(65d));
	}

	@Test
	public void perpendicular() {
		Vector perpendicular = new Vector(2, 3).perpendicular();
		assertThat(perpendicular.getX(), equalTo(-3d));
		assertThat(perpendicular.getY(), equalTo(2d));
	}

	@Test
	public void magnitude() {
		assertThat(new Vector(-2, 1).magnitude(), equalTo(Math.sqrt(5)));
	}

	@Test
	public void multiply() {
		Vector result = new Vector(-2, 1).multiply(2.5d);
		assertThat(result.getX(), equalTo(-5d));
		assertThat(result.getY(), equalTo(2.5d));
	}

	@Test
	public void unit() {
		Vector result = new Vector(-2, 1).unit();
		assertThat(new Double(result.getX()), equalTo(-2d / Math.sqrt(5)));
		assertThat(new Double(result.getY()), equalTo(1 / Math.sqrt(5)));
	}

	@Test
	public void scale() {
		Vector scaled = new Vector(-2, 1).scale(3);
		assertThat(scaled.getX(), equalTo(3d * -2d / Math.sqrt(5)));
		assertThat(scaled.getY(), equalTo(3d * 1 / Math.sqrt(5)));
	}

	@Test
	public void rotate() {
		Vector toRotate = new Vector(100, 300);
		Vector rotate90 = toRotate.rotate(90);
		Vector rotate180 = rotate90.rotate(90);
		Vector rotate270 = rotate180.rotate(90);
		Vector rotate360 = rotate270.rotate(90);

		assertThat(round(rotate90.getX()), equalTo(300l));
		assertThat(round(rotate90.getY()), equalTo(-100l));

		assertThat(round(rotate180.getX()), equalTo(-100l));
		assertThat(round(rotate180.getY()), equalTo(-300l));

		assertThat(round(rotate270.getX()), equalTo(-300l));
		assertThat(round(rotate270.getY()), equalTo(100l));

		assertThat(round(rotate360.getX()), equalTo(100l));
		assertThat(round(rotate360.getY()), equalTo(300l));
	}

	private static long round(double d) {
		return Math.round(d);
	}

}
