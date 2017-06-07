import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class JaneStreet 
{
	private static Point currentPosition;
	public static int currentDirection;

	public static void main(String[] args) 
	{
		try {
			System.setIn(new FileInputStream("JaneStreet.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentPosition = new Point(0,0);
		currentDirection = 0;
		
		ArrayList<Point> pointC = new ArrayList<Point>();
		ArrayList<Double> distances = new ArrayList<Double>();
		
		// TODO Auto-generated method stub
		System.out.println("HELLO");
		int n_obstacles = StdIn.readInt();
		int n_commands = StdIn.readInt();
		System.out.println("Obstacles = " + n_obstacles);
		System.out.println("Number of Commands = " + n_commands);
		for (int i = 0; i < n_obstacles; i++)
		{
			Point p = new Point(StdIn.readInt(), StdIn.readInt());
			pointC.add(p);
			System.out.println("Point " + i + ": (" + p.x + ", " + p.y + ")");
		}
		
		String dull = StdIn.readLine();
		
		for (int i = 0; i < n_commands; i++)
		{
			String s = StdIn.readLine();
			System.out.println(s);
			if (s.equals("R"))
			{
				currentDirection = (currentDirection + 1)%4;
			}
			else if (s.equals("L"))
			{
				currentDirection = (currentDirection + 3)%4;
			}
			else
			{
				String[] str = s.split(" ");
				
				//System.out.println("1. " + str[1]);
				if (currentDirection == 0)
				{
					for (int j = 0; j < Integer.parseInt(str[1]); j++)
					{
						currentPosition.y++;
						for (Point p : pointC)
						{
							if ((p.x == currentPosition.x) && (p.y == currentPosition.y))
							{
								currentPosition.y--;
							}
						}
					}
					
				}
				else if (currentDirection == 1)
				{
					for (int j = 0; j < Integer.parseInt(str[1]); j++)
					{
						currentPosition.x++;
						for (Point p : pointC)
						{
							if ((p.x == currentPosition.x) && (p.y == currentPosition.y))
							{
								currentPosition.x--;
							}
						}
					}
				}
				else if (currentDirection == 2)
				{
					for (int j = 0; j < Integer.parseInt(str[1]); j++)
					{
						currentPosition.y--;
						for (Point p : pointC)
						{
							if ((p.x == currentPosition.x) && (p.y == currentPosition.y))
							{
								currentPosition.y++;
							}
						}
					}
				}
				else
				{
					for (int j = 0; j < Integer.parseInt(str[1]); j++)
					{
						currentPosition.x--;
						for (Point p : pointC)
						{
							if ((p.x == currentPosition.x) && (p.y == currentPosition.y))
							{
								currentPosition.x++;
							}
						}
					}
				}
			}
			double dist = Math.sqrt(Math.pow(currentPosition.x, 2) + Math.pow(currentPosition.y, 2));
			System.out.println("CurrentPosition: (" + currentPosition.x + ", " + currentPosition.y + "). Dist = " + dist);
			distances.add(dist);
		}
		Collections.sort(distances);
		System.out.println("FINALPosition: (" + currentPosition.x + ", " + currentPosition.y + ")" + " MaxDist = " + distances.get(n_commands-1));
		//System.out.print(distances);
	}
}

//public class Point 
//{
//    public int x = 0;
//    public int y = 0;
//    //constructor
//    public Point(int a, int b) {
//        x = a;
//        y = b;
//    }
//}