public class SortedList {
	class Link {
		public long nData;
		public Link next;

		public Link(long dd) {
			nData = dd;
		}

		public void display() {
			System.out.println(nData);
		}

	}

	private Link first;

	public void insert(long key) {// 插入到previous和current之间

		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		while (current != null && key > current.nData) {// 往下查找,current为第一个比key大的数值
			previous = current;
			current = current.next;
		}
		if (previous == null) {// 只有一个元素
			first = newLink;
		} else {
			previous.next = newLink;// 处理previous
		}
		newLink.next = current;// 处理current
	}

	public Link remove() {
		Link tmp = first;
		first = first.next;
		return tmp;
	}

	public void displayList() {
		Link current = first;
		while (current != null) {// 当现在显示的下一个Link不为null，则一直展示
			current.display();
			current = current.next;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedList list = new SortedList();

		list.insert(1);
		list.insert(10);
		list.insert(15);
		list.insert(17);
		list.insert(19);

		list.displayList();

		list.remove();
		list.remove();

		list.displayList();

	}
}
