snapGrid
========

Finding out the mouse snap position based on last drawn line (between previous and last point).  We want the possible snap points be relative to the line by:
- Snap points needs to be on the same distance from last drawn point then user's mouse
- Snap points are in 0,45,90,135,180,225,270 and 315 angle to the last drawn line
- Closest of the snap points to the current mouse position is selected

Problem is solved by using vector arithmetics. We create the RadiusVector which is in magnitude equal to  the radius of the circle created by last point as center and current mouse position on arch. In addition it is perpendicular to the  last drawn line. 

Drawing the radius vector starting from the center of the circle gives the first snap point. Other snap points are found by rotating the radius vector 45 degrees at a time using the circle's center as rotation point.

Finally from the list of calculated points, the closest to the mouse is selected.

![Alt text](/snapGrid.png?raw=true "Optional Title")



