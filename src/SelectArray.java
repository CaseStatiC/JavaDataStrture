public class SelectArray {

	private long[] array;
	private int nElums;

	public SelectArray(int max) {
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

	public void selectSort() {
		int in, out, min;
		for (out = 0; out < nElums - 1; out++) {
			min = out;// 假设最小的数据是最左边的，排序好的数据永远在左边
			for (in = out + 1; in < nElums ; in++) {
				if (array[in] > array[min]) {// 如果有比min小的元素则 重置最小的数据位置
					min = in;
				}
			}
			swap(min, out);//交换在out里面，比较次数和冒泡相同，但交换次数更少
		}
	}

	public static void main(String[] args) {
		SelectArray s = new SelectArray(20);

		s.insert(2);
		s.insert(5);
		s.insert(7);
		s.insert(9);
		s.insert(12);
		s.insert(3);
		s.insert(6);

		s.display();

		s.selectSort();

		s.display();
	}
}