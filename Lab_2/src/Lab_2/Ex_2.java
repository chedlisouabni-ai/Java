package Lab_2;

public class Ex_2 {

	public static void main(String[] args) {
		
		int[] short_array = new int[1000];
		int[] long_array = new int[1000000];
		
		for (int i=0; i<short_array.length; i++) {
			short_array[i] = i;
		}
		
		for (int i=0; i<long_array.length; i++) {
			long_array[i] = i;
		}
		
		int bcs = 499;
		int wcs = 1001;
		
		int bcl = 499999;
		int wcl = 1000001;
		
		double time_short_best = measureTime(short_array, bcs);
		double time_short_worst = measureTime(short_array, wcs);
		double time_long_best = measureTime(long_array, bcl);
		double time_long_worst = measureTime(long_array, wcl);
		
		System.out.println("Binary Search Timing Results");
        System.out.println("--------------------------------");

        System.out.println("Array size: 1,000");
        System.out.println("Target present: " + time_short_best + " ns");
        System.out.println("Target absent:  " + time_short_worst + " ns");

        System.out.println();

        System.out.println("Array size: 1,000,000");
        System.out.println("Target present: " + time_long_best + " ns");
        System.out.println("Target absent:  " + time_long_worst + " ns");
		
	}
		
	public static double measureTime(int[] array, int target) {
		
		for (int i=0; i<500; i++ ) {
			binarySearch(array, target);
		}
		
		long[] samples = new long[10];
		
		for (int i=0; i<10; i++) {
			long start = System.nanoTime();
			binarySearch(array, target);
			long end = System.nanoTime();
			samples[i] = end - start;
		}
		
		long sum = 0;
		
		for(int i=0; i<10; i++) {
			sum += samples[i];
		}
		
		return (double) sum / samples.length;
	}
	
	
	
	public static int binarySearch(int[] array, int target) {
		 
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right) {
			
			int middle = (left + right) / 2;
			
			if (array[middle] == target) {
				return middle;
			}
			
			if (array[middle] < target) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		
		return -1; 
	}
	
}