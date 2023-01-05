package adtSkupRealizovanOtvorenimHesovanjem;

/*Otvoreno hesovanje(zatvoreno adresiranje)
 * Hes tabela je niz jednostruko povezanih listi
 * Liste sadrze objekte sa istom vrednoscu hes funkcije
 * Ove liste jos zovemo lancima kolizija*/
public class OHashSet<T> implements Set<T> {
	private static final int DEFALUT_TABLE_SIZE = 101;

	// cvor u listi objekata sa istom hes vrednoscu
	private static class Node {
		Object value;// objekat
		Node next;// ref na sl obj u listi

		public Node(Object value) {
			this.value = value;
		}
	}

	// niz listi
	private Node[] table;

	// konstruktori
	public OHashSet() {
		this(DEFALUT_TABLE_SIZE);
	}

	public OHashSet(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Velicina hash tabele ne moze biti negativna");
		table = new Node[size];
	}

	// hes funkcija
	private int hash(T o) {
		if (o == null)
			throw new IllegalArgumentException("Hash f-ja se ne moze racunati za null obj");
		return Math.abs(o.hashCode() % table.length);
	}

	/*
	 * Pretrazuje listu kolizija za datu vrednost hash f-je(dr argument metoda)
	 * trazeci elem (prvi arg metoda) Metod vraca null ukoliko elem ne postoji u
	 * tabeli ili niz od dve reference 1. referenca na trazeni elem 2. referenca na
	 * elem ispred trazenog elem
	 */

	private Node[] searchColissionChain(T element, int hashValue) {
		Node curr = table[hashValue];
		Node prev = null;
		while (curr != null) {
			if (curr.value.equals(element)) {
				Node[] ret = new Node[2];
				ret[0] = curr;
				ret[1] = prev;
				return ret;
			}
			prev = curr;
			curr = curr.next;
		}
		return null;
	}

	// Metode propisane interfejsom Set<T>
	@Override
	public boolean insert(T element) {
		int hashValue = hash(element);
		Node[] n = searchColissionChain(element, hashValue);
		if (n != null)
			return false;
		Node newEl = new Node(element);
		newEl.next = table[hashValue];
		table[hashValue] = newEl;
		return true;
	}

	@Override
	public boolean remove(T element) {
		/*
		 * 1. Da li elem postoji u odgovarajucem lancu kolizija 2. Ako postoji
		 * razlikujemo 2 slucaja elem koji se brise je: 1.na pocetku lanca kolizija 2. u
		 * sredini/na kraju lanca kolizija
		 */
		int hashValue = hash(element);
		Node[] n = searchColissionChain(element, hashValue);
		if (n == null)
			return false;
		if (n[0] == table[hashValue])
			table[hashValue] = table[hashValue].next;
		else
			n[1].next = n[0].next;
		return true;
	}

	@Override
	public boolean member(T element) {
		// TODO Auto-generated method stub
		return searchColissionChain(element, hash(element)) != null;
	}

	// Metoda koja stampa skup
	public void print() {
		for (int i = 0; i < table.length; i++) {
			System.out.print("HashCode = " + i + ": ");
			Node head = table[i];
			if (head == null)
				System.out.println("empyt");
			else {
				while (head != null) {
					System.out.print("[" + head.value + "]");
					head = head.next;
				}
				System.out.println();
			}
		}
	}

}
