
public class SAP 
{
	private Digraph D;
	
	public static void main(String[] args)
	{
		In in = new In(args[0]);
		Digraph G = new Digraph(in);
		SAP _sapObject = new SAP(G);
		
		In tests = new In(args[1]);
		String s = tests.readLine();
		while (s != null)
		{
			String parts[] = s.split(" ");
			int ancestor = _sapObject.ancestor(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			int length = _sapObject.length(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), ancestor);
			StdOut.printf("sap = %d, ancestor = %d\n", length, ancestor);
			s = tests.readLine();
		}
	}
	
	public SAP (Digraph G)
	{
		D = G;
	}
	
	public int length(int v, int w, int ancestor)
	{
		try
		{
			BreadthFirstDirectedPaths bfs_v = new BreadthFirstDirectedPaths(D, v);
			BreadthFirstDirectedPaths bfs_w = new BreadthFirstDirectedPaths(D, w);
			return bfs_w.distTo(ancestor) + bfs_v.distTo(ancestor);
		}
		catch (Exception e)
		{
			return -1;
		}
	}
	
	public int ancestor (int v, int w)
	{
		BreadthFirstDirectedPaths bfs_v = new BreadthFirstDirectedPaths(D, v);
		BreadthFirstDirectedPaths bfs_w = new BreadthFirstDirectedPaths(D, w);
		int shortestAncestor = -1;
		int shortestLength = D.V();
		
		for (int i = 0; i < D.V(); i++)
		{
			if (bfs_v.hasPathTo(i) && bfs_w.hasPathTo(i))
			{
                
                if (bfs_w.distTo(i) + bfs_v.distTo(i) < shortestLength )
                {
                	shortestLength = bfs_w.distTo(i) + bfs_v.distTo(i);
                	shortestAncestor = i;
                }
			}
		}		
		return shortestAncestor;
	}
}
