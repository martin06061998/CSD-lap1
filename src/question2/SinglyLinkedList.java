/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.util.Objects;
import java.util.function.Predicate;

/**
 *
 * @author marti
 */
public class SinglyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	public SinglyLinkedList() {
		length = 0;
		head = tail = null;
	}

	public class Node {

		private String info;
		private Node next;

		public String getInfo() {
			return info;
		}

		private Node(String x) {
			info = x;
			next = null;
		}

		private boolean hasNext() {
			return next != null;
		}
	}

	public void addToHead(String x) {
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

	public void addToTail(String x) {
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

	public void addAfter(Node p, String x) {
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
		if (this.contains(p) && p.hasNext()) {
			this.delete(p.next);
		}
	}

	public void delete(String x) {
		if (delete((n) -> n.info.equalsIgnoreCase(x))) {
			length--;
		}

	}

	public Node search(String x) {
		return search((n) -> n.info.equalsIgnoreCase(x));
	}

	public void delete(Node p) {
		Objects.requireNonNull(p);
		if (delete((n) -> n == p)) {
			length--;
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

	public boolean contains(Node p) {
		Objects.requireNonNull(p);
		Node response = search((n) -> n == p);
		return response != null;
	}
}
