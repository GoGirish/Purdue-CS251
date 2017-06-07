import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
public class Tester 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		for (String arg : args)
		{
			int num = Integer.parseInt(arg);
			//Brute handler = new Brute();
			ArrayList<Point> pointList = new ArrayList<Point>();
			for (int i = 0; i < num; i++)
			{
				Random rand = new Random();
				int randomX = rand.nextInt((num - 0) + 1) + 0;
				int randomY = rand.nextInt((num - 0) + 1) + 0;
				Point p = new Point(randomX, randomY);
				if (pointList.contains(p))
				{
					i--;
				}
				else
				{
					pointList.add(p);
				}
			}
			
			//handler.printPoints(num, pointList);
		
			PrintWriter writer = null;
			
			StringBuilder strb = new StringBuilder();
			strb.append("input");
			strb.append(num);
			strb.append(".txt");
			String s = strb.toString();
			try
			{
				writer = new PrintWriter(s, "UTF-8");			
			}
			catch (IOException e)
			{
				
			}
			writer.println(num);
			for (Point p : pointList)
			{
				writer.println(p.getX() + " " + p.getY());
			}
			writer.close();
		}
		
		Brute handler = new Brute();
		
		
//		try
//		{
//			runProcess("javac -cp .:stdlib.jar Brute.java");
//			runProcess("javac -cp .:stdlib.jar Fast.java");
//			for (String arg : args)
//			{
//				StringBuilder strb1 = new StringBuilder();
//				strb1.append("java -cp .:stdlib.jar Brute < input");
//				strb1.append(Integer.parseInt(arg));
//				strb1.append(".txt");
//				System.out.println(strb1.toString());
//				runProcess(strb1.toString());
//				StringBuilder strb2 = new StringBuilder();
//				strb2.append("java -cp .:stdlib.jar Fast < input");
//				strb2.append(Integer.parseInt(arg));
//				strb2.append(".txt");
//				runProcess(strb2.toString());
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
	private static void printLines(String name, InputStream ins) throws Exception 
	{
	    String line = null;
	    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
	    while ((line = in.readLine()) != null) 
	    {
	        System.out.println(name + " " + line);
	    }
	}
	
	private static void runProcess(String command) throws Exception
	{
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + "mstderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}
	//for (Point p : )
}
