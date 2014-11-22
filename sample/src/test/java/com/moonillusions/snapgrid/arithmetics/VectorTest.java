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
	public void perpendicular() {
		Vector base = new Vector(2, 3);
		Vector perpendicular = base.perpendicular();

		assertThat(perpendicular.getX(), equalTo(-3d));
		assertThat(perpendicular.getY(), equalTo(2d));
	}

	@Test
	public void magnitude() {
		Vector base = new Vector(-2, 1);
		assertThat(base.magnitude(), equalTo(Math.sqrt(5)));
	}

	@Test
	public void multiply() {
		Vector base = new Vector(-2, 1);
		Vector result = base.multiply(2.5d);
		assertThat(result.getX(), equalTo(-5d));
		assertThat(result.getY(), equalTo(2.5d));
	}

	@Test
	public void unit() {
		Vector base = new Vector(-2, 1);
		Vector result = base.unit();
		assertThat(new Double(result.getX()), equalTo(-2d / Math.sqrt(5)));
		assertThat(new Double(result.getY()), equalTo(1 / Math.sqrt(5)));
	}
}
