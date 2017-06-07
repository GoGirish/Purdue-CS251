import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

public class Fast 
{
	private static int numPoints;
	
	private static PrintWriter writer;
	
	public static ArrayList<Point> pointCollection = new ArrayList<Point>();

	public static void main(String[] args)
	{
		//long start = System.nanoTime();
		numPoints = StdIn.readInt();
		
		for (int i = 0; i < numPoints; i++)
		{
			Point p = new Point(StdIn.readInt(), StdIn.readInt());
			pointCollection.add(p);
		}
		
		Collections.sort(pointCollection);
		
		ArrayList<ArrayList<Point>> lines = new ArrayList<ArrayList<Point>>();
		
		for (int i = 0; i < numPoints; i++)
		{
			Point origin = pointCollection.get(i);
			ArrayList<Point> tempPoints = new ArrayList<Point>();
			for (int j = i + 1; j < numPoints; j++)
			{
				double angle = origin.angleTo(pointCollection.get(j));
				pointCollection.get(j).setTheta(angle);
				tempPoints.add(pointCollection.get(j));
			}
			//tempPoints.add(origin);
			
			Collections.sort(tempPoints, Point.BY_ANGLE);
			
			Map<Double, ArrayList<Point>> subLists = new HashMap<Double, ArrayList<Point>>();
			//Map<Integer, List<MyObject>> subs = new HashMap<Integer, List<MyObject>>();
			for (Point p : tempPoints)
			{
				ArrayList<Point> temp = subLists.get(p.getAngle());
				
				if (temp == null)
				{
					temp = new ArrayList<Point>();
					subLists.put(p.getAngle(), temp);
				}
				
				temp.add(p);
			}
			
			ArrayList<ArrayList<Point>> partitionedList = new ArrayList<ArrayList<Point>>(subLists.values());
			
			for (ArrayList<Point> subList : partitionedList)
			{
				if (subList.size() >= 3)
				{
					//System.out.println(subList);
					subList.add(origin);
					lines.add(subList);
				}
			}
			
			//Prints order of points based on angle.
//			for (Point p : tempPoints)
//			{
//				System.out.println(tempPoints.indexOf(p) + ": (" + p.getX() + ", " + p.getY() + "). Angle = " + p.getAngle());
//			}
		}
		
//		System.out.println(lines);
		
		for (int i = 0; i < lines.size(); i++)
		{
			Collections.sort(lines.get(i));
			for (int j = i + 1; j < lines.size(); j++)
			{
				if (lines.get(i).contains(lines.get(j).get(0)) && lines.get(i).contains(lines.get(j).get(1)))
				{
					lines.remove(j);
				}
			}
		}
//		System.out.println();
//		System.out.println(lines);
		
//		for (ArrayList<Point> line : lines)
//		{
//			printPoints(line.size(), line);
//		}
		//long estTime = System.nanoTime() - start;
		//System.out.println("TIME: " + ((double)estTime/1000000000));
		printLineSegments(lines);
	}
	
//	private static void printPoints(int n ,ArrayList<Point> pointCollection) 
//	{
//		// TODO Auto-generated method stub
//		System.out.println("Number of points: " + n);
//		for (int i = 0; i < pointCollection.size(); i++)
//		{
//			Point p = pointCollection.get(i);
//			System.out.println("Point " + i + ": (" + p.getX() + ", " + p.getY() + ")");
//		}
//	}
	
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
			writer.print(pointSystem.size() + ":");
			System.out.print(pointSystem.size() + ":");
			for (Point p : pointSystem)
			{
				writer.print("(" + p.getX() + ", " + p.getY() + ")");
				System.out.print("(" + p.getX() + ", " + p.getY() + ")");
				if (pointSystem.indexOf(p) != (pointSystem.size()-1))
				{
					writer.print(" -> ");
					System.out.print(" -> ");
				}
				else
				{
					writer.print('\n');
					System.out.print('\n');
				}
			}
//			writer.println(pointSystem.size() + ":" + "(" + pointSystem.get(0).getX() + ", " + pointSystem.get(0).getY() + ") -> "
//					 + "(" + pointSystem.get(1).getX() 	+ ", " + pointSystem.get(1).getY() + ") -> "
//					 + "(" + pointSystem.get(2).getX() + ", " + pointSystem.get(2).getY() + ") -> "
//					 + "(" + pointSystem.get(3).getX() + ", " + pointSystem.get(3).getY() + ")");
//			System.out.println(pointSystem.size() + ":" + "(" + pointSystem.get(0).getX() + ", " + pointSystem.get(0).getY() + ") -> "
//					 + "(" + pointSystem.get(1).getX() + ", " + pointSystem.get(1).getY() + ") -> "
//					 + "(" + pointSystem.get(2).getX() + ", " + pointSystem.get(2).getY() + ") -> "
//					 + "(" + pointSystem.get(3).getX() + ", " + pointSystem.get(3).getY() + ")");
		}
		writer.close();
	}
//	public double FindAngle (Point origin, Point compare)
//	{
//		double angle = (double)(Math.toDegrees(Math.atan2(compare.getY() - origin.getY(), compare.getX() - origin.getX())));
//		if (angle < 0)
//		{
//			angle = angle + 360;
//		}
//		return angle;
//	}
}
