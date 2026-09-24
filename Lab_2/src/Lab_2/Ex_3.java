package Lab_2;

public class Ex_3 {

	public static void main(String[] args) {
		
		int[] short_array = new int[1000];
		int[] long_array = new int[1000000];
		
		for (int i=0; i<short_array.length; i++) {
			short_array[i] = i;
		}
		
		for (int i=0; i<long_array.length; i++) {
			long_array[i] = i;
		}
		
		int[] queries = {20,50,65,2648,85,1,856,585148,184,174,884,18451,98844,4,80,0};
		
		double time_short = measureTime(short_array, queries);
		double time_long = measureTime(long_array, queries);
		
		System.out.println("Batch Lookup Timing Results");
        System.out.println("--------------------------------");
        
        System.out.println("Array size: 1,000");
        System.out.println("Queries: " + time_short + " ns");
        System.out.println("Array size: 1,000,000");
        System.out.println("Queries: " + time_long + " ns");

	}
	
	public static double measureTime(int[] array, int[] queries) {
		
		for (int i=0; i<500; i++ ) {
			for (int query : queries) {
				binarySearch(array, query);
			}
		}
		
		long[] samples = new long[10];
		
		for (int i=0; i<10; i++) {
			long start = System.nanoTime();
			for (int query : queries) {
				binarySearch(array, query);
			}
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
