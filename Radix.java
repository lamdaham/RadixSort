import java.lang.Math;

public class Radix extends MyLinkedList{

	public static int nth(int n, int col) {
		return (int)((n%(Math.pow(10,(col+1))))/Math.pow(10, col));
	}

	public static int length(int n) {
		return (""+n).length();
	}

	public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
		for (int i = 0; i<buckets.length ; i++ ) {
			original.extend(buckets[i]);	
		}
	}

}