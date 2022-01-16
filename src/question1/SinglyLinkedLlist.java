/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 *
 * @author Thinh Nguyen Phuc
 */
public class SinglyLinkedLlist {

	private Node head;
	private Node tail;
	private int length;

	public SinglyLinkedLlist() {
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

	public void addAfter(Node p, int x) {
		Objects.requireNonNull(p);
		if (this.contains(p)) {
			Node successor = p.next;
			if (Objects.isNull(successor)) {
				this.addToTail(x);
			} else {
				Node newNode = new Node(x);
				p.next = newNode;
				newNode.next = successor;
				length++;

			}
		}
	}

	public void travese() {
		if (Objects.isNull(head)) {
			System.out.println("list is empty");
		} else if (head.hasNext()) {
			Node current = head;
			while (current != null) {
				System.out.print(current.info + " ");
				current = current.next;
			}
			System.out.println();
		} else {
			System.out.println(head.info);
		}
	}

	public int count() {
		return length;
	}

	public Node deleteFromHead() {
		Node ret = null;
		if (Objects.isNull(head)) {
			System.out.println("Nothing to delete");
			return ret;
		} else {
			if (head.hasNext()) {
				ret = head;
				head = head.next;
			} else {
				ret = head = tail = null;
			}
		}
		length--;
		return ret;
	}

	public Node deleteFromTail() {
		Node ret = null;
		if (Objects.isNull(head)) {
			System.out.println("Nothing to delete");
			return ret;
		} else if (head.hasNext()) {
			Node prevOfTail = head;
			while (!(prevOfTail.next == tail)) {
				prevOfTail = prevOfTail.next;
			}
			prevOfTail.next = null;
			tail = prevOfTail;

		} else {
			ret = tail = head = null;
		}
		length--;
		return ret;
	}

	public void deleteAfter(Node p) {
		Objects.requireNonNull(p);
		if(this.contains(p) && p.hasNext()){
			this.delete(p.next);
		}
	}

	public void delete(int x) {
		if (delete((n) -> n.info == x)) {
			length--;
		}

	}

	public Node search(int x) {
		return search((n) -> n.info == x);
	}

	public void delete(Node p) {
		Objects.requireNonNull(p);
		if (delete((n) -> n == p)) {
			length--;
		}
	}
	public void deleteNode2(int i){
		
	}
	public void addBefore(Node p, int x) {
		Objects.requireNonNull(p);
		if (length > 0 && head == p) {
			this.addToHead(x);
			return;
		} else {
			Node predecessor = search((pre) -> pre.next != null && pre.next == p);
			if (Objects.isNull(predecessor)) {
				return;
			}
			Node newNode = new Node(x);
			predecessor.next = newNode;
			newNode.next = p;
		}
		length++;
	}

	public void sort() {
		if (length <= 1) {
			return;
		}
		Node savePoint = head;
		while (head != null) {
			Node min = min();
			swap(head, min);
			head = head.next;
		}
		head = savePoint;
	}

	public void reverse(){
		
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

	public Node max() {
		return findExtremeNode((n1, n2) -> n1.info - n2.info);
	}

	public Node min() {
		return findExtremeNode((n1, n2) -> n2.info - n1.info);
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

	public boolean sorted() {
		if (Objects.isNull(head)) {
			return true;
		} else {
			if (head.hasNext()) {
				int oldInfo = head.info;
				Node current = head.next;
				while (current != null) {
					if (oldInfo > current.info) {
						return false;
					}
					oldInfo = current.info;
					current = current.next;
				}
				return true;
			} else {
				return true;
			}
		}
	}

	private Node search(Predicate<Node> predicate) {
		Node ret = null;
		if (Objects.isNull(head)) {
			return ret;
		} else if (head.hasNext()) {
			Node current = head;
			boolean found = false;
			while (current != null) {
				if (predicate.test(current)) {
					found = true;
					break;
				}
				current = current.next;
			}
			if (found == true) // p is found
			{
				ret = current;
			}
		} else {
			if (predicate.test(head)) {
				ret = head;
			}
		}
		return ret;
	}

	private boolean delete(Predicate<Node> predicate) {
		Node target = search(predicate);
		if (Objects.isNull(target)) {
			System.out.println("Nothing to delete");
			return false;
		} else {
			int len = length;
			if (len == 1) {
				head = tail = null;
			} else {
				if (target == head) {
					head = head.next;
				} else {
					Node predecessor = search((n) -> n.next == target);
					if (target.hasNext()) {
						predecessor.next = target.next;
					} else {
						tail = predecessor;
						predecessor.next = null;
					}
				}
			}
			return true;
		}
	}

	private void swap(Node node1, Node node2) {
		int temp = node1.info;
		node1.info = node2.info;
		node2.info = temp;
	}

	private Node findExtremeNode(Comparator<Node> c) {
		Node ret = null;
		if (Objects.isNull(head)) {
			return ret;
		} else if (head.hasNext()) {
			ret = c.compare(head, head.next) > 0 ? head : head.next;
			Node current = head.next;
			while (current != null) {
				if (c.compare(ret, current) < 0) {
					ret = current;
				}
				current = current.next;
			}
		} else {
			ret = head;
		}
		return ret;
	}

	public boolean contains(Node p) {
		Objects.requireNonNull(p);
		Node response = search((n) -> n == p);
		return response != null;
	}

}
