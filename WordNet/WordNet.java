import java.util.ArrayList;

public final class WordNet 
{
	private static ArrayList<DictionaryEntry> dictionary;
	private static Digraph D;
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WordNet wordNet = new WordNet(args[0], args[1]);
		SAP sap = new SAP(D);
//		sap.length(81426, 26075);
		//wordNet.printDictionary();
		
		//StdOut.printf("%s == %d\n", dictionary.get(21110).word, dictionary.get(21110).number);
		In tests = new In(args[2]);
		String s = tests.readLine();
		while (s != null)
		{
			String parts[] = s.split(" ");
			//StdOut.printf("word1: %s. word2: %s.\n", parts[0], parts[1]);
			ArrayList<Integer> al_v = wordNet.findWord(parts[0]);
			ArrayList<Integer> al_w = wordNet.findWord(parts[1]);
			if (al_w.isEmpty() || al_v.isEmpty())
			{
				StdOut.printf("sap = -1, ancestor = null\n");
			}
			else
			{
				int ancestor = -1;
				int length = dictionary.size();
				for (Integer i : al_v)
				{
					for (Integer j : al_w)
						{
							int _ancestor = sap.ancestor(i, j);
							int _length = sap.length(i, j, _ancestor);
							//StdOut.printf("_length = %d\n", _length);
							if (_length < length)
							{
								ancestor = _ancestor;
								length = _length;
							}
						}
				}
				if (length == -1)
				{
					StdOut.printf("sap = -1, ancestor = null\n");
				}
				else
				{
					for (DictionaryEntry d : dictionary)
					{
						if (d.number == ancestor)
						{
							StdOut.printf("sap = %d, ancestor = %s\n", length,d.word);
							break;
						}
					}
					//StdOut.printf("sap = %d, ancestor = %s\n", length, dictionary.get(ancestor-1).word);
				}
			}
			s = tests.readLine();
		}
	}
	
	// constructor takes the name of the two input files
	 public WordNet(String synsets, String hypernyms) 
	 {
		 dictionary = new ArrayList<DictionaryEntry>();
		 In in = new In(synsets);
		 String s = in.readLine();
		 while (s != null)
		 {
			 //StdOut.printf("%s\n", s);
			 String parts[] = s.split(",");
			 //
			 String words[] = parts[1].split(" ");
			 int number = Integer.parseInt(parts[0]);
			 //String word = parts[1];
			 String definition = parts[2];
			 for (String word : words)
			 {
				 DictionaryEntry d = new DictionaryEntry(number, word, definition);
				 dictionary.add(d);
			 }
			 //StdOut.printf("(%d) - %s: %s.\n", number, word, definition);
			 
			 s = in.readLine();
		 }
		 
		 D = new Digraph(hypernyms, dictionary.size());
	 }
	 
	 public void printDictionary()
	 {
		 //StdOut.printf("WORD: %s\n", dictionary.get(21111).word);
		 for (DictionaryEntry d : dictionary)
		 {
			 ///StdOut.printf("Word: %s.  Def: %s.\n", d.word, d.definition);
		 }
		 //StdOut.printf("Size: %d\n", dictionary.size());
	 }
	 
	 
	 // is the word a WordNet noun? This can be used to search for existing
	 // nouns at the beginning of the printSap method
	 public ArrayList<Integer> findWord(String word) 
	 {
		 //StdOut.printf("WORD: %s\n", dictionary.get(49778).word);

		 ArrayList<Integer> indexes = new ArrayList<Integer>();
//		 for (int i = 0; i < dictionary.size(); i++)
//		 {
//			 if (dictionary.get(i).word.equals("administrative_district"))
//			 {
//				 StdOut.printf("%s = %d\n", dictionary.get(i).word, dictionary.get(i).number);
//				 indexes.add(i+1);
//			 }
//		 }
		 for (DictionaryEntry d : dictionary)
		 {
			 //StdOut.printf("%s. ", d.word);
			 if (d.word.equals(word))
			 {
				 //StdOut.printf("index = %d.\n", d.number);
				 indexes.add(d.number);
			 }
		 }
		 return indexes;
	 }
	 
	 
	 // print the synset (second field of synsets.txt) that is the common ancestor
	 // of nounA and nounB in a shortest ancestral path as well as the length of the path,
	 // following this format: "sap<space>=<space><number>,<space>ancestor<space>=<space><synsettext>"
	 // If no such path exists the sap should contain -1 and ancestor should say "null"
	 // This method should use the previously defined SAP datatype
	 public void printSap(String nounA, String nounB) 
	 {
		 
	 }

}

class DictionaryEntry
{
	public int number;
	public String word;
	public String definition;
	
	public DictionaryEntry(int _number, String _word, String _definition)
	{
		number = _number;
		word = _word;
		definition = _definition;
	}
}