import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Brute 
{
	public static ArrayList<Point> pointCollection = new ArrayList<Point>();
	
	public static ArrayList<ArrayList<Point>> lineCollection = new ArrayList<ArrayList<Point>>();
	
	private static PrintWriter writer;
	
	private static int numPoints;
	
	public Brute()
	{
		
	}
	
	public static void main(String[] args) 
	{
		//long[] stopwatchLog = new long[T];
		//long start = System.nanoTime();
		// TODO Auto-generated method stub
		//System.out.println("HELLO");
		
		numPoints = StdIn.readInt();
		//System.out.println("HELLO1");

		for (int i = 0; i < numPoints; i++)
		{
			Point p = new Point(StdIn.readInt(), StdIn.readInt());
			pointCollection.add(p);
		}

		//Collections.sort(pointCollection);
		Collections.sort(pointCollection, Point.BY_SLOPE_ORDER);
		
		//printPoints(numPoints, pointCollection);
		//System.out.println("HELLO");
		
//		System.out.println(Point.findSlope(pointCollection.get(0), pointCollection.get(1)));
//		System.out.println(Point.findSlope(pointCollection.get(0), pointCollection.get(2)));
//		System.out.println(Point.findSlope(pointCollection.get(0), pointCollection.get(3)));
//		System.out.println(Point.findSlope(pointCollection.get(0), pointCollection.get(4)));
		
//		if (Point.areCollinear(pointCollection.get(0), pointCollection.get(1), pointCollection.get(4)))
//		{
//			System.out.println("TRUE");
//		}
//		else
//		{
//			System.out.println("FALSE");
//		}
//		
//		if (Point.areCollinear(pointCollection.get(0), pointCollection.get(1), pointCollection.get(2), pointCollection.get(4)))
//		{
//			System.out.println("TRUE");
//		}
//		else
//		{
//			System.out.println("FALSE");
//		}
			
		
		for (int i = 0; i < numPoints; i++)
		{
			for (int j = i+1; j < numPoints; j++)
			{
				for (int k = j+1; k < numPoints; k++)
				{
					for (int l = k+1; l < numPoints; l++)
					{
						//System.out.println(i + " " + j + " " + k + " " + l);
						if (Point.areCollinear(pointCollection.get(i), 
											   pointCollection.get(j), 
											   pointCollection.get(k), 
											   pointCollection.get(l)	))
						{
							printPointSystem(pointCollection.get(i),
											 pointCollection.get(j),
											 pointCollection.get(k),
											 pointCollection.get(l));
						}
					}
				}
			}
		}
		//System.out.println("HELLO2");

		//System.out.println();
		printLineSegments(lineCollection);
		
//		System.out.println("number of points = " + n);
//		int firstpoint = StdIn.readInt();
//		System.out.println("firstpoint = " + firstpoint);
//		int secondpoint = StdIn.readInt();
//		System.out.println("secondpoint = " + secondpoint);
		//long estTime = System.nanoTime() - start;
		//System.out.println("TIME: " + ((double)estTime/1000000000));
		System.exit(0);
	}
	
	private static void printLineSegments(ArrayList<ArrayList<Point>> lines) 
	{
		// TODO Auto-generated method stub
		//Collections.sort(lines, new Point());
		//PrintWriter writer;
		//writer = new PrintWriter("visualPoints.txt", "UTF-8");
		try
		{
			writer = new PrintWriter("visualPoints.txt", "UTF-8");			
		}
		catch (IOException e)
		{
			
		}
		
		for (ArrayList<Point> pointSystem : lines)
		{
			writer.println(pointSystem.size() + ":" + "(" + pointSystem.get(0).getX() + ", " + pointSystem.get(0).getY() + ") -> "
					 + "(" + pointSystem.get(1).getX() + ", " + pointSystem.get(1).getY() + ") -> "
					 + "(" + pointSystem.get(2).getX() + ", " + pointSystem.get(2).getY() + ") -> "
					 + "(" + pointSystem.get(3).getX() + ", " + pointSystem.get(3).getY() + ")");
			System.out.println(pointSystem.size() + ":" + "(" + pointSystem.get(0).getX() + ", " + pointSystem.get(0).getY() + ") -> "
					 + "(" + pointSystem.get(1).getX() + ", " + pointSystem.get(1).getY() + ") -> "
					 + "(" + pointSystem.get(2).getX() + ", " + pointSystem.get(2).getY() + ") -> "
					 + "(" + pointSystem.get(3).getX() + ", " + pointSystem.get(3).getY() + ")");
		}
		writer.close();
	}

	private static void printPointSystem(Point p, Point q, Point r, Point s) 
	{
		// TODO Auto-generated method stub
		ArrayList<Point> temp = new ArrayList<Point>();
		temp.add(p); temp.add(q); temp.add(r); temp.add(s);
		Collections.sort(temp);
		lineCollection.add(temp);
		
//		System.out.println("(" + temp.get(0).getX() + ", " + temp.get(0).getY() + ") -> "
//						 + "(" + temp.get(1).getX() + ", " + temp.get(1).getY() + ") -> "
//						 + "(" + temp.get(2).getX() + ", " + temp.get(2).getY() + ") -> "
//						 + "(" + temp.get(3).getX() + ", " + temp.get(3).getY() + ")");
	}

	public static void printPoints(int n ,ArrayList<Point> pointCollection) 
	{
		// TODO Auto-generated method stub
		System.out.println("Number of points: " + n);
		for (int i = 0; i < pointCollection.size(); i++)
		{
			Point p = pointCollection.get(i);
			System.out.println("Point " + i + ": (" + p.getX() + ", " + p.getY() + ")");
		}
	}

}
