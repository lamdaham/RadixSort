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


	public static void radixSortSimple(SortableLinkedList data) {
		SortableLinkedList[] bucket = new SortableLinkedList[10];
		SortableLinkedList trash = new SortableLinkedList();
		for (int i= 0;i<10 ;i++ ) {
			bucket[i] = new SortableLinkedList();
		}
		int maxLength = 0;
		for (int i = 0; i<data.size(); i++) {
			if (Math.abs(data.get(i))>maxLength) {
				maxLength = length(Math.abs(data.get(i)));
			}
		}
		for(int counter=0;counter<=maxLength; counter++){
			for (int i = 0; i<data.size(); i++) {
				(bucket[Math.abs(nth(data.get(i), counter))]).add(data.get(i));
			}
			trash.extend(data);
			merge(data, bucket);
		}
	}
	
	public static void radixSort(SortableLinkedList data) {
		SortableLinkedList positives = new SortableLinkedList();
		SortableLinkedList negatives = new SortableLinkedList();
		SortableLinkedList trash = new SortableLinkedList();
		for(int i = 0; i<data.size(); i++) {
			if (data.get(i)>=0) {
				positives.add(data.get(i));
			} else {
				negatives.add(data.get(i));
			}
		}
		radixSortSimple(positives);
		radixSortSimple(negatives);
		trash.extend(data);
		for (int i = 0;i<negatives.size();i++) {
			data.add(0, negatives.get(i));
		}
		data.extend(positives);

	}


}