/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap1;

import question1.SinglyLinkdedList;

/**
 *
 * @author marti
 */
public class Lap1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SinglyLinkdedList sl = new SinglyLinkdedList();
		sl.addToTail(3);
		sl.addToTail(10);
		sl.addToTail(12);

		sl.addToTail(32);
		sl.addToHead(99);
		sl.addToHead(4);
		SinglyLinkdedList.Node max = sl.max();
		System.out.println("max la: " + max.getInfo());
		sl.travese();
		sl.deleteFromHead();
		sl.deleteFromTail();
		sl.deleteFromTail();
		sl.deleteFromHead();
		sl.travese();
		System.out.println("sum la " + sl.sum());

	}

}
