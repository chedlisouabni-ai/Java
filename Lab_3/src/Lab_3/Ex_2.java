package Lab_3;

public class Ex_2 {
	// O(n)
	public static void main(String[] args) {
		int[] arr = {-15, 42, 7, 89, -3, 25, 61, 12};
		System.out.println(maxArray(arr));
	}
	
	public static int  maxArray(int[] arr) {
		int max = arr[0];
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
