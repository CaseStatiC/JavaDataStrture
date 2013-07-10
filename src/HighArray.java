//不支持重复元素
public class HighArray {

	private long[] array;
	private int nElums;

	public HighArray(int max) {// 最大容量为max
		array = new long[max];
		nElums = 0;// 存储多少个元素
	}

	public void insert(long value) {
		array[nElums] = value;
		nElums++;// 这里注意添加了
	}

	public boolean find(long searchKey) {
		for (int i = 0; i < nElums; i++) {
			if (array[i] == searchKey) {
				return true;
			}
		}
		return false;

	}

	public boolean delete(long value) {

		int i;
		for (i = 0; i < nElums; i++) {// 查找
			if (array[i] == value) {
				break;
			}
			if (i == nElums) {
				return false;
			}
		}
		for (int j = i; j < nElums; j++) {// 高位后移
			array[j] = array[j + 1];
		}
		nElums--;// 元素书减一
		return true;

	}

	public void display() {
		for (int i = 0; i < nElums; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		HighArray array = new HighArray(10);

		array.insert(0);
		array.insert(1);
		array.insert(1);
		array.insert(3);
		array.insert(5);
		array.insert(8);
		array.insert(9);
		array.insert(10);

		array.display();

		System.out.println(array.find(1));
		System.out.println(array.find(7));

		System.out.println(array.delete(1));
		array.display();

	}
}
