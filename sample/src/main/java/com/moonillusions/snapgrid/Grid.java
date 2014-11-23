package com.moonillusions.snapgrid;

import java.util.ArrayList;
import java.util.List;

import com.moonillusions.snapgrid.arithmetics.Point;
import com.moonillusions.snapgrid.arithmetics.PointCollection;
import com.moonillusions.snapgrid.arithmetics.Vector;

public class Grid {

	/**
	 * Use multiply of 4 to get even distribution of snap points
	 */
	private static final int SNAP_POINTS = 8;

	/**
	 * Determines the point to which we should snap the mouse
	 * 
	 * @param lastPoint
	 *            Last point inserted
	 * @param previousPoint
	 *            Second to last point inserted
	 * @param mouse
	 *            Current mouse position
	 * @return Point to which the mouse should snap
	 */
	public Point getSnap(Point lastPoint, Point previousPoint, Point mouse) {
		PointCollection snapPoints = new PointCollection(getSnapPoints(
				lastPoint, previousPoint, mouse));
		return snapPoints.closestTo(mouse);
	}

	/**
	 * Determines all the available snap points.
	 * 
	 * @param lastPoint
	 *            Last point inserted
	 * @param previousPoint
	 *            Second to last point inserted
	 * @param mouse
	 *            Current mouse position
	 * @return List of all the snap points
	 */
	public List<Point> getSnapPoints(Point lastPoint, Point previousPoint,
			Point mouse) {
		Vector radiusVector = getRadiusVector(lastPoint, previousPoint, mouse);
		return calculateSnapPoints(lastPoint, radiusVector);
	}

	private Vector getRadiusVector(Point lastPoint, Point previousPoint,
			Point mouse) {
		Vector base = new Vector(lastPoint).subtract(new Vector(previousPoint));
		Vector perpendicularToBase = base.perpendicular();

		double radius = lastPoint.distance(mouse);
		return perpendicularToBase.scale(radius);
	}

	private List<Point> calculateSnapPoints(Point lastPoint, Vector radiusVector) {

		List<Point> snapPoints = new ArrayList<Point>();
		for (int degrees = 0; degrees < 360; degrees += 360 / SNAP_POINTS) {
			Vector rotated = radiusVector.rotate(degrees);
			Vector snap = rotated.add(new Vector(lastPoint));
			snapPoints.add(new Point(Math.round(snap.getX()), Math.round(snap
					.getY())));
		}

		return snapPoints;
	}

}
