package Day1;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		rotateArray(arr, 8);

		System.out.println(Arrays.toString(arr));

	}

	private static void rotateArray(int[] arr, int i) {

		int n = arr.length;

		i %= n;

		reverseArray(arr, 0, i - 1);

		reverseArray(arr, i, n - 1);

		reverseArray(arr, 0, n - 1);

	}

	private static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;

		}

	}

}
