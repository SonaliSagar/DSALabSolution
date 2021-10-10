package com.greatlearning.datastruct;

import java.util.*;

public class LongestPath {

	// Binary tree node
	static class Node {
		Node nodeLeft;
		Node nodeRight;
		int nodeData;
	};

	// create new Binary node
	static Node newNode(int nodeData) {
		Node temp = new Node();

		temp.nodeData = nodeData;
		temp.nodeLeft = null;
		temp.nodeRight = null;

		return temp;
	}

	public static ArrayList<Integer> findLongestPath(Node root) {
		// If root is null means there's no binary tree
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		// Recursive call on right subtree
		ArrayList<Integer> nodeRight = findLongestPath(root.nodeRight);

		// Recursive call on left subtree
		ArrayList<Integer> nodeLeft = findLongestPath(root.nodeLeft);

		// Compare the size of the two ArrayList & insert current node accordingly
		if (nodeRight.size() < nodeLeft.size()) {
			nodeLeft.add(root.nodeData);
		} else {
			nodeRight.add(root.nodeData);
		}

		// Returns the appropriate ArrayList
		return (nodeLeft.size() > nodeRight.size() ? nodeLeft : nodeRight);
	}

	public static void main(String[] args) {
		Node root = newNode(100);
		root.nodeLeft = newNode(20);
		root.nodeRight = newNode(130);
		root.nodeLeft.nodeLeft = newNode(10);
		root.nodeLeft.nodeRight = newNode(50);
		root.nodeRight.nodeLeft = newNode(110);
		root.nodeRight.nodeRight = newNode(140);
		root.nodeLeft.nodeLeft.nodeRight = newNode(5);

		ArrayList<Integer> output = findLongestPath(root);
		int n = output.size();

		System.out.print(output.get(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			System.out.print(" -> " + output.get(i));
		}
	}

}
