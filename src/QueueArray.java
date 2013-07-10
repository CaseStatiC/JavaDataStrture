public class QueueArray {//队列并不连续，而是基于rear和front的移动，添加和删除时候修改数组的大小

	private int maxSize;
	private int front;
	private int rear;
	private int nItems;
	private long[] queueArray;

	public QueueArray(int max) {//利用指针回绕，提高效率
		nItems = 0;
		front = 0;
		rear = -1;
		queueArray = new long[max];
		maxSize = max;
	}

	public void insert(long value) {
		if (rear == maxSize - 1) {//当到了最后一个元素的时候，把他重置到开始位置
			rear = -1;
		}
		queueArray[++rear] = value;
		nItems++;
	}

	public long remove() {
		long value = queueArray[front++];
		if (front == maxSize - 1) {// 循环队列
			front = 0;
		}
		nItems--;
		return value;
	}

	public long peekFront() {
		return queueArray[front];
	}

	public boolean isFull() {
		return nItems == maxSize;
	}
	
	public boolean isEmpty(){
		return nItems ==0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueArray queueArray = new QueueArray(10);

		queueArray.insert(45);
		queueArray.insert(6);
		queueArray.insert(5);
		queueArray.insert(49);
		queueArray.insert(95);
		queueArray.insert(9);
		queueArray.insert(95);
		while (!queueArray.isEmpty()) {
			long vaule = queueArray.remove();
			System.out.println(vaule);
		}

	}
}
