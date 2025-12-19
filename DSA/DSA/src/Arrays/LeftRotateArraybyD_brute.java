package Arrays;

import java.lang.reflect.Array;

public class LeftRotateArraybyD_brute {

	static void leftRotate(int arr[],int n ,int d) {
		
		d= d%n;
		int[] temp = new int[d];
		for(int i=0;i<d;i++) {
			temp[i]=arr[i];
		}
		
		for(int i =d;i<n;i++) {
			arr[i-d]=arr[i];
		}
		for(int i=0;i<d;i++) {
			arr[n-d+i]=temp[i];
		}
		
	}
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6};
		leftRotate(arr, 6, 2);
		for(int a : arr) {
			System.out.print(a+"--");
		}
		
	}
	

}
