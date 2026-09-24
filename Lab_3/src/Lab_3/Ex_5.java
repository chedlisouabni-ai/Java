package Lab_3;

public class Ex_5 {
	// O(n)
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 6, 7};
		System.out.println(calculateProductOfEven(arr));
	}
	
	public static int calculateProductOfEven(int[] arr) {
		int product = 1;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]%2 == 0) {
				product *= arr[i];
			}
		}
		return product;
	}

}
