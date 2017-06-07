import java.util.ArrayList;

public class MoveToFront 
{
//	private static final int CHARLENGTH = 8;
	public static ArrayList<Integer> charIntsList;

	// apply move-to-front encoding, reading from standard input and writing to standard output
	public static void encode()
	{
		String input = BinaryStdIn.readString();
		char[] inputC = input.toCharArray();
		populateList();
		
		for (int i = 0; i < inputC.length; i++)
		{
//			int letterInt = Character.getNumericValue(inputC[i]);
			int letterInt = (int) inputC[i];
			int j = charIntsList.indexOf(letterInt);
			char letter = (char) j;
			//System.out.println("int: " + j + "letter: " + letter);
			BinaryStdOut.write(letter);
			charIntsList.add(0, charIntsList.remove(j));
		}
		
		BinaryStdOut.flush();
		BinaryStdOut.close();
	}
	// apply move-to-front decoding, reading from standard input and writing to standard output
	public static void decode()
	{
		populateList();
		String input = BinaryStdIn.readString();
		char[] inputC = input.toCharArray();
		
		for (int i = 0; i < input.length(); i++)
		{
//			System.out.println("c");
			int j = (int)inputC[i];
			int letterInt = charIntsList.remove(j);
//			charIntsList.add(0, charIntsList.remove(j));
			charIntsList.add(0, letterInt);
//			char letter = (char) j;
			BinaryStdOut.write(letterInt, 8);
		}
		
		6j
	}
	
	public static void populateList()
	{
		//populate list of characters 0-255
		charIntsList = new ArrayList<Integer>();
		for (int i = 0; i < 256; i++)
		{
			charIntsList.add(i);
		}
	}
	// if args[0] is '-', apply move-to-front encoding
	// if args[0] is '+', apply move-to-front decoding
	public static void main(String[] args)
	{
//		populateList();
		if (args[0].equals("-"))
		{
//			StdOut.println("ENCODE");
			encode();
		}
		
		if (args[0].equals("+"))
		{
//			StdOut.println("DECODE");
			decode();
		}
	}
}