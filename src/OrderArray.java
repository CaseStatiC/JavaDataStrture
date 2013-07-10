//升序排列
public class OrderArray {

	private long[] array;
	private int nElums;

	public OrderArray(int max) {
		array = new long[max];
		nElums = 0;
	}

	public void insert(long value) {
		int i;
		for (i = 0; i < nElums; i++) {// 查找，从低位到高位
			if (value < array[i]) {
				break;
			}
		}
		for (int j = nElums; j > i; j--) {// 高位后移，从高位到低位
			array[j] = array[j - 1];
		}
		array[i] = value;// 插入值
		nElums++;// 元素添加
	}

	public int size() {
		return nElums;
	}

	public int find(long serachKey) {

		int lowerBound = 0;
		int upperBound = nElums - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;// 取整 二分
			if (serachKey == array[curIn]) {// 比较
				return curIn;
			} else {
				if (lowerBound > upperBound) {// 跳出循环
					return nElums;
				} else {
					if (array[curIn] > serachKey) {
						upperBound = curIn - 1;// 注意 与1的关系
					} else {
						lowerBound = curIn + 1;
					}
				}
			}

		}
	}

	public boolean delete(long value) {
		int i;
		i = find(value);
		if (i == nElums) {// 没有查找到返回false
			return false;
		} else {
			for (int j = i; j < nElums; j++) {// 高位后移
				array[j] = array[j + 1];
			}
			nElums--;// 元素书减一
			return true;
		}
	}
	
	public void display() {
		for (int i = 0; i < nElums; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		OrderArray array = new OrderArray(10);

		array.insert(0);
		array.insert(1);
		array.insert(1);
		array.insert(3);
		array.insert(5);
		array.insert(8);
		array.insert(9);
		array.insert(10);

		array.display();

		System.out.println(array.find(9));
		System.out.println(array.find(7));

		System.out.println(array.delete(1));
		array.display();

	}
}
