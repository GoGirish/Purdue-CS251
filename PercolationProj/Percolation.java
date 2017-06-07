

public class Percolation
{
	//private int[][] 2dgrid;
	private int[] flatGrid;
	private WeightedQuickUnionUF handler;
	private int N;
	
	public Percolation(int n)
	{
		//grid = new int[n][n];
		N = n;
		flatGrid = new int[N*N];
		//why is this??? Ask Jordan
		handler = new WeightedQuickUnionUF((N*N)+2);
//		for (int i = 0; i < n; i++)
//		{
//			for (int j = 0; j < n; j++)
//			{
//				grid[i][j] = 1;
//			}
//		}
		for (int i = 0; i < (N*N); i++)
		{
			//Let it be decreed by executive order of 
			//DOnald J .Trump that 1 is blocked and 0 is free.
			//lol jk...0 is blocked, 1 is open
			flatGrid[i] = 0;
		}
	}
	
	public void open(int x, int y)
	{
		//2dgrid[x][y] = 1;
		int pos = N*x + y;
		if (isOpen(x,y) == false)
		{
			flatGrid[pos] = 1;
			checkSpread(x,y, pos);
		}
		
	}
	
	public boolean openFromRandom(int p)
	{
		//returns true if the cell was not already opened.
		//returns false if the cell WAS already opened, and nothing was
		//done to it.
		int x = p/N;
		int y = p%N;
		if (isOpen(x,y) == false)
		{
			flatGrid[p] = 1;
			checkSpread(x,y, p);
			return true;
		}
		return false;
	}
	
	public void checkSpread(int x, int y, int pos)
	{
		if (x > 0)
		{
			if (isOpen(x-1, y) == true)
			{
				handler.union(pos + 1, pos - N + 1);
			}
		}	
			else
			{
				handler.union(0, pos + 1);
			}
		
		
		if (x < N-1)
		{
			if (isOpen(x+1, y))
			{
				handler.union(pos+1, pos+N+1);
			}
		}
			else
			{
				handler.union((N*N)+1, pos+1);
			}
		
		
		if (y > 0 && (isOpen(x, y-1) == true))
		{
			handler.union(pos+1, pos-1+ 1);
		}
		
		if (y < N-1 && (isOpen(x, y+1)==true))
		{
			handler.union(pos+1, pos+1+1);
		}
	}
	
	public boolean isOpen (int x, int y)
	{
//		if (grid[x][y] == 0)
//		{
//			return true;
//		}
//		return false;
		if (flatGrid[N*x + y] == 1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isFull(int x, int y)//opposite of isOpen
	{
		//return false;
		if (flatGrid[N*x + y] == 0)
		{
			return true;
		}
		return false;
	}
	
	public boolean percolates()
	{
		//return false;
		return handler.connected(0, (N*N)+1);
	}
	
	public boolean percolates(int node1, int node2)
	{
		return handler.connected(node1, node2);
	}
	
	public static void main(String[] args)
	{
		int n = StdIn.readInt();
		//System.out.println("number n = " + n);
		Percolation perc = new Percolation(n);
		int [][] gridTemplate = new int[n][n];
		
		while (!StdIn.isEmpty())
		{
			int x = StdIn.readInt();
			int y = StdIn.readInt();
			gridTemplate[x][y] = 1;
			perc.open(x, y);
		}
	
		if (perc.percolates())
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
		
//		int SquareSide = 9;
//	     
//	     int[][] Grid3 = {
//	    		 {1,0,0},
//	    		 {0,1,1},
//	    		 {1,1,1}
//	     };
//	     
//	     int [][] Grid4 = {
//	    		 {0,0,1},
//	    		 {0,1,1},
//	    		 {1,1,1}
//	     };
//	     
//	     Percolation perc1 = new Percolation(9);
//	     Percolation perc2 = new Percolation(9);
//	     Percolation perc3 = new Percolation(3);
//	     Percolation perc4 = new Percolation(3);
//	     
//	     for (int xx = 0; xx < 3; xx++)
//	     {
//	    	 for (int yy = 0; yy < 3; yy++)
//	    	 {
//	    		 if (Grid3[xx][yy] == 1)
//	    		 {
//	    			 perc3.open(xx, yy);
//	    		 }
//	    		 
//	    		 if (Grid4[xx][yy] == 1)
//	    		 {
//	    			 perc4.open(xx,yy);
//	    		 }
//	    	 }
//	     }
//	     
//	     for (int x = 0; x < SquareSide; x++)
//	     {
//	    	 for (int y = 0; y < SquareSide; y++)
//	    	 {
//	    		 if (Grid1[x][y] == 1)
//	    		 {
//	    			 perc1.open(x, y);
//	    		 }
//	    		 
//	    		 if (Grid2[x][y] == 1)
//	    		 {
//	    			 perc2.open(x, y);
//	    		 }
//	    	 }
//	     }
//	     
//	     System.out.println("perc1: "+ perc1.percolates() + ". perc2: " + perc2.percolates());
//	     System.out.println("perc3,which is a no: " + perc3.percolates());
//	     System.out.println("perc4, which is a yes: " + perc4.percolates());
	}
}