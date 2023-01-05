package adtMapaRealzivanaOtvorenoHesovanjem;

import javax.swing.plaf.synth.SynthScrollBarUI;

/*Cvorovi u tabeli sada sadrze parove kljuc vrednost
 * Hes f-ja se primenjue samo na kljuceve 
 * iliti, lanac kolizija sadzei one elem ciji kljucevi imaju istu vrednost hes f-je*/
public class OHashMap<K,V> implements Map<K,V> {
	private static final int DEFALUT_TABLE_SIZE = 101;
	private static class Node{
		Object key;
		Object value;
		Node next;
		public Node(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
	private Node[] table;
	public OHashMap() {
		this(DEFALUT_TABLE_SIZE);
	}
	public OHashMap(int size) {
		if(size<=0)
			throw new IllegalArgumentException("Velicina HM ne moze biti negativna");
		table = new Node[size];
	}
	private int hash(K o) {
		if(o == null)
			throw new IllegalArgumentException("HF se ne moze racunati za null obj");
		return Math.abs(o.hashCode() % table.length);
	}
	/*trazi elem odredjen kljucem
	 * Ukoliko postoji vraca niz od 2 reference
	 * 1. pokazivac na elem u listi kolizija
	 * 2. pokazivac na prethodni elem
	*/
	private Node[] searchCollisionChain(K key, int hashValue) {
		Node current = table[hashValue];
		Node prev = null;
		while(current != null) {
			if(current.key.equals(key)) {
				Node[] ret = new Node[2];
				ret[0] = current;
				ret[1] = prev;
				return ret;
			}
			prev = current;
			current = current.next;
		}
		return null;
	}
	
	//pitanje 15
	public boolean insert(K key, V value) {
		int hashValue = hash(key);
		if(searchCollisionChain(key, hashValue)!=null)
			return false;
		Node newEl = new Node(key,value);
		newEl.next =table[hashValue];
		table[hashValue] = newEl;
		return true;
	}
	public boolean delete(K key) {
		int hashValue = hash(key);
		Node[] n = searchCollisionChain(key, hashValue);
		if(n == null)
			return false;
		if(n[0] == table[hashValue])
				table[hashValue] = table[hashValue].next;
		else
			n[1].next = n[0].next;
		return true;
	}
	//pitanje 16
	public V get(K key) {
		int hashValue = hash(key);
		Node[] n = searchCollisionChain(key, hashValue);
		if(n == null)
			return null;
		//LRU strategija - stavi elem na pocetak LK
		if(n[0] != table[hashValue]){
			n[1].next = n[0].next;
			n[0].next = table[hashValue];
			table[hashValue] = n[0];
		}
		return (V) n[0].value;
	}
	public boolean modify(K key, V value) {
		int hashValue = hash(key);
		Node[] n = searchCollisionChain(key, hashValue);
		if(n[0] != null) {
			n[0].value =value;
			return true;
		}else {
			return false;
		}
	}
	public void print() {
		for(int i = 0;i<table.length;i++) {
			System.out.print("HashCode= " + i + ":");
			Node head = table[i];
			if(head == null)
				System.out.print("empty");
			else {
				while(head != null){
					System.out.print("[" + head.key + ":" + head.value + "]");
					head = head.next;
				}
				System.out.println();
			}
		}
	}
}
