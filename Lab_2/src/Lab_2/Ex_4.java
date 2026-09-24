package Lab_2;

public class Ex_4 {

	public static void main(String[] args) {
		
		double nb1 = measureTime(5);
		double nb2 = measureTime(1255);
		
		System.out.println("Factorial Timing Results");
        System.out.println("--------------------------------");
        
        System.out.println("Small Integer: " + nb1 + " ns");
        System.out.println("Large Integer: " + nb2 + " ns");
        
	}
	
	public static long factorial(int n) {
		long result = 1;
		while (n>1) {
			result = result * n;
			n = n-1;
		}
		return result;
	}
	
	public static double measureTime(int n) {

        for (int i = 0; i < 500; i++) {
            factorial(n);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            factorial(n);
            long end = System.nanoTime();
            samples[i] = end - start;
        }

        long sum = 0;

        for (int i = 0; i < samples.length; i++) {
            sum += samples[i];
        }

        return (double) sum / samples.length;
    }

}
