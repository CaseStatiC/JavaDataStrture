public class LinkQueue {

	private FirstLLink firstLastList;

	public LinkQueue() {
		firstLastList = new FirstLLink();
	}

	public void insert(long nData) {
		firstLastList.insertLast(nData);
	}

	public Link remove() {
		return firstLastList.deleteFirst();
	}

	public void display() {
		firstLastList.displayList();
	}

	private class Link {
		public long nData;
		public Link next;

		public Link(long dd) {
			nData = dd;
		}

		public void display() {
			System.out.println(nData);
		}

	}

	class FirstLLink {

		private Link first;
		private Link last;

		public void insertLast(long value) {
			Link newLink = new Link(value);
			if (first == null) {
				first = newLink;
			} else {
				last.next = newLink;
			}
			last = newLink;
		}

		public Link deleteFirst() {
			if (first.next == null) {
				last = null;
			}
			Link tmp = first;
			first = first.next;
			return tmp;
		}

		public void displayList() {
			Link current = first;
			while (current != null) {
				current.display();
				current = current.next;
			}

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkQueue linkQueue = new LinkQueue();

		linkQueue.insert(4);
		linkQueue.insert(6);
		linkQueue.insert(79);
		linkQueue.insert(65);

		linkQueue.display();

		linkQueue.remove();
		linkQueue.remove();
		linkQueue.display();
	}
}
