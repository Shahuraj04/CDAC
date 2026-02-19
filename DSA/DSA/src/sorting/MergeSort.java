package sorting;

import java.util.Iterator;

public class MergeSort {

	public static void mergeSort(int[] arr,int size) {
			if(size<2)return;
			int mid=size/2;
			int leftArray[] = new int[mid];
			int rightArray[] = new int[size-mid];
			for(int i =0;i<mid;i++)leftArray[i]=arr[i];		
			for(int i=mid;i<size;i++) rightArray[i-mid]=arr[i];
			mergeSort(leftArray,mid);
			mergeSort(rightArray, size-mid);
			merge(arr,leftArray,rightArray,mid,size-mid);
	}	
	
	
	
	  
 	 




	private static void merge(int[] arr, int[] leftArray, int[] rightArray, int left, int right) {
		int i=0;int k=0;int j=0;
		while(i<left && j<right) {
			if(leftArray[i]<rightArray[j]) arr[k++]=leftArray[i++];
			else arr[k++]=rightArray[j++];
		}
		while(i<left) arr[k++]=leftArray[i++];
		while(j<right) arr[k++]=rightArray[j++];
		
	}









	public static void main(String[] args) {
		int[] arr = new int[] {1,2,7,2,8,77,55};
		mergeSort(arr,arr.length);
		for(int i:arr) {
			System.out.println(i);
		}
	}
}
