/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import question1.SinglyLinkedLlist.Node;

/**
 *
 * @author marti
 */
public class TestQ1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		question1.SinglyLinkedLlist sl = new question1.SinglyLinkedLlist();
		sl.addToTail(3);
		sl.addToHead(1);
		Node e = sl.search(1);
		sl.addBefore(e, 0);
		question1.SinglyLinkedLlist.Node c = sl.search(3);
		sl.addBefore(c, 7);
		sl.travese();
		System.out.println(sl.sorted());
		sl.sort();
		System.out.println(sl.sorted());
		sl.travese();
		System.out.println(sl.count());

	}

}
