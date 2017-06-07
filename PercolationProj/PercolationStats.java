
public class PercolationStats 
{
	public PercolationStats()
	{
		
	}
	
	public static double findMean(int[] arr)
	{
		int length = arr.length;
		int total = 0;
		for (int i = 0; i < length; i++)
		{
			total += arr[i];
		}
		return (double)(total)/(double)(length);
	}
	
	public static double findMean(double[] arr)
	{
		int length = arr.length;
		double total = 0;
		for (int i = 0; i < length; i++)
		{
			total += arr[i];
		}
		
		return total/(double)(length);
	}
	
	public static double findStdDdev(int[] arr)
	{
//		1. Work out the Mean (the simple average of the numbers)
//		2. Then for each number: subtract the Mean and square the result
//		3. Then work out the mean of those squared differences.
//		4. Take the square root of that and we are done!
		
		double mean = findMean(arr);
		double[] newarr = new double[arr.length];
		for (int i = 0; i < arr.length; i ++)
		{
			double num = Math.pow(arr[i] - mean, 2);
			newarr[i] = num;
		}
	
		double newMean = findMean(newarr);
		return Math.sqrt(newMean);
	}
	
	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		boolean isFast = false;
		if (args[2].equals("fast"))
		{
			isFast = true;
			
			
			//System.out.println(N + ".");
			//System.out.println(T);
			//System.out.println(isFast);
			
			//N = 3;
			
			Percolation perc = new Percolation(N);
			//for (int i = 0; i < 30; i++)
			int count = 0;
			int [] arr = new int[T];
			long [] stopwatchLog = new long[T];
			int tCount = 0;
			while (tCount < T)
			{
				long start = System.nanoTime();
				count = 0;
				perc = new Percolation(N);
				while (perc.percolates() == false)
				{
					int rand = (1 + (int)(Math.random() * ((N*N - 2) + 1)));
					//System.out.println(rand);
					if (perc.openFromRandom(rand) == true)
					{
						count++;
					}
				}
				
				arr[tCount] = count;
				//System.out.println(count);
				long estTime = System.nanoTime() - start;
				stopwatchLog[tCount] = estTime;
				tCount++;
			}
	//		**OUTPUT BELOW**
	//
	//		mean threshold=the_threshold_value
	//
	//		std dev=the_threshold_stddev
	//
	//		time=total_time_in_seconds
	//
	//		mean time=mean_time_in_seconds
	//
	//		stddev time=stddev_time_in_second
			System.out.println();
			System.out.println("**OUTPUT BELOW**");
			double mean = findMean(arr);
			System.out.println("mean threshold=" + mean);
			double stdDev = findStdDdev(arr);
			System.out.println("std dev=" + stdDev);
			double totalTime = findTotal(stopwatchLog);
			System.out.println("time=" + totalTime/1000000000);
			double meanTime = findMean(stopwatchLog);
			System.out.println("mean time=" + meanTime/1000000000);
			double stdDevTime = findStdDev(stopwatchLog);
			System.out.println("stddev time=" + stdDevTime/1000000000);
		}
		
		else if (args[2].equals("slow"))
		{
			isFast = false;
			
			
			//System.out.println(N + ".");
			//System.out.println(T);
			//System.out.println(isFast);
			
			//N = 3;
			
			PercolationQuick perc = new PercolationQuick(N);
			//for (int i = 0; i < 30; i++)
			int count = 0;
			int [] arr = new int[T];
			long [] stopwatchLog = new long[T];
			int tCount = 0;
			while (tCount < T)
			{
				long start = System.nanoTime();
				count = 0;
				perc = new PercolationQuick(N);
				while (perc.percolates() == false)
				{
					int rand = (1 + (int)(Math.random() * ((N*N - 2) + 1)));
					//System.out.println(rand);
					if (perc.openFromRandom(rand) == true)
					{
						count++;
					}
				}
				
				arr[tCount] = count;
				//System.out.println(count);
				long estTime = System.nanoTime() - start;
				stopwatchLog[tCount] = estTime;
				tCount++;
			}
	//		**OUTPUT BELOW**
	//
	//		mean threshold=the_threshold_value
	//
	//		std dev=the_threshold_stddev
	//
	//		time=total_time_in_seconds
	//
	//		mean time=mean_time_in_seconds
	//
	//		stddev time=stddev_time_in_second
			System.out.println();
			System.out.println("**OUTPUT BELOW**");
			double mean = findMean(arr);
			System.out.println("mean threshold=" + mean);
			double stdDev = findStdDdev(arr);
			System.out.println("std dev=" + stdDev);
			double totalTime = findTotal(stopwatchLog);
			System.out.println("time=" + totalTime/1000000000);
			double meanTime = findMean(stopwatchLog);
			System.out.println("mean time=" + meanTime/1000000000);
			double stdDevTime = findStdDev(stopwatchLog);
			System.out.println("stddev time=" + stdDevTime/1000000000);
		}
	}

	private static double findStdDev(long[] stopwatchLog) {
		// TODO Auto-generated method stub
		double mean = findMean(stopwatchLog);
		double[] newarr = new double[stopwatchLog.length];
		for (int i = 0; i < stopwatchLog.length; i ++)
		{
			double num = Math.pow(stopwatchLog[i] - mean, 2);
			newarr[i] = num;
		}
	
		double newMean = findMean(newarr);
		return Math.sqrt(newMean);
	}

	private static double findMean(long[] stopwatchLog) {
		// TODO Auto-generated method stub
		int length = stopwatchLog.length;
		double total = 0;
		for (int i = 0; i < length; i++)
		{
			total += (double)stopwatchLog[i];
		}
		
		return total/(double)(length);
	}

	private static double findTotal(long[] stopwatchLog) 
	{
		// TODO Auto-generated method stub
		double total = 0;
		for (int i = 0; i < stopwatchLog.length; i++)
		{
			total += (double)stopwatchLog[i];
		}
		return total;
	}
}