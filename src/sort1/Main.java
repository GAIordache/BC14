package sort1;

import java.util.Arrays;
import java.util.Random;

public class Main {
// https://www.geeksforgeeks.org/sorting-algorithms/#Basic
	public static void main(String[] args) {
		int[] intArray = new int[1000000];
		Random rnd = new Random();
		for(int i=0;i < intArray.length;i++) {
			intArray[i] = rnd.nextInt(1000);
		}
		long stime = System.currentTimeMillis();
		for(int i=0;i < 1000000;i++) {
			int searchValue = rnd.nextInt(1000);
			int idx = -1;
			// fiecare cautare ~ N - lungime array
			for(int k=0;k < intArray.length;k++) {
				if(intArray[k] == searchValue) {
					idx = k;
					break;
				}
			}
		}
		long etime = System.currentTimeMillis();
		System.out.println("Duration:" + (etime-stime)*1.0/1000);
		System.out.println("Varianta optimala");
		stime = System.currentTimeMillis();
		Arrays.sort(intArray);
		for(int i=0;i < 1000000;i++) {
			int searchValue = rnd.nextInt(1000);
			// fiecare cautare ~ ln(N) - N == lungime array
			int idx = Arrays.binarySearch(intArray, searchValue);
		}
		etime = System.currentTimeMillis();
		System.out.println("Duration:" + (etime-stime)*1.0/1000);

	}

}
