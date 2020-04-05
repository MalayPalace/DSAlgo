/***********************************
 * DSAlgo Project
 * Filename: ClientMain.java
 * Author : malay
 * Date : 03-Apr-2020
 * 
 **********************************/
package com.tree;

import java.util.ArrayList;
import java.util.List;

public class ClientMain {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		List<Boolean> insertionFlag = new ArrayList<>();
		insertionFlag.add(tree.add(4));
		insertionFlag.add(tree.add(2));
		insertionFlag.add(tree.add(6));
		insertionFlag.add(tree.add(10));
		insertionFlag.add(tree.add(3));
		insertionFlag.add(tree.add(6));
		insertionFlag.add(tree.add(1));
		insertionFlag.add(tree.add(5));
		System.out.println(insertionFlag);
		System.out.println();

		System.out.println(tree.delete(4));
		System.out.println(tree.delete(7));
		System.out.println();
		
		List<Integer> inOrderList = tree.traverseInOrder();
		System.out.println("InOrder: " + inOrderList);
		
		List<Integer> preOrderList = tree.traversePreOrder();
		System.out.println("PreOrder: " + preOrderList);
		
		List<Integer> postOrderList = tree.traversePostOrder();
		System.out.println("PostOrder: " + postOrderList);
		System.out.println();

		System.out.println("Min Value: " + tree.getMin());
		System.out.println("Max Value: " + tree.getMax());
	}
}
