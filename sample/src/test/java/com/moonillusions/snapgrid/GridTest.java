package com.moonillusions.snapgrid;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.moonillusions.snapgrid.arithmetics.Point;

public class GridTest {

	private Grid grid;
	private Point lastPoint;
	private Point previousPoint;
	private Point mouse;

	@Before
	public void setup() {
		grid = new Grid();
		lastPoint = new Point(228, 216);
		previousPoint = new Point(137, 246);
		mouse = new Point(247, 154);
	}

	@Test
	public void getSnapPoints() {
		List<Point> snapPoints = grid.getSnapPoints(lastPoint, previousPoint,
				mouse);
		assertThat(snapPoints, contains( //
				new Point(248, 278), //
				new Point(286, 245), //
				new Point(290, 196), //
				new Point(257, 158), //
				new Point(208, 154), //
				new Point(170, 187), //
				new Point(166, 236), //
				new Point(199, 274)));
	}

	@Test
	public void getSnapPoint() {
		Point snapPoint = grid.getSnap(lastPoint, previousPoint, mouse);
		assertThat(snapPoint, equalTo(new Point(257, 158)));
	}

}
