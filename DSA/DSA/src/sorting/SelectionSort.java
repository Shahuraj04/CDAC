package sorting;

import java.util.Iterator;

public class SelectionSort {
	static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
				
			}
			int temp= arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}

	}

	public static void main(String[] args) {
		int[] arr = {8,9,5,7,52,8};
		selectionSort(arr);
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
