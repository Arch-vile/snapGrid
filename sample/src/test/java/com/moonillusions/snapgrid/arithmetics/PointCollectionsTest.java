package com.moonillusions.snapgrid.arithmetics;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PointCollectionsTest {

	PointCollection points;

	@Before
	public void setup() {
		points = new PointCollection(//
				new Point(-2, -2), //
				new Point(-1, -1), //
				new Point(0, 0), //
				new Point(1, 1), //
				new Point(2, 2));
	}

	@Test
	public void closestPoint_when_between() {
		assertThat(points.closestTo( //
				new Point(0.3d, 0.3d)), //
				equalTo(new Point(0, 0)));
	}

	@Test
	public void closestPoint_when_equals() {
		assertThat(points.closestTo( //
				new Point(1, 1)), //
				equalTo(new Point(1, 1)));
	}

	@Test
	public void closestPoint_on_negative_axis() {
		assertThat(points.closestTo( //
				new Point(-1.6, -1.6)), //
				equalTo(new Point(-2, -2)));
	}

	@Test
	public void closestPoint_far_away() {
		assertThat(points.closestTo( //
				new Point(2000, 10000)), //
				equalTo(new Point(2, 2)));
	}

}
