import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class Tree {

	class Node {
		public int iData;
		public double dData;
		public Node leftChild;
		public Node rightChild;

		public void displayNode() {
			System.out.println("" + iData + ";" + dData);
		}
	}

	private Node root;

	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (current.iData < key) {// 如果比Key小，就搜索左边的结点
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public void insert(int iData, double dData) {
		Node node = new Node();
		node.iData = iData;
		node.dData = dData;

		if (root == null) {
			root = node;
		} else {// 查找，如果某个位置为空，就把结点插入到这个位置上去
			Node current = root;
			Node parent;// 如果这个位置为空，就把这个结点作为parent的子结点
			while (true) {
				parent = current;
				if (iData < current.iData) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = node;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = node;
						return;
					}
				}
			}
		}

	}

	public boolean delete(int key) {
		Node current = root;
		Node parent = null;
		boolean isLeftChild = true;
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				return false;
			}
		}
		if (current.leftChild == null && current.rightChild == null) {// 没有子结点
			if (current == root) {
				current = null;
			} else {
				if (isLeftChild) {
					parent.leftChild = null;
				} else {
					parent.rightChild = null;
				}
			}
		} else {// 只有一个子结点
			if (current.rightChild == null) {// 只有左边的子结点
				if (current == root) {//
					root = current.leftChild;
				} else {
					if (isLeftChild) {// 删除子结点，处理current的子结点和parent的关系
						parent.leftChild = current.leftChild;
					} else {
						parent.leftChild = current.rightChild;
					}
				}
			} else {
				if (current.leftChild == null) {// 只有右边的子结点
					if (current == root) {
						root = current.rightChild;
					} else {
						if (isLeftChild) {
							parent.rightChild = current.rightChild;
						} else {
							parent.rightChild = current.rightChild;
						}
					}
				} else {// 两个结点，把中继点替换为删除点，中继点的右子树作为替代中继点，移动两个点，需要处理四个路径
					Node successor = getSuccessor(current);// 获取中继点
					if (root == current) {
						root = successor;
					} else {
						if (isLeftChild) {// 处理parent
							parent.leftChild = successor;
						} else {
							parent.rightChild = successor;
						}
					}
					successor.leftChild = current.leftChild;// 处理successor左节点
				}
			}

		}
		return true;
	}

	public Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;

		while (current != null) {// 一直往左找，知道没有则为中继点
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;// 中继点的父结点为中继点的右结点
			successor.rightChild = delNode.rightChild;// 中继点的右结点为删除元素的左结点
		}
		return successor;
	}

	public void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.println(localRoot.dData + "");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	public void inOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			System.out.println(localRoot.dData + "");
			preOrder(localRoot.rightChild);
		}

	}

	public void postOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
			System.out.println(localRoot.dData + "");
		}

	}
}
