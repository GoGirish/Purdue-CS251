import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BurrowsWheeler implements Comparable<BurrowsWheeler>
{
//	private static String fileName;
	private static String str;
	
	private int pointer;
	
	public BurrowsWheeler(int p)
	{
//		b
		pointer = p;
	}
	
	public char[] getString()
	{
		char[] string = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
		{
			string[i] = str.charAt((pointer + i) % str.length());
		}
		return string;
	}
	
	public char[] getString(int p)
	{
		char[] string = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
		{
			string[i] = str.charAt((p + i) % str.length());
//			System.out.print(string[i]);
//			System.out.print(string[i]);
//			BinaryStdOut.write(string[i], 8);
		}
//		BinaryStdOut.flush();
//		BinaryStdOut.close();
//		System.out.println();
//		System.out.println("String = " + string.toString());
		return string;
	}
	
//	public int compareTo(BurrowsWheeler b)
//	{
//		char[] myString = this.getString();
//		char[] bString = b.getString();
//		int i = 0;
//		while ((myString[i] == bString[i]) && (i < str.length()))
//		{
//			i++;
//		}
//		if (i == str.length())
//		{
//			return 0;
//		}
//		else if (myString[i] < bString[i])
//		{
//			return -1;
//		}
//		return 1;
//	}
	
	public int compareTo(BurrowsWheeler b)
	{
		int length = str.length();
		int i = 0;
		while ((str.charAt((i + this.pointer)%length) == str.charAt((i + b.pointer)%length)) && (i < length))
		{
			i++;
		}
		if (i == length)
		{
			return 0;
		}
		else if (str.charAt((i + this.pointer)%length) > str.charAt((i + b.pointer)%length))
		{
			return 1;
		}
		return -1;
//		while ((str[this.pointer] == str[b.]) && (i < str.length()))
//		{
//			i++;
//		}
//		if (i == str.length())
//		{
//			return 0;
//		}
//		else if (myString[i] < bString[i])
//		{
//			return -1;
//		}
//		return 1;
	}
	
	public char getLastChar()
	{
		if (pointer == 0)
		{
			return str.charAt(str.length()-1);
		}
		return str.charAt((pointer-1) % str.length());
	}
	
	public static void printCharArrayLine(char[] s)
	{
//		System.out.print("HHE");
		for (int i = 0; i < s.length; i++)
		{
			BinaryStdOut.write(s[i]);
		}
		BinaryStdOut.flush();
//		BinaryStdOut.close();
		System.out.println();
	}
	
	
	
	//imma put my dick in your ass.
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void encode()
    {
    	String input = BinaryStdIn.readString();
    	str = input;
    	char [] cstr = input.toCharArray();
//    	System.out.println(str);
//    	System.out.println(str.length());
    	
    	ArrayList<BurrowsWheeler> bw = new ArrayList<BurrowsWheeler>();
    	for (int i = 0; i < str.length(); i++)
    	{
//    		System.out.print("bw loop");
    		BurrowsWheeler b = new BurrowsWheeler(i);
    		bw.add(b);
//    		char[] s = b.getString(i);
//    		printCharArrayLine(s);
//    		BinaryStdOut.write(s);
//    		System.out.println(s);
    	}
//    	System.out.println("STEP1");
    	Collections.sort(bw);
//    	System.out.println("STEP2");
    	int i = 0;
//    	System.out.println(cstr);
//    	System.out.println();
    	
//    	BinaryStdOut.write(3);
    	
    	for (BurrowsWheeler b : bw)
    	{
//    		System.out.print(b.getString());
//    		System.out.print(".");
//    		System.out.print("\n");
//    		System.out.print(cstr);
//    		System.out.print(".");
    		
    		int j = compareCharArrays(b.getString(), cstr);
//    		System.out.print(" " + j);
//    		System.out.print("\n");
//    		System.out.print("\n");
    		
    		if (j == 0)
    		{
//    			System.out.println("MATCH");
    			BinaryStdOut.write(i);
    		}
    		
//    		if (b.getString().toString().trim().equals(cstr.toString().trim()))
//    		{
//    			System.out.print("MATCH");
//    		}
//    		
//    		if (b.getString().toString().equals("ABRACADABRA!"))
//    		{
//    			System.out.print("MATCH2");
//    		}
//    		
//    		if (b.getString() == cstr)
//    		{
//    			System.out.println("MATCH3");
//    		}
//    		
//    		if (b.getString().equals(cstr))
//    		{
//    			System.out.println("MATCH4");
//    		}
//    		
//    		if (b.getString()[0] == 'A')
//    		{
//    			System.out.println("MATCH5");
//    		}
//    		
//    		if (true)
//    		{
//    			BinaryStdOut.write(i);
////    			System.out.println("HELLO");
//    		}
    		i++;
    	}
    	
    	BinaryStdOut.flush();
    	
    	for (BurrowsWheeler b : bw)
    	{
//    		printCharArrayLine(b.getString());
    		BinaryStdOut.write(b.getLastChar());
    	}
//    	System.out.println(bw);
    	
    	BinaryStdOut.flush();
    	BinaryStdOut.close();
//    	ArrayList<String> myStrings = new ArrayList<String>();
//    	String input = StdIn.readAll();
////    	String input = StdIn.readString();
////    	StdOut.println(input);
//    	
////    	StdOut.println("Length: " + input.length());
//    	
//    	for (int i = 0; i < input.length(); i++)
//    	{
//    		char[] inputArray = input.toCharArray();
//    		char temp = inputArray[input.length()-1];
//    		input = input.substring(0, input.length() - 1);
//    		StringBuilder sb = new StringBuilder(input);
//    		sb.insert(0, temp);
//    		input = sb.toString();
//    		//StdOut.println(input);
//    		myStrings.add(input);
//    	}
//    	
//    	//StdOut.println("input = " + input);
//    	char[] t = new char[input.length()];
//    	int loc = 0;
//    	
//    	Collections.sort(myStrings);
//    	for (int i = 0; i < myStrings.size(); i++)
//    	{
//    		if (myStrings.get(i).equals(input))
//    		{
//    			loc = i;
//    			
//    			//t[1 + i] = myStrings.get(i).substring(myStrings.get(i).length() - 1);
//    		}
//			t[i] = myStrings.get(i).charAt(myStrings.get(i).length()-1);
//			//BinaryStdOut.write(t[i]);
//    		//StdOut.println(myStrings.get(i));
//    	}
//    	//StdOut.println();
//    	//BinaryStdOut.write(loc);
//    	String newString = new String(t);
//    	//StdOut.println(new String(t));
////    	StdOut.println();
//    	BinaryStdOut.write(loc);
//    	BinaryStdOut.write(newString);
////    	StdOut.println();
////    	StdOut.println("DFSJK");
////    	BinaryStdOut.flush();
//    	BinaryStdOut.close();
//    	BinaryStdOut.flush();
    	//hump me fuck me daddy better make me choke you better...
    	//hump me, fuck me, you know my tunnel loves a deepthroat (it did)
    	
    }
    
    private static int compareCharArrays(char[] string, char[] cstr) 
    {
		// TODO Auto-generated method stub
    	if (string.length > cstr.length)
    	{
    		return -3;
    	}
    	if (string.length < cstr.length)
    	{
    		return -2;
    	}
    	for (int i = 0; i < string.length; i++)
    	{
    		if (string[i] != cstr[i])
    		{
    			return -1;
    		}
    	}
		return 0;
	}

	// apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode()
    {
    	int occurence = BinaryStdIn.readInt();
    	String input = BinaryStdIn.readString();
    	
    	char[] t = input.toCharArray();
    	
    	int next[] = new int[t.length];
    	//Have to use map...
    	Map<Character, ArrayList<Integer>> spaces = new HashMap<Character, ArrayList<Integer>>();
    	
    	for (int i = 0; i < t.length; i++)
    	{
    		//if there isn't a value for t[i] in spaces...
    		if (!spaces.containsKey(t[i]))
    		{
//    			spaces.insert
    			spaces.put(t[i], new ArrayList<Integer>());
    		}
    		spaces.get(t[i]).add(i);
    	}
    	
//    	t.sort();
//    	Collections.sort(t);
    	Arrays.sort(t);
    	
    	
    	for (int i = 0; i < t.length; i++)
    	{
    		next[i] = spaces.get(t[i]).remove(0);
    	}
//    	System.out.println("HELLO");
    	
    	for (int i = 0; i < t.length; i++)
    	{
//    		System.out.println(j);
//    		System.out.println(t.length);
    		BinaryStdOut.write(t[occurence]);
    		occurence = next[occurence];
    	}
    	
    	BinaryStdOut.flush();
    	BinaryStdOut.close();
    }
    
    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args)
    {
    	//fileName = args[1];
    	
    	if (args[0].equals("-"))
    	{
//    		StdOut.println("ENCODING");
    		encode();
    	}
    	if (args[0].equals("+"))
    	{
//    		StdOut.println("DECODING");
    		decode();
    	}
    }
}