package Lab_2;

public class Ex_1 {

    public static void main(String[] args) {

        String short_string = "ABCDEFGHIJ"; 
        String long_string = "A".repeat(100000); 

        double time_short = measureTime(short_string);
        double time_long = measureTime(long_string);

        System.out.println("First Letter Lookup Timing Results");
        System.out.println("-----------------------------------");

        System.out.println("String length: 10");
        System.out.println("First character: " + short_string.substring(0, 1));
        System.out.println("Average time: " + time_short + " ns");

        System.out.println();

        System.out.println("String length: 100,000");
        System.out.println("First character: " + long_string.substring(0, 1));
        System.out.println("Average time: " + time_long + " ns");
    }

    public static double measureTime(String string) {

        for (int i = 0; i < 500; i++) {
            string.substring(0, 1);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            string.substring(0, 1);
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