/*************************************************************************
 * Compilation:  javac Point.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point>{
    // compare points by slope
    //public final Comparator<Point> BY_SLOPE_ORDER;    // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y; 	
    private double theta;

    // constructor
    public Point(int x, int y) 
    {
        this.x = x;
        this.y = y;
        this.theta = 0;
    }
    
    public static Comparator<Point> BY_ANGLE = new Comparator<Point>()
    {
    	public int compare(Point one, Point two)
    	{
    		if (one.compareAngle(two) > 0)
    		{
    			return 1;
    		}
    		
    		if (one.compareAngle(two) < 0)
    		{
    			return -1;
    		}
    		return 0;
    	}
    };
    
    public double compareAngle(Point that)
    {
    	return this.theta - that.theta;
    }
    
    public void resetTheta()
    {
    	this.theta = 0;
    }
    
    public void setTheta(double theta)
    {
    	this.theta = theta;
    }
    
    public double angleTo(Point that)
    {
    	double angle = (double)(Math.toDegrees(Math.atan2(that.getY() - this.getY(), that.getX() - this.getX())));
		if (angle < 0)
		{
			angle = angle + 360;
		}
		return angle;
    }
    
    public static Comparator<Point> BY_SLOPE_ORDER = new Comparator<Point>() 
    {

    	public int compare(Point one, Point two) 
    	{
    		return one.compareTo(two);
//        	if (one.x > two.x)
//        	{
//        		return 1;
//        	}
//        	if (one.x < two.x)
//        	{
//        		return -1;
//        	}
//        	if (one.x == two.x)
//        	{
//        		if (one.y > two.y)
//            	{
//            		return 1;
//            	}
//            	if (one.y < two.y)
//            	{
//            		return -1;
//            	}
//        	}
//        	return 0;
    	}
	};

    public double getAngle()
    {
    	return theta;
    }
    
	public static double findSlope(Point p, Point q)
    {
    	double dY = (double)(q.y - p.y);
    	double dX = (double)(q.x - p.x);
    	double slope = dY / dX;
    	if (slope == -0.0)
    	{
    		slope = 0.0;
    	}
    	return slope;
//    	return 0;
    }

    // are the 3 points p, q, and r collinear?
    public static boolean areCollinear(Point p, Point q, Point r) 
    {
        /* YOUR CODE HERE */
    	double slope1 = findSlope(p, q);
    	double slope2 = findSlope(p, r);
    	if (slope1 == slope2)
    	{
    		return true;
    	}
    	return false;
    }

    // are the 4 points p, q, r, and s collinear?
    public static boolean areCollinear(Point p, Point q, Point r, Point s) 
    {
        /* YOUR CODE HERE */
    	if (areCollinear(p,q,r) && areCollinear(p,q,s))
    	{
    		return true;
    	}
    	return false;
    }
    
    public int getX()
    {
    	return this.x;
    }
    
    public int getY()
    {
    	return this.y;
    }

    // is this point lexicographically smaller than that one?
    public int compareTo(Point that) 
    {
        /* YOUR CODE HERE */
    	if (this.x > that.x)
    	{
    		return 1;
    	}
    	if (this.x < that.x)
    	{
    		return -1;
    	}
    	if (this.x == that.x)
    	{
    		if (this.y > that.y)
        	{
        		return 1;
        	}
        	if (this.y < that.y)
        	{
        		return -1;
        	}
    	}
    	return 0;
    }

}
