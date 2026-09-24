package Lab_3;

public class Ex_3 {
	// O(n)
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int[] reverse = reverseArray(arr);
		System.out.println(java.util.Arrays.toString(reverse));
	}
	
	public static int[] reverseArray(int[] arr) {
	    int[] reverse = new int[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	        reverse[i] = arr[arr.length - 1 - i];
	    }
	    return reverse;
	}

}
