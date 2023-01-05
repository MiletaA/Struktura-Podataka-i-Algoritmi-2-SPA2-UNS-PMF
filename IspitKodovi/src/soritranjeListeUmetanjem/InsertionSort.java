package soritranjeListeUmetanjem;
/*
 * Sortiranje umetanjem
 *  Ako je lista prazna ili jednoelementna tada je ona sortirana
 Neka je levi deo liste sortiran, a desni nesortiran
 lastSorted pokazivač na poslednji element u sortiranom delu liste
 firstUnsorted pokazivač na prvi element u nesortiranom delu liste, 
 firstUnsorted = lastSorted.next
 Razlikujemo tri slučaja
 [1] firstUnsorted >= lastSorted: nema umetanja, sortirani
deo liste se trivijalno povećava (lastSorted = firstUnsorted)
 [2] firstUnsorted < root: firstUnsorted treba umetnuti pre root
 [3] Inače: firstUnsorted treba umetnuti iza lastLeq
 lastLeq: pokazivač na poslednji element između root i
firstUnsorted koji je manji ili jednak od firstUnsorted
 lastLeq se lako pronalazi sekvencijalnim pretraživanjem liste od
korena ka kraju */
public class InsertionSort {
	public class SortableList<T extends Comparable<T>> {
		private class Node {
			T info;
			Node next;

			public Node(T info) {
				this.info = info;
			}
		}

		private Node root = null;

		public void add(T info) {
			Node newElem = new Node(info);
			newElem.next = root;
			root = newElem;
		}
		public void insertionSort() {
			if(root == null || root.next == null)
				return;
			Node lastSorted = root;
			while(lastSorted.next != null) {
				Node firstUnsorted = lastSorted.next;
				//firstUnsorted >= lastSorted -- nema umetanja
				if(firstUnsorted.info.compareTo(lastSorted.info) >= 0)
					lastSorted = firstUnsorted;
				//ovde je bio neki else ali nema poentu prezentacija sortiranjeListi 5i slajd
				//firstUnsorted < root -- umetanje na pocetak
				if(firstUnsorted.info.compareTo(root.info)<0) {
					lastSorted.next = firstUnsorted.next;
					firstUnsorted.next = root;
					root = firstUnsorted;
				}else {
					//pronalazenje lastLEq
					Node curr = root,lastLeq = null;
					while(curr.info.compareTo(firstUnsorted.info) <=0) {
						lastLeq = curr;
						curr = curr.next;
					}
					//umetanje firstUnsorted iza lastLeq
					lastSorted.next = firstUnsorted.next;
					firstUnsorted.next = lastLeq.next;
					lastLeq.next = firstUnsorted;
				}	
			}
		}
		

	}
}
