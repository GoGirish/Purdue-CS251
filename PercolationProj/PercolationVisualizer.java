import java.io.IOException;
import java.io.PrintWriter;

//just redo everything here....it's more organized.
public class PercolationVisualizer 
{
	private static int [][] gridTemplate;
	public static PrintWriter writer;
	public PercolationVisualizer()
	{
		
	}
	
	public static void reset_gridTemplate(int n)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				gridTemplate[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			writer = new PrintWriter("visualMatrix.txt", "UTF-8");			
		}
		catch (IOException e)
		{
			
		}
		int n = StdIn.readInt();
		System.out.println(n);
		writer.println(n);
		//writer.close();
		System.out.println();
		writer.println();
		Percolation perc = new Percolation(n);
		gridTemplate = new int[n][n];
		reset_gridTemplate(n);
		
		while (!StdIn.isEmpty())
		{
			int x = StdIn.readInt();
			int y = StdIn.readInt();
			gridTemplate[x][y] = 1;
			perc.open(x, y);
			//int nodePos = n*x + y + 1;
			//System.out.println(perc.percolates(nodePos, n*n + 1));
			for (int i = 1; i < n*n + 1; i++)
			{
				if (perc.percolates(i, n*n+1))
				{
					 int a = (i-1)/n;
					 int b = (i-1)%n;
					 gridTemplate[a][b] = 2;
				}
			}
			print_gridTemplate(n);
			System.out.println();
			writer.println();
		}
		writer.close();
	}

	private static void print_gridTemplate(int n) 
	{
		// TODO Auto-generated method stub
		for (int i = n-1; i >= 0; i--)
		{
			//String s = new String();
			//s = Integer.toString(gridTemplate[i][0]);
			for (int k = 0; k < n; k++)
			{
//				String append = new String();
//				//int j = gridTemplate[i][k];
//				append = " " + Integer.toString(gridTemplate[i][k]);
//				s.concat(append);
				System.out.print(gridTemplate[i][k]+" ");
				writer.print(gridTemplate[i][k]+" ");
			}
			System.out.println();
			writer.println();
		}
	}
}
