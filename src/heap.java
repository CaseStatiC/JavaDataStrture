public class heap {

	class Node {
		private int iData;

		public Node(int key) {
			setiData(key);
		}

		public int getiData() {
			return iData;
		}

		public void setiData(int iData) {
			this.iData = iData;
		}

	}

	private Node[] heepArray;
	private int maxSize;
	private int currentSize;

	public heap(int max) {
		maxSize = max;
		currentSize = 0;
		heepArray = new Node[max];
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean insert(int key) {
		if (currentSize == maxSize) {
			return false;
		}
		Node newNode = new Node(key);
		heepArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	// 用数组表示树，一个位置的索引为index,那么左子节点的index = index*2+1;右子节点indext = index*2+2
	// 他的父节点为（index-1)/2
	public void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heepArray[index];// 暂时保存新添加的节点
		while (index > 0 && heepArray[parent].getiData() < bottom.getiData()) {// 如果新节点大于则一直循环添加
			heepArray[index] = heepArray[parent];// 赋值
			index = parent;
			parent = (parent - 1) / 2;
		}
		heepArray[index] = bottom;
	}

	public Node remove() {// 只是移除最大的一个，即树的根
		Node root = heepArray[0];
		heepArray[0] = heepArray[currentSize--];//把顶点赋值为最后一个点
		trickleDown(0);//往下遍历
		return root;
	}

	public void trickleDown(int index) {
		int largeChild;
		Node top = heepArray[index];// 顶点的Node
		while (index < currentSize / 2) {// 只要index不在最底层
			int leftChild = index * 2 + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize// 确保他的右节点小于currentSize
					&& heepArray[leftChild].getiData() < heepArray[rightChild]
							.getiData()) {
				largeChild = rightChild;
			} else {
				largeChild = leftChild;
			}
			if (top.getiData() >= heepArray[largeChild].getiData()) {// 当top比他较大的节点大时候，退出循环
				break;
			}
			heepArray[index] = heepArray[largeChild];// index赋值为较大的子节点
			index = largeChild;// 往下遍历一次
		}
		heepArray[index] = top;// 交换
	}
}
