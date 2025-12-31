package sorting;

public class BubbleSort {
	
	static void bubbbleSort(int[] arr) {
		int n = arr.length;
		for(int i = 0;i<n-1;i++) {
			boolean swapped = false;
			
			for(int j=0;j<n-2;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
		
	}
	public static void main(String[] args) {
		int[] arr = {1,8,9,2,7};
		bubbbleSort(arr);
		for(int i : arr ) {
			System.out.println(i+" ");
		}
	}

}
