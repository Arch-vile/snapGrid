snapGrid
========

Finding out the mouse snap position based on last drawn line. We want the possible snap points be relative to the last line by:
- Snap point needs to be on the same distance from last drawn point then user's mouse
- Snap points are in 0,45,90,135,180,225,270 and 315 angle to the last drawn line

Problem is solved by using vector arithmetics. We create the RadiusVector which is in length equal to  the radius of the circle created by last point and current mouse position. In addition it is perpendicular to the  last drawn line. 

Drawing the radius vector starting from the center of the circle gives the first snap point. Other snap points are found by rotating the radius vector in steps 45 degrees at a time using the circle's center as rotation point.

Finally from the list of calcuated points, the closest to the mouse is selected.

![Alt text](/snapGrid.png?raw=true "Optional Title")



