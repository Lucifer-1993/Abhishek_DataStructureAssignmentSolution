package com.greatlearning;

public class App {

	static class Node {
		int data;
		Node left, right;
	}

	static Node node(int val) {
		Node temp = new Node();
		temp.data = val;
		temp.right = temp.left = null;
		return temp;

	}

	static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void BsttoSkew(Node root) {
		// Base case
		if (root == null) {
			return;
		}

		BsttoSkew(root.left);
		Node rightNode = root.right;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		BsttoSkew(rightNode);

	}

	static void traverseSkew(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseSkew(root.right);
	}

	public static void main(String[] args) {

		App.node = node(50);
		App.node.left = node(30);
		App.node.right = node(60);
		App.node.left.left = node(10);
		App.node.left.right = node(55);

		BsttoSkew(node);
		traverseSkew(headNode);

	}
}

