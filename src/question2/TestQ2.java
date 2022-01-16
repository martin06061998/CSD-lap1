/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import question2.SinglyLinkedList.Node;

/**
 *
 * @author marti
 */
public class TestQ2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		SinglyLinkedList list = new SinglyLinkedList();
		list.addToHead("123");
		list.addToTail("ala");
		list.addToHead("789");
		list.travese();
		list.deleteFromHead();
		list.travese();
		list.deleteFromTail();
		list.travese();
		list.addToHead("uHu");
		list.addToHead("aha");
		list.travese();
		list.delete("uhu");
		Node e = list.search("aha");
		list.travese();
		list.deleteAfter(e);
		list.addToHead("aga");
		list.addToHead("ugu");
		Node a = list.search("aha");
		list.addAfter(a, "afteraha");
		list.travese();
	}
}
