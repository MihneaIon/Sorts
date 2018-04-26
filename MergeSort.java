package merge;

import java.util.Random;

public class MergeSort {

	void merge(Integer arr[], int l, int m, int r) {
		
		
		
		
		int n1 = m - l + 1;
		int n2 = r - m;

		
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
	}


	void sort(Integer arr[], int l, int r) {
		
		
		if (l < r) {
			
			int m = (l + r) / 2;

			
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge-uieste aa 2-a jumatate
			merge(arr, l, m, r);
		}
		
	
	}
	
	public Integer[] returnVector(int n)
	{
		Integer[] myVector = new Integer[n];
		for (int i = 0; i < myVector.length; i++) {
			myVector[i] = randomFill();
		}
		return myVector;
	}
	
	public int randomFill()
	{
		Random random = new Random();
		int randomNum = random.nextInt();
		return randomNum;
	}

	public void runAplication(Integer n)
	{
		long startTime = System.currentTimeMillis();
		Integer[] array=returnVector(n);
		sort(array, 0, array.length-1);
		
	long stopTime = System.currentTimeMillis();
		
		long dif = 0;
		dif = (stopTime - startTime) ;
		System.out.println("Aici este diferenta " + dif);

		
	}
}
