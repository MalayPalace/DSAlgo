/***********************************
 * DSAlgo Project
 * Filename: BinaryTree.java
 * Author : malay
 * Date : 02-Apr-2020
 * 
 **********************************/
package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
	}

	public boolean add(Integer data) {
		if (data == null) {
			return false;
		}

		if (root == null) {
			root = new Node(data);
			return true;
		}
		return root.add(data);
	}

	public List<Integer> traverseInOrder() {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		root.traverseInOrder(list);
		return list;
	}

	public List<Integer> traversePreOrder() {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		root.traversePreOrder(list);
		return list;
	}

	public List<Integer> traversePostOrder() {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		root.traversePostOrder(list);
		return list;
	}

	public Integer getMin() {
		if (root == null) {
			return -1;
		}
		return root.getMin().getData();
	}

	public Integer getMax() {
		if (root == null) {
			return -1;
		}
		return root.getMax().getData();
	}

	public Integer get(Integer value) {
		if (root != null) {
			Node node = root.get(value);
			return node != null ? node.getData() : null;
		}
		return null;
	}

	public boolean delete(Integer value) {
		List<Boolean> deleteResult = new ArrayList<Boolean>();
		deleteResult.add(false);
		root = delete(root, value, deleteResult);
		return deleteResult.get(0);
	}

	private Node delete(Node subRoot, Integer value, List<Boolean> list) {
		if (subRoot == null) {
			return subRoot;
		}

		if (value < subRoot.getData()) {
			subRoot.setLeftNode(delete(subRoot.getLeftNode(), value, list));
		} else if (value > subRoot.getData()) {
			subRoot.setRightNode(delete(subRoot.getRightNode(), value, list));
		} else {
			// case where delete node has 0 or 1 child
			if (subRoot.getLeftNode() == null) {
				list.add(0, true);
				return subRoot.getRightNode();
			} else if (subRoot.getRightNode() == null) {
				list.add(0, true);
				return subRoot.getLeftNode();
			} else {
				// case where delete node has 2 children
				Node max = subRoot.getLeftNode().getMax();
				subRoot.setData(max.getData());
				subRoot.setLeftNode(delete(subRoot.getLeftNode(), max.getData(), list));
				list.add(0, true);
			}
		}
		return subRoot;
	}

	private class Node {

		private Integer data;
		private Node leftNode;
		private Node rightNode;

		public Node(Integer data) {
			this.data = data;
		}

		public boolean add(Integer value) {
			if (getData().equals(value)) {
				return false;
			}
			if (value < getData()) {
				if (getLeftNode() == null) {
					setLeftNode(new Node(value));
				} else {
					return getLeftNode().add(value);
				}
			} else {
				if (getRightNode() == null) {
					setRightNode(new Node(value));
				} else {
					return getRightNode().add(value);
				}
			}
			return true;
		}

		public void traverseInOrder(List<Integer> list) {
			if (getLeftNode() != null) {
				getLeftNode().traverseInOrder(list);
			}
			list.add(getData());
			if (getRightNode() != null) {
				getRightNode().traverseInOrder(list);
			}
		}

		public void traversePreOrder(List<Integer> list) {
			list.add(getData());
			if (getLeftNode() != null) {
				getLeftNode().traversePreOrder(list);
			}
			if (getRightNode() != null) {
				getRightNode().traversePreOrder(list);
			}
		}

		public void traversePostOrder(List<Integer> list) {
			if (getLeftNode() != null) {
				getLeftNode().traversePostOrder(list);
			}
			if (getRightNode() != null) {
				getRightNode().traversePostOrder(list);
			}
			list.add(getData());
		}

		public Node getMin() {
			if (getLeftNode() == null) {
				return this;
			}
			return getLeftNode().getMin();
		}

		public Node getMax() {
			if (getRightNode() == null) {
				return this;
			}
			return getRightNode().getMax();
		}

		public Node get(Integer value) {
			if (getData().equals(value)) {
				return this;
			} else if (value < getData()) {
				return getLeftNode() != null ? getLeftNode().get(value) : null;
			} else {
				return getRightNode() != null ? getRightNode().get(value) : null;

			}
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}
		
		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
		}
	}
}
