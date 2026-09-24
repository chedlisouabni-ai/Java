package Lab_3;

public class Ex_1 {
	// O(n)
	public static void main(String[] args) {
		String[] arr = {"apple", "banana", "orange", "computer", "python", "football", "university", "coffee", "tiger", "mountain"};
		System.out.println(searchArray(arr, "apple"));
		System.out.println(searchArray(arr, "python"));
		System.out.println(searchArray(arr, "pizza"));
		System.out.println(searchArray(arr, "tiger"));     
	}
	
	public static boolean searchArray(String[] arr, String target) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i].equals(target)) {
				return true;
			}
		}
		return false;
	}

}
