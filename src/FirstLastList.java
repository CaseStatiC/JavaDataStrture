public class FirstLastList {// 只有一个元素的时候，first = last

	private Link first;// 引用第一个Link
	private Link last;// 引用最后一个Link

	public boolean isEmpty() {
		return first == null;
	}

	public Link insertFirst(long d) {
		Link link = new Link(d);
		if (isEmpty()) {// 当他为空的时候，需要操作last
			last = link;
		}
		link.next = first;
		first = link;
		return link;
	}

	public Link insertLast(long d) {
		Link newLink = new Link(d);
		if (isEmpty()) {// 当为空的时候，需要操作first
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
		return newLink;
	}

	public Link deleteFirst() {
		Link tmp = first;
		if (first.next == null) {// 如果只有一个元素，则操纵last
			last = null;
		}
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

	class Link {
		public long data;
		public Link next;

		public Link(long data) {
			this.data = data;
		}

		public void display() {
			System.out.println(data);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstLastList list = new FirstLastList();

		list.insertLast(12);
		list.insertLast(12);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(9);

		list.displayList();

		list.insertLast(45);
		list.insertLast(99);
		list.insertLast(145);

		list.displayList();

		list.deleteFirst();
		list.displayList();
	}

}
