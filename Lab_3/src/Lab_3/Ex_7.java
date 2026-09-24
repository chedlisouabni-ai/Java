package Lab_3;
import java.util.Arrays;

public class Ex_7 {
    // Naive: O(n^2)
    // Efficient: O(n log n)
    public static void main(String[] args) {

        int[] A500 = new int[500];
        int[] A10000 = new int[10000];

        for (int i = 0; i < 500; i++) {
            A500[i] = i % 100;
        }

        for (int i = 0; i < 10000; i++) {
            A10000[i] = i % 1000;
        }

        double naive500 = measureTimeNaive(A500);
        double naive10000 = measureTimeNaive(A10000);

        double efficient500 = measureTimeEfficient(A500);
        double efficient10000 = measureTimeEfficient(A10000);

        System.out.println("===== Size 500 =====");
        System.out.println("Naive O(n^2): " + naive500 + " ns");
        System.out.println("Efficient O(n log n): " + efficient500 + " ns");

        System.out.println();

        System.out.println("===== Size 10,000 =====");
        System.out.println("Naive O(n^2): " + naive10000 + " ns");
        System.out.println("Efficient O(n log n): " + efficient10000 + " ns");
    }

    public static int[] removeDuplicatesNaive(int[] A) {

        int index = 0;

        int[] distincts = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            boolean alreadyCounted = false;

            for (int j = 0; j < index; j++) {

                if (A[i] == distincts[j]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {
                distincts[index] = A[i];
                index++;
            }
        }

        int[] result = new int[index];

        for (int i = 0; i < index; i++) {
            result[i] = distincts[i];
        }

        return result;
    }

    public static int[] removeDuplicatesEfficient(int[] A) {

        Arrays.sort(A);

        int index = 0;

        int[] distincts = new int[A.length];

        distincts[0] = A[0];
        index++;

        for (int i = 1; i < A.length; i++) {

            if (A[i] != distincts[index - 1]) {

                distincts[index] = A[i];
                index++;
            }
        }

        int[] result = new int[index];

        for (int i = 0; i < index; i++) {
            result[i] = distincts[i];
        }

        return result;
    }

    public static double measureTimeNaive(int[] A) {

        for (int i = 0; i < 500; i++) {

            int[] copy = Arrays.copyOf(A, A.length);

            removeDuplicatesNaive(copy);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {

            int[] copy = Arrays.copyOf(A, A.length);

            long start = System.nanoTime();

            removeDuplicatesNaive(copy);

            long end = System.nanoTime();

            samples[i] = end - start;
        }

        long sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += samples[i];
        }

        return (double) sum / samples.length;
    }

    public static double measureTimeEfficient(int[] A) {

        for (int i = 0; i < 500; i++) {

            int[] copy = Arrays.copyOf(A, A.length);

            removeDuplicatesEfficient(copy);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {

            int[] copy = Arrays.copyOf(A, A.length);

            long start = System.nanoTime();

            removeDuplicatesEfficient(copy);

            long end = System.nanoTime();

            samples[i] = end - start;
        }

        long sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += samples[i];
        }

        return (double) sum / samples.length;
    }
}