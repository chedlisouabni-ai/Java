package Lab_3;
import java.util.Arrays;

public class Ex_4 {
    // n = A.length ; m = B.length
    // Naive: O(n × m)
    // Efficient: O(n log(n) + m log(m))
    public static void main(String[] args) {

        int[] A1000 = new int[1000];
        int[] B1000 = new int[1000];

        int[] A20000 = new int[20000];
        int[] B20000 = new int[20000];

        for (int i = 0; i < 1000; i++) {
            A1000[i] = i;
            B1000[i] = i + 500;
        }

        for (int i = 0; i < 20000; i++) {
            A20000[i] = i;
            B20000[i] = i + 10000;
        }

        double naive1000 = measureTimeNaive(A1000, B1000);
        double naive20000 = measureTimeNaive(A20000, B20000);

        double efficient1000 = measureTimeEfficient(A1000, B1000);
        double efficient20000 = measureTimeEfficient(A20000, B20000);

        System.out.println("===== Size 1000 =====");
        System.out.println("Naive O(n*m): " + naive1000 + " ns");
        System.out.println("Efficient O(n log n + m log m): " + efficient1000 + " ns");

        System.out.println();

        System.out.println("===== Size 20000 =====");
        System.out.println("Naive O(n*m): " + naive20000 + " ns");
        System.out.println("Efficient O(n log n + m log m): " + efficient20000 + " ns");
    }

    public static int[] intersectionNaive(int[] A, int[] B) {

        int count = 0;

        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < B.length; j++) {

                if (A[i] == B[j]) {
                    count++;
                    break;
                }
            }
        }

        int[] inter = new int[count];

        int k = 0;

        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < B.length; j++) {

                if (A[i] == B[j]) {
                    inter[k] = A[i];
                    k++;
                    break;
                }
            }
        }

        return inter;
    }

    public static int[] intersectionEfficient(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < A.length && j < B.length) {

            if (A[i] == B[j]) {
                count++;
                i++;
                j++;
            }
            else if (A[i] < B[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        int[] inter = new int[count];

        i = 0;
        j = 0;
        int k = 0;

        while (i < A.length && j < B.length) {

            if (A[i] == B[j]) {
                inter[k] = A[i];
                k++;
                i++;
                j++;
            }
            else if (A[i] < B[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        return inter;
    }

    public static double measureTimeNaive(int[] A, int[] B) {

        for (int i = 0; i < 500; i++) {
            int[] copyA = Arrays.copyOf(A, A.length);
            int[] copyB = Arrays.copyOf(B, B.length);

            intersectionNaive(copyA, copyB);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {

            int[] copyA = Arrays.copyOf(A, A.length);
            int[] copyB = Arrays.copyOf(B, B.length);

            long start = System.nanoTime();

            intersectionNaive(copyA, copyB);

            long end = System.nanoTime();

            samples[i] = end - start;
        }

        long sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += samples[i];
        }

        return (double) sum / samples.length;
    }

    public static double measureTimeEfficient(int[] A, int[] B) {

        for (int i = 0; i < 500; i++) {
            int[] copyA = Arrays.copyOf(A, A.length);
            int[] copyB = Arrays.copyOf(B, B.length);

            intersectionEfficient(copyA, copyB);
        }

        long[] samples = new long[10];

        for (int i = 0; i < 10; i++) {

            int[] copyA = Arrays.copyOf(A, A.length);
            int[] copyB = Arrays.copyOf(B, B.length);

            long start = System.nanoTime();

            intersectionEfficient(copyA, copyB);

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