public final class LinkStack {// 委托linkList实现

	private LinkList linkList;

	public LinkStack() {
		linkList = new LinkList();
	}

	public long pop() {
		return linkList.deleteFirst().nData;
	}

	public void push(long value) {
		linkList.insertFirst(value);
	}

	public boolean isEmpty() {
		return linkList.first == null;
	}

	public void displayLinkStack() {
		linkList.displayList();
	}

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

	class LinkList {
		public Link first;

		public LinkList() {
			first = null;
		}

		public void insertFirst(long value) {
			Link link = new Link(value);
			link.next = first;
			first = link;
		}

		public Link deleteFirst() {
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

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkStack linkStack = new LinkStack();

		linkStack.push(14);
		
		linkStack.push(17);
		linkStack.push(18);
		linkStack.push(1);
		linkStack.push(13);

		linkStack.displayLinkStack();
		 linkStack.pop();
		 linkStack.pop();
		 linkStack.pop();
		
		 linkStack.displayLinkStack();

	}
}
