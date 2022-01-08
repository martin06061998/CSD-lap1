/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.util.Objects;

/**
 *
 * @author Thinh Nguyen Phuc
 */
public class SinglyLinkdedList {

	private Node head;
	private Node tail;
	private int length;

	public SinglyLinkdedList() {
		length = 0;
		head = tail = null;
	}

	public class Node {

		private int info;
		private Node next;

		public int getInfo() {
			return info;
		}

		private Node(int x) {
			info = x;
			next = null;
		}

		private boolean hasNext() {
			return next != null;
		}
	}

	public void addToHead(int x) {
		if (Objects.isNull(head)) {
			head = new Node(x);
			tail = head;
		} else {
			Node newNode = new Node(x);
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public void addToTail(int x) {
		if (Objects.isNull(head)) {
			head = new Node(x);
			tail = head;
		} else {
			Node newNode = new Node(x);
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	public void travese() {
		if (Objects.isNull(head)) {
			System.out.println("list is empty");
		} else if (head.hasNext()) {
			Node current = head;
			while (current.hasNext()) {
				System.out.print(current.info + " ");
				current = current.next;
			}
			System.out.println(current.info);
		} else {
			System.out.println(head.info);
		}
	}

	public Node deleteFromHead() {
		Node ret = head;
		head = head.next;
		length--;
		return ret;
	}

	public Node deleteFromTail() {
		Node ret = null;
		if (Objects.isNull(head)) {
			return ret;
		} else if (head.hasNext()) {
			Node prevOfTail = head;
			while (!prevOfTail.next.equals(tail)) {
				prevOfTail = prevOfTail.next;
			}
			prevOfTail.next = null;
			tail = prevOfTail;

		} else {
			ret = head;
		}
		length--;
		return ret;
	}

	public Node max() {
		Node ret = null;
		if (Objects.isNull(head)) {
			return ret;
		} else if (head.hasNext()) {
			ret = head.info > head.next.info ? head : head.next;
			Node current = head.next;
			while (current.hasNext()) {
				if (ret.info < current.info) {
					ret = current;
				}
				current = current.next;
			}
		} else {
			ret = head;
		}
		return ret;
	}

	public int sum() {
		int sum = 0;
		if (Objects.isNull(head)) {
			return sum;
		} else if (head.hasNext()) {
			sum = head.info;
			Node current = head.next;
			while (!Objects.isNull(current)) {
				sum += current.info;
				current = current.next;
			}
		} else {
			sum = head.info;
		}
		return sum;
	}

	public int average() {
		return sum() / length;
	}

	public int[] toArray() {
		if (Objects.isNull(head)) {
			return null;
		} else {
			int[] ret = new int[length];
			if (head.hasNext()) {
				ret[0] = head.info;
				Node current = head.next;
				for (int i = 1; i < length; i++) {
					ret[i] = current.info;
					current = current.next;
				}
			} else {
				ret[0] = head.info;
			}
			return ret;
		}
	}

}
