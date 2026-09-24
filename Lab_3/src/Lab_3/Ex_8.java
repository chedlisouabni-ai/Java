package Lab_3;
import java.util.Arrays;
import java.util.Random;

public class Ex_8 {
	// Bubble Sort: O(n**2)
	// Selection Sort: O(n**2)
	// Insertion Sort: O(n**2)
	// Merge Sorted Arrays: O(n)
	// Merge Sort: O(n log n)
	public static void main(String[] args) {

	    Random random = new Random();

	    int[] A500 = new int[500];
	    int[] A2000 = new int[2000];
	    int[] A10000 = new int[10000];

	    for (int i = 0; i < A500.length; i++) {
	        A500[i] = random.nextInt(10000);
	    }

	    for (int i = 0; i < A2000.length; i++) {
	        A2000[i] = random.nextInt(10000);
	    }

	    for (int i = 0; i < A10000.length; i++) {
	        A10000[i] = random.nextInt(10000);
	    }


	    System.out.println("===== Size 500 =====");

	    System.out.println("Bubble Sort: " + measureTime(A500, 1) + " ns");

	    System.out.println("Selection Sort: " + measureTime(A500, 2) + " ns");

	    System.out.println("Insertion Sort: " + measureTime(A500, 3) + " ns");

	    System.out.println("Merge Sort: " + measureTime(A500, 4) + " ns");


	    System.out.println("\n===== Size 2,000 =====");

	    System.out.println("Bubble Sort: " + measureTime(A2000, 1) + " ns");

	    System.out.println("Selection Sort: " + measureTime(A2000, 2) + " ns");

	    System.out.println("Insertion Sort: " + measureTime(A2000, 3) + " ns");

	    System.out.println("Merge Sort: " + measureTime(A2000, 4) + " ns");


	    System.out.println("\n===== Size 10,000 =====");

	    System.out.println("Bubble Sort: " + measureTime(A10000, 1) + " ns");

	    System.out.println("Selection Sort: " + measureTime(A10000, 2) + " ns");

	    System.out.println("Insertion Sort: " + measureTime(A10000, 3) + " ns");

	    System.out.println("Merge Sort: " + measureTime(A10000, 4) + " ns");

	    int[] nearlySorted = new int[10000];

	    for (int i = 0; i < nearlySorted.length; i++) {
	        nearlySorted[i] = i;
	    }

	    int temp = nearlySorted[4999];
	    nearlySorted[4999] = nearlySorted[5000];
	    nearlySorted[5000] = temp;


	    System.out.println("\n===== Insertion Sort - Nearly Sorted 10,000 =====");

	    System.out.println("Insertion Sort: " + measureTime(nearlySorted, 3) + " ns");
	}
	
	public static void bubbleSort(int[] A) {

	    for (int i = 0; i < A.length - 1; i++) {

	        for (int j = 0; j < A.length - 1 - i; j++) {

	            if (A[j] > A[j + 1]) {

	                int temp = A[j];
	                A[j] = A[j + 1];
	                A[j + 1] = temp;
	            }
	        }
	    }
	}
	
	public static void selectionSort(int[] A) {

	    for (int i = 0; i < A.length - 1; i++) {

	        int minIndex = i;

	        for (int j = i + 1; j < A.length; j++) {

	            if (A[j] < A[minIndex]) {
	                minIndex = j;
	            }
	        }

	        int temp = A[i];
	        A[i] = A[minIndex];
	        A[minIndex] = temp;
	    }
	}
	
	public static void insertionSort(int[] A) {

	    for (int i = 1; i < A.length; i++) {

	        int key = A[i];

	        int j = i - 1;

	        while (j >= 0 && A[j] > key) {

	            A[j + 1] = A[j];

	            j--;
	        }

	        A[j + 1] = key;
	    }
	}
	
	public static int[] mergeSortedArrays(int[] A, int[] B) {

	    int i = 0;
	    int j = 0;

	    int[] merged = new int[A.length + B.length];

	    for (int k = 0; k < merged.length; k++) {

	        if (i == A.length) {
	            merged[k] = B[j];
	            j++;
	        }
	        else if (j == B.length) {
	            merged[k] = A[i];
	            i++;
	        }
	        else if (A[i] <= B[j]) {
	            merged[k] = A[i];
	            i++;
	        }
	        else {
	            merged[k] = B[j];
	            j++;
	        }
	    }

	    return merged;
	}
	
	public static int[] mergeSort(int[] A) {

	    if (A.length <= 1) {
	        return A;
	    }

	    int mid = A.length / 2;

	    int[] left = Arrays.copyOfRange(A, 0, mid);
	    int[] right = Arrays.copyOfRange(A, mid, A.length);

	    left = mergeSort(left);
	    right = mergeSort(right);

	    return mergeSortedArrays(left, right);
	}
	
	public static double measureTime(int[] A, int algorithm) {

	    for (int i = 0; i < 500; i++) {

	        int[] copy = Arrays.copyOf(A, A.length);

	        if (algorithm == 1) {
	            bubbleSort(copy);
	        }
	        else if (algorithm == 2) {
	            selectionSort(copy);
	        }
	        else if (algorithm == 3) {
	            insertionSort(copy);
	        }
	        else {
	            mergeSort(copy);
	        }
	    }

	    long[] samples = new long[10];

	    for (int i = 0; i < 10; i++) {

	        int[] copy = Arrays.copyOf(A, A.length);

	        long start = System.nanoTime();

	        if (algorithm == 1) {
	            bubbleSort(copy);
	        }
	        else if (algorithm == 2) {
	            selectionSort(copy);
	        }
	        else if (algorithm == 3) {
	            insertionSort(copy);
	        }
	        else {
	            mergeSort(copy);
	        }

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
