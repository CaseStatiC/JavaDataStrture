public class PriorityQueue {

	private int maxSize;
	private int nItems;
	private long[] priorityQueue;

	public PriorityQueue(int max) {
		nItems = 0;
		priorityQueue = new long[max];
		maxSize = max;
	}

	public void insert(long value) {
		if (nItems == 0) {// 当没有元素的时候
			priorityQueue[++nItems] = value;
		} else {
			int i;
			for (i = nItems - 1; i >= 0; i--) {// 从后往前一个一个比较
				if (value > priorityQueue[i]) {//大于的时候 往后移一位
					priorityQueue[i + 1] = priorityQueue[i];//
				} else {
					break;
				}

			}
			priorityQueue[i + 1] = value;//赋值
			nItems++;
		}

	}

	public long remove() {
		return priorityQueue[--nItems];
	}

	public boolean isFull() {
		return nItems == maxSize;
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityQueue priorityQueue = new PriorityQueue(10);

		priorityQueue.insert(45);
		priorityQueue.insert(6);
		priorityQueue.insert(5);
		priorityQueue.insert(49);
		priorityQueue.insert(95);
		priorityQueue.insert(9);
		priorityQueue.insert(95);
		while (!priorityQueue.isEmpty()) {
			long vaule = priorityQueue.remove();
			System.out.println(vaule);
		}
	}
}
