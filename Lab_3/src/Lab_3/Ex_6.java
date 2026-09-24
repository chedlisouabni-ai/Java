package Lab_3;

public class Ex_6 {
	//O(n**2)
    public static void main(String[] args) {

        int[] A = {2, 4, 2, 7, 4, 4};

        int duplicates = numberOfDuplicates(A);
        int distinct = numberOfDistinctValues(A);

        System.out.println("Number of duplicates: " + duplicates);
        System.out.println("Number of distinct values: " + distinct);
    }

    public static int numberOfDuplicates(int[] A) {

        int count = 0;
        int[] counted = new int[A.length];
        int countedSize = 0;

        for (int i = 0; i < A.length; i++) {

            boolean alreadyCounted = false;

            for (int j = 0; j < countedSize; j++) {
                if (A[i] == counted[j]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {

                int occurrence = 0;

                for (int j = 0; j < A.length; j++) {
                    if (A[i] == A[j]) {
                        occurrence++;
                    }
                }

                if (occurrence > 1) {
                    count++;
                }

                counted[countedSize] = A[i];
                countedSize++;
            }
        }

        return count;
    }

    public static int numberOfDistinctValues(int[] A) {

        int count = 0;
        int[] counted = new int[A.length];
        int countedSize = 0;

        for (int i = 0; i < A.length; i++) {

            boolean alreadyCounted = false;

            for (int j = 0; j < countedSize; j++) {
                if (A[i] == counted[j]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {
                count++;

                counted[countedSize] = A[i];
                countedSize++;
            }
        }

        return count;
    }
}