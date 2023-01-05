package sortiranjeListeMergeSortom;

/*Sortiranje spajanjem zavadi pa vladaj
 * O(nlogn)
 * Podelimo listu L u dve balansirane liste L1 i L2- duzine im se razlikuju najvise za 1
 * soritramo l1 i l2 merge sortom 
 * spojimo dve sortirane liste l1 i l2 u finalno sortiranu listu
 * MS se sastoji od 2 podproblema:
 * **Podele liste u dve balansirane liste
 * **Spajanje sortiranih listi u sortiranu listu
*
*
*/
public class MergeSort {
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
			Node newEl = new Node(info);
			newEl.next = root;
			root = newEl;
		}

		public void mergeSort() {
			if (root != null)
				root = mergeSort(root);
		}
		
		private Node mergeSort(Node start) {
			if (start.next == null)
				return start; //jednoelementna lista je sortirana
			//podela liste na dva dela l1 i l2
			Node l1 = start, l1End = l1; // l1 i l1End pokazuju na prvi elem originalne liste
			Node l2 = start.next, l2End = l2;//l2 i l2End pokazuju na dr elem org liste
			Node curr = start.next.next; // prvi elem iz L koji nije ubacen u L1 i L2
			while (curr != null) {
				//dodaj curr u l1
				l1End.next = curr;
				l1End = curr;
				//pomeri curr za jedno mesto u desno
				curr = curr.next;
				//dodaj curr u l2
				if (curr != null) {
					l2End.next = curr;
					l2End = curr;
					curr = curr.next;
				}
			}
			//postavi uzemljenja
			l1End.next = null;
			l2End.next = null;
			
			//sortiraj l1
			l1 = mergeSort(l1);
			//sortiraj l2
			l2 = mergeSort(l2);
			return merge(l1,l2); //spajanje sortirane liste
			
		}
		private Node merge(Node l1, Node l2) {
			Node root = null;
			if(l1.info.compareTo(l2.info)<0) {
				root = l1;
				l1 = l1.next;
				
			}else {
				root = l2;
				l2 = l2.next;
			}
			Node last = root;
			while(l1 != null && l2 != null) {
				if(l1.info.compareTo(l2.info)<0) {
					last.next = l1;
					last = l1;
					l1 = l1.next;
				}else {
					last.next = l2;
					last = l2;
					l2 = l2.next;
				}
			}
			last.next = l1 == null ? l2:l1;
			return root;
		}
	}
}
