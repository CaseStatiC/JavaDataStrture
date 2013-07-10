public class InsertSort {

	private long[] array;
	private int nElums;

	public InsertSort(int max) {
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

	public void insertSort() {
		int out, in;
		for (out = 1; out < nElums; out++) {
			long temp = array[out];//temp是标识元素
			in = out;
			while (in > 0 && array[in - 1] >= temp) {// 当有一个元素小于的时候，就插入到哪个元素的位置区
				array[in] = array[in - 1];// 移动，
				--in;
			}
			array[in] = temp;//插入
		}
	}

	public static void main(String[] args) {
		InsertSort s = new InsertSort(20);

		s.insert(2);
		s.insert(5);
		s.insert(7);
		s.insert(9);
		s.insert(12);
		s.insert(3);
		s.insert(6);

		s.display();

		s.insertSort();

		s.display();
	}
}
