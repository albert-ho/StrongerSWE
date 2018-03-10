import java.util.*;

public class HelloWorld {

	// Consider swapping inside arr to save space later
	/*
	private static int[] sort(int[] arr, int start, int end) {
		
	}*/

	public static int[] sort(int[] arr) {
		int n = arr.length;
		if (n == 1) {
			return arr;
		}
		int[] left = sort(Arrays.copyOfRange(arr, 0, n/2));
		int[] right = sort(Arrays.copyOfRange(arr, n/2, n));
		int[] merged = new int[n];
		int i = 0; int j = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				merged[i+j] = left[i];
				i++;
			}
			else {
				merged[i+j] = right[j];
				j++;
			}
		}
		while (i < left.length) {
			merged[i+j] = left[i];
			i++;
		}
		while (j < right.length) {
			merged[i+j] = right[j];
			j++;
		}
		return merged;
	}

	public static void main(String[] args) {
		int n = 100000;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int)(n*Math.random());
		}
		int[] sortedArr = sort(arr);
		System.out.println(Arrays.toString(sortedArr));
		//System.out.println("Hello World!");
	}
}