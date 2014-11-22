package com.moonillusions.snapgrid.arithmetics;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

	@Test
	public void distance() {
		Point point1 = new Point(-2, -3);
		Point point2 = new Point(-4, 4);

		assertThat(point1.distance(point2), equalTo(Math.sqrt(53)));
	}

	@Test
	public void equals() {
		assertThat(new Point(20, 30), equalTo(new Point(20, 30)));
	}

}
