package solutions.exams.week1;

public class Runner {
	/**
	 * checks if a given integer is a palindrom
	 * @param num an integer
	 * @return true if num is a palindrom, false otherwise.
	 */
	public static boolean isPalindrom(int num) {
		int numCopy = num;
		int numReversed = 0;

		while (numCopy > 0) {
			numReversed *= 10;
			numReversed += numCopy % 10;
			numCopy /= 10;
		}
		return num == numReversed;
	}
	/**
	 * summarizes the elements of a given array
	 * @param arr an array of integers
	 * @return the sum of the array
	 */
	public static int getArrSum(int[] arr) {
		int sum = 0;
		for (var elem : arr)
			sum += elem;
		return sum;
	}
	/**
	 * concatenates the array with the larger sum to the other array and adds 2 elements
	 * to the concatenated array arr. arr[n-2] is the sum of sums and arr[n-1] is the absolute
	 * difference of the sums 
	 * @param arr1 an array of int elements
	 * @param arr2 an array of int elements
	 * @return the concatenated array of type int elements
	 */
	public static int[] concatBySumAndDiff(int[] arr1, int[] arr2) {
			
		int[] concatArr = new int[arr1.length + arr2.length + 2];
		int sum1 = getArrSum(arr1);
		int sum2 = getArrSum(arr2);
		int[] highSumArr = arr1;
		int[] smallSumArr = arr2;

		if (sum1 < sum2) {
			highSumArr = arr2;
			smallSumArr = arr1;
		}

		for (int i = 0; i < highSumArr.length; i++)
			concatArr[i] = highSumArr[i];
		for (int i = 0; i < smallSumArr.length; i++)
			concatArr[i + highSumArr.length] = smallSumArr[i];

		concatArr[concatArr.length - 2] = sum1 + sum2;
		concatArr[concatArr.length - 1] = Math.abs(sum1-sum2);

		return concatArr;
	}
}
