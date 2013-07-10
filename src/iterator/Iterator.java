package iterator;


class Iterator {
	class Link {
		public long nData;
		public Link next;

		public Link(long value) {
			nData = value;
		}

		public void display() {
			System.out.println("" + nData);
		}
	}

	private Link currrent;
	private Link previous;
	private linkList outList;

	public Iterator(linkList list) {
		outList = list;
	}

	public void reset() {
		currrent = outList.getFirst();
		previous = null;
	}

	public void nextLink() {
		previous = currrent;
		currrent = currrent.next;
	}

	public Link getCurrent() {
		return currrent;
	}

	public boolean atEnd() {
		return currrent == null;
	}

	public void insertAfter(long dd) {// 在所处的位置后面插入
		Link newLink = new Link(dd);

		if (outList.isEmpty()) {// 空的时候
			outList.setFirst(newLink);
			currrent = newLink;
		} else {
			newLink.next = currrent.next;// 处理newLink的下一项
			currrent.next = newLink;// 处理current的下一项
			nextLink();// current 是newLink
		}
	}

	public void insertBefore(long dd) {//往标头插的时候，注意设置first
		Link newLink = new Link(dd);

		if (previous == null) {// 当current所处的位置是第一个或者list为空，
			newLink.next = outList.getFirst();// 这里注意不能写成 newLink.next = currrent; 
			outList.setFirst(newLink);//currrent = newLink; 加入你插入到第一项的时候 永远是标头，如果写成current则
			//插入下一项的时候会出错
			reset();// currrent为链表头
		} else {
			newLink.next = previous.next;
			previous.next = newLink;
			currrent = newLink;
		}
	}

	public long deleteCurrent() {
		long value = currrent.nData;

		if (previous == null) {// 标头
			outList.setFirst(currrent.next);
			reset();
		} else {
			previous.next = currrent.next;// 设置previous的下一项
			if (atEnd()) {// 标尾的时候 重置current
				reset();
			} else {
				currrent = currrent.next;// 设置current
			}
		}

		return value;
	}

	public static void main(String[] args) {
		linkList list = new linkList();
		Iterator itr = list.getIterator();

		itr.insertBefore(10);
		itr.insertBefore(12);
		itr.insertBefore(15);
		
//		itr.insertAfter(25);
//		itr.insertAfter(35);
//		itr.insertAfter(9);
		
	//	list.display();
		
		itr.deleteCurrent();
		list.display();
//		itr.insertBefore(34);
//		itr.insertBefore(45);
//		
//		list.display();
	}
}
