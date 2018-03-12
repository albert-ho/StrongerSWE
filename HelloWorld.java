import java.util.*;

class SortUtils {

	//-------------------------------------------------------------------------
	// METHODS FOR MERGESORT
	//-------------------------------------------------------------------------

	// Merge two sorted arrays into one sorted array
	private static int[] merge(int[] left, int[] right) {
		int llen = left.length; int rlen = right.length;
		int[] merged = new int[llen + rlen];
		int i = 0; int j = 0;
		while (i < llen && j < rlen) {
			if (left[i] <= right[j]) {
				merged[i+j] = left[i];
				i++;
			}
			else {
				merged[i+j] = right[j];
				j++;
			}
		}
		while (i < llen) {
			merged[i+j] = left[i];
			i++;
		}
		while (j < rlen) {
			merged[i+j] = right[j];
			j++;
		}
		return merged;
	}

	// Merge Sort
	private static int[] mergeSort(int[] arr) {
		int n = arr.length;
		if (n == 1) {
			return arr;
		}
		int[] left = sort(Arrays.copyOfRange(arr, 0, n/2));
		int[] right = sort(Arrays.copyOfRange(arr, n/2, n));
		int[] merged = merge(left, right);
		return merged;
	}

	//-------------------------------------------------------------------------
	// METHODS FOR QUICKSORT
	//-------------------------------------------------------------------------

	// Swap values in array
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// All values less than pivot are to its left
	// All values greater than pivot are to its right
	private static int quickStable(int[] arr, int i, int j) {
		int pivot = (int)(Math.random()*(j-i+1))+i;
		swap(arr, i, pivot);
		pivot = i; 
		i++;
		while (i <= j) {
			if (arr[i] < arr[pivot]) {
				swap(arr, pivot, i);
				pivot++;
				i++; 
			}
			else if (arr[i] == arr[pivot]) {
				i++;
			}
			else {
				swap(arr, i, j);
				j--;
			}
		}
		return pivot;
	}

	// Quicksort in-place (end is inclusive into the index)
	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end) return;
		int pivot = quickStable(arr, start, end);
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot+1, end);
	}

	private static int[] quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
		return arr;
	}

	public static int[] sort(int[] arr) {
		//return quickSort(arr);
		return mergeSort(arr);
	}
}

public class HelloWorld {

	public static void main(String[] args) {
		int n = 1000000;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random()*n);
		}
		int[] sortedArr = SortUtils.sort(arr);
		System.out.println(Arrays.toString(sortedArr));
		//System.out.println("Hello World!");
	}
}