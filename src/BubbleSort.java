public class BubbleSort {

	private long[] array;
	private int nElums;

	public BubbleSort(int max) {
		array = new long[max];
		nElums = 0;
	}

	public void insert(long value) {
		array[nElums] = value;
		nElums++;
	}

	public void display() {
		for (int i = 0; i < nElums; i++) {
			System.out.println(array[i]);
		}
	}

	public void swap(int one, int two) {
		long tmp = array[one];
		array[one] = array[two];
		array[two] = tmp;
	}

	public void bubbleSort() {
		for (int out = nElums - 1; out > 1; out--) {// 比较N-1趟
			for (int in = 0; in < out; in++) {//最后一个是已经排序好的
				if (array[in] < array[in + 1]) {
					swap(in, in + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		BubbleSort s = new BubbleSort(20);
		
		s.insert(2);
		s.insert(5);
		s.insert(7);
		s.insert(9);
		s.insert(12);
		s.insert(3);
		s.insert(6);
		
		s.display();
		
		s.bubbleSort();
		
		s.display();
	}
}
