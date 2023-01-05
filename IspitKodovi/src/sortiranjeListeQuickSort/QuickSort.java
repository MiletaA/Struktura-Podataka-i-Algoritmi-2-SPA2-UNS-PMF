package sortiranjeListeQuickSort;

public class QuickSort {
	public class SortableList<T extends Comparable<T>> {
		private class Node {
			T info;
			Node next;

			public Node(T info) {
				this.info = info;

			}
		}

		private Node root = null;

		public void quickSort() {
			if (root != null)
				root = quickSort(root);
		}

		private Node quickSort(Node start) {
			// lista koja ima jedan elem je sortirana
			if (start.next == null)
				return start;
			// za pivot selektujemo prvi elem liste start
			Node pivot = start;
			// smaller je pokazivac na koren liste koja sadrzi elem manji od pivota,
			// a greater je pokazivac na koren liste koja sadrzi elem veci od pivota
			Node smaller = null, greater = null;
			Node curr = pivot.next;
			while (curr != null) {
				Node afterCurr = curr.next;
				if (curr.info.compareTo(pivot.info) < 0) {
					// dodajemo curr na pocetak liste smaller
					curr.next = smaller;
					smaller = curr;
				} else {
					// dodajemo curr na pocetak liste greater
					curr.next = greater;
					greater = curr;
				}
				curr = afterCurr;
			}
			if (smaller != null)
				smaller = quickSort(smaller);
			if (greater != null)
				greater = quickSort(greater);
			pivot.next = greater;
			if (smaller == null)
				return pivot;
			else {
				Node tmp = smaller;
				while (tmp.next != null)
					tmp = tmp.next;
				tmp.next = pivot;
				return smaller;
			}
		}
	}
}
