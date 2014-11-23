package com.moonillusions.snapgrid.arithmetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointCollection {

	private final Collection<Point> points;

	public PointCollection(Point... points) {
		this.points = Arrays.asList(points);
	}

	public PointCollection(Collection<Point> snapPoints) {
		this.points = snapPoints;
	}

	public Point closestTo(final Point reference) {
		List<Point> sorted = new ArrayList<Point>(points);

		Collections.sort(sorted, new Comparator<Point>() {

			public int compare(Point point1, Point point2) {
				return (int) (point1.distance(reference) - point2
						.distance(reference));
			}

		});

		return sorted.get(0);
	}

}
