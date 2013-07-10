package iterator;

import iterator.Iterator.Link;

class linkList {
	private Link first;

	public linkList() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public Link getFirst() {
		return first;
	}

	public void setFirst(Link link) {
		first = link;
	}

	public Iterator getIterator() {
		return new Iterator(this);
	}

	public void display() {
		Link current = first;
		while (current !=null) {
			current.display();
			current = current.next;
		}
	}
}
