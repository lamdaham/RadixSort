import java.lang.Math;

public class Radix extends SortableLinkedList{

	public static int nth(int n, int col) {
		if (Math.pow(10, col)>Math.abs(n)) {
			return 0;
		}
		return Math.abs((int)((n%(Math.pow(10,(col+1))))/Math.pow(10, col)));
	}

	public static int length(int n) {
		return (""+n).length();
	}

	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = 0; i<buckets.length ; i++ ) {
			if (buckets[i]!=null) {
				original.extend(buckets[i]);	
			}	
		}
	}

	public static void reverseMerge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = buckets.length-1; i>0 ; i-- ) {
			if (buckets[i]!=null) {
				original.extend(buckets[i]);	
			}	
		}
	}


	public static void radixSortSimple(SortableLinkedList data) {
		SortableLinkedList[] bucket = new SortableLinkedList[10];
		for (int i= 0;i<10 ;i++ ) {
			bucket[i] = new SortableLinkedList();
		}
		int maxLength = 0;
		boolean max = true;
	
		for(int counter=0;counter<=maxLength; counter++){
			// int passes = 0;
			while (data.size()>0) {
				if (max && length(data.get(0))>maxLength) {
					maxLength = length(data.get(0));
				}
				(bucket[Math.abs(nth(data.get(0), counter))]).add(data.remove(0));
				// passes++;
			}
			max = false;
			merge(data, bucket);
		}
	} 	

	
	public static void radixSort(SortableLinkedList data) {
		SortableLinkedList positives = new SortableLinkedList();
		SortableLinkedList negatives = new SortableLinkedList();
		SortableLinkedList trash = new SortableLinkedList();
		while (data.size()>0) {
			if (data.get(0)>=0) {
				positives.add(data.remove(0));
			} else {
				negatives.add(data.remove(0));
			}
		}
		// System.out.println(positives);
		// System.out.println(negatives);
		if (positives.size()>0) {
			radixSortSimple(positives);
		}
		if (negatives.size()>0) {
			radixSortSimple(negatives);
		}
		while (negatives.size()>0) {
			data.add(0, negatives.remove(0));
		}
		data.extend(positives);

	}


}