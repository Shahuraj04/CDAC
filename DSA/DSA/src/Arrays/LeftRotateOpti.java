package Arrays;

import java.lang.reflect.Array;

public class LeftRotateOpti {

	static void reverse(int[] arr,int start,int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end]= temp;
			
			start++;
			end--;
		}
		
	}
	public static void  rotateByD(int[] arr,int n,int d ) {
		d=d%n;
		reverse(arr, 0, d-1);
		reverse(arr, d, n-1);
		reverse(arr, 0, n-1);
		
	}
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5};
		rotateByD(arr, arr.length, 2);
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
