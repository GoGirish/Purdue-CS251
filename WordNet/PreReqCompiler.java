import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PreReqCompiler 
{
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
	
	public static void main(String[] args) throws Exception 
	{
		runProcess("javac -classpath .:stdlib.jar Bag.java");
		runProcess("javac -classpath .:stdlib.jar Stack.java");
		runProcess("javac -classpath .:stdlib.jar Queue.java");
		runProcess("javac -classpath .:stdlib.jar BreadthFirstDirectedPaths.java");
		runProcess("javac -Xlint:-unchecked -classpath .:stdlib.jar Digraph.java");
		runProcess("javac -Xlint:-unchecked -classpath .:stdlib.jar Graph.java");
		runProcess("javac -classpath .:stdlib.jar DepthFirstPaths.java");
		runProcess("javac -classpath .:stdlib.jar SAP.java");
		runProcess("javac -classpath .:stdlib.jar WordNet.java");
	}

}
