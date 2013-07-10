public class DoublyLinkedList {//

	class Link {
		public long nData;
		public Link next;
		public Link previous;

		public Link(long nData) {
			this.nData = nData;
		}

		public void displayLink() {
			System.out.println("" + nData);
		}
	}

	private Link first;
	private Link last;

	public void insertFirst(long nData) {
		Link newLink = new Link(nData);
		if (first == null) {// 空的时候，处理last:first和last都是newLink
			last = newLink;
		} else {
			first.previous = newLink;// 处理first的前面一项
		}
		newLink.next = first;// 处理newLink的后面一项
		first = newLink;
	}

	public void insertLast(long nData) {
		Link newLink = new Link(nData);
		if (first == null) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public Link deleteFirst() {
		Link temp = first;
		if (first.next == null) {// 只有一个元素
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;// 处理first
		return temp;
	}

	public Link deleteLast() {
		Link temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}

	public boolean insertAfter(int key, long dd) {
		Link newLink = new Link(dd);

		Link current = first;
		while (current.nData != key) {
			current = current.next;
			if (current == null) {// 没有找到匹配的值，直接返回false
				return false;
			}
		}
		if (current == last) {// 当只有一个元素的时候
			newLink.next = null;
			last = newLink;
		} else {
			current.next.previous = newLink;// current后一项的前一项
			newLink.next = current.next.next;// newLink的后一项
		}
		current.next = newLink;// current的后一项
		newLink.previous = current;// newLink的前一项
		return true;
	}

	public Link deleteKey(int key) {
		Link current = first;
		while (current.nData != key) {
			current = current.next;
			if (current == null) {// 没有找到匹配的值，直接返回false
				return null;
			}
		}
		if (current == first) {// 当时第一个的时候
			first = current.next;
		} else {
			current.previous.next = current.next;// 处理current的前一个
		}
		if (current == last) {// 当时最后一个的时候
			last = current.previous;
		} else {
			current.next.previous = current.previous;// 处理current的后一个
		}
		return current;
	}

	public void displayForward() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}

	public void displayBackward() {
		Link current = last;
		while (current != null) {
			current.displayLink();
			current = current.previous;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		list.insertFirst(1);
		list.insertFirst(4);

		list.displayForward();
		 list.displayBackward();

		 list.insertLast(5);
		 list.insertLast(7);
		
		 list.displayForward();
		 list.displayBackward();
		
		 list.insertAfter(4, 90);
		 list.displayForward();
		 list.insertAfter(20, 20);
		 list.displayForward();

	}
}
