https://www.youtube.com/watch?v=B2AJoQSZf4M
​
https://algorithmist.com/wiki/Monotone_chain_convex_hull
Approach 3: Monotone Chain
Algorithm
​
The idea behing Monotone Chain Algorithm is somewhat similar to Graham Scan Algorithm. It mainly differs in the order in which the points are considered while being included in the hull. Instead of sorting the points based on their polar angles as in Graham Scan, we sort the points on the basis of their x-coordinate values. If two points have the same x-coordinate values, the points are sorted based on their y-coordinate values. The reasoning behind this will be explained soon.
​
In this algorithm, we consider the hull as being comprised of two sub-boundaries- The upper hull and the lower hull. We form the two portions in a slightly different manner.
​
We traverse over the sorted pointspoints array after adding the initial two points in the hull temporarily(which are pushed over the stack hullhull). For every new point considered, we check if the current point lies in the counter-clockwise direction relative to the last two points. If so, the current point is staightaway pushed onto hullhull. If not(indicated by a positive orientation), we again get the inference that the last point on the hullhull needs to lie inside the boundary and not on the boundary. Thus, we keep on popping the points from hullhull till the current point lies in a counterclockwise direction relative to the top two points on the hullhull.
​
Note that this time, we need not consider the case of collinear points explicitly, since the points have already been sorted based on their x-coordinate values. So, the collinear points, if any, will implicitly be considered in the correct order.
​
Doing so, we reach a state such that we reach the point with the largest x-coordinate. But, the hull isn't complete yet. The portion of the hull formed till now constitutes the lower poriton of the hull. Now, we need to form the upper portion of the hull.
​
Thus, we continue the process of finding the next counterclockwise points and popping in case of a conflict, but this time we consider the points in the reverse order of their x-coordinate values. For this, we can simply traverse over the sorted pointspoints array in the reverse order. We append the new upper hull values obtained to the previous hullhull itself. At the end, hullhull gives the points on the required boundary.
​
​
​