public class LinkList {

	class Link {
		public int iData;
		public double dData;
		public Link next;

		public Link(int id, double dd) {
			iData = id;
			dData = dd;
		}

		public void displayLink() {
			System.out.println("" + iData + "-" + "dData");
		}
	}

	private Link first;

	public LinkList() {// 只是引用这第一个Link
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int iData, double dData) {// 插入在第一个
		Link newLink = new Link(iData, dData);
		newLink.next = first;
		first = newLink;
	}

	public Link deleteFirst() {// 删除先删除的是第一个
		Link tmp = first;
		first = first.next;
		return tmp;
	}

	public void displayList() {
		Link current = first;
		while (current != null) {// 当现在显示的下一个Link不为null，则一直展示
			current.displayLink();
			current = current.next;
		}

	}

	public Link find(int key) {
		Link current = first;
		while (current.iData != key) {// 不相等怎一直执行比较
			if (current.next == null) {// 最后一个引用的时候，跳出去
				return null;
			} else {
				current = current.next;// 指示到下一个
			}
		}
		return current;
	}

	public Link delete(int key) {
		Link privious = first;
		Link current = first;
		while (current.iData != key) {// 不相等怎一直执行比较
			if (current.next == null) {// 最后一个引用的时候，跳出去
				return null;
			} else {
				privious = current;
				current = current.next;// 指示到下一个
			}
		}
		if (current == first) {
			first = first.next;// 当是第一个的时候,把第一个设置为null
		} else {
			privious.next = current.next;// 跳过current
		}
		return current;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkList list = new LinkList();

		list.insertFirst(2, 30);
		list.insertFirst(4, 80);
		list.insertFirst(1, 80);
		list.insertFirst(5, 70);
		list.insertFirst(8, 90);
		list.insertFirst(3, 30);
		list.insertFirst(7, 10);

		list.displayList();

		Link findLink = list.find(2);
		if (findLink != null) {
			findLink.displayLink();
		} else {
			System.out.println("Cant find 2");
		}
		list.delete(2);
		list.displayList();
	}
}
