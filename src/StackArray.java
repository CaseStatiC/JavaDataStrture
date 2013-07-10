public class StackArray {

	private int maxSize;
	private int top;
	private long[] stackArray;

	public StackArray(int max) {
		maxSize = max;
		top = -1;
		stackArray = new long[max];
	}

	public void push(long value) {
		stackArray[++top] = value;
	}

	public long peek() {
		return stackArray[top];

	}

	public long pop() {
		return stackArray[top--];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackArray stack = new StackArray(10);

		stack.push(2);
		stack.push(5);
		stack.push(7);
		stack.push(9);
		stack.push(36);
		stack.push(78);

		while(!stack.isEmpty()){
			long value = stack.pop();
			System.out.println(value);
		}
	}
}
