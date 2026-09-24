package Lab_2;

public class Ex_5 {

    public static void main(String[] args) {

        int n = 30;

        double timeRecursive = measureRecursive(n);

        double timeLoop = measureLoop(n);

        int resultRecursive = Fibonacci_recursive(n);
        int resultLoop = Fibonacci_loop(n);

        System.out.println("Nth Fibonacci Number Timing Results");
        System.out.println("--------------------");

        System.out.println("n = " + n);

        System.out.println();
        System.out.println("Recursive:");
        System.out.println("Result: " + resultRecursive);
        System.out.println("Average time: " + timeRecursive + " ns");

        System.out.println();
        System.out.println("Iterative:");
        System.out.println("Result: " + resultLoop);
        System.out.println("Average time: " + timeLoop + " ns");
    }

    public static int Fibonacci_recursive(int n) {

        if (n <= 1) {
            return n;
        }

        return Fibonacci_recursive(n - 1) + Fibonacci_recursive(n - 2);
    }

    public static int Fibonacci_loop(int n) {

        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {

            int next = a + b;

            a = b;
            b = next;
        }

        return b;
    }

    public static double measureRecursive(int n) {

        for (int i = 0; i < 500; i++) {
            Fibonacci_recursive(n);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {

            long start = System.nanoTime();

            Fibonacci_recursive(n);

            long end = System.nanoTime();

            samples[i] = end - start;
        }

        long sum = 0;

        for (int i = 0; i < samples.length; i++) {
            sum += samples[i];
        }

        return (double) sum / samples.length;
    }

    public static double measureLoop(int n) {

        for (int i = 0; i < 500; i++) {
            Fibonacci_loop(n);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {

            long start = System.nanoTime();

            Fibonacci_loop(n);

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