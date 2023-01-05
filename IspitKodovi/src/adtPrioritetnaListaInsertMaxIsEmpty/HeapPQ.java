package adtPrioritetnaListaInsertMaxIsEmpty;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/* PL je kolekcija objekata u kojoj svaki elem ima prioritet obrade
 * Elem sa najvecim prioritetom se obradjuje prvi. Nakon obrade bude izbacen iz liste
 * Elem PL ne moraju biti sortirani po prioritetu, bitno je uvek znati koji elem ima najveci prioritet obrade
 * 
 * O(logn)*/
public class HeapPQ<T extends Comparable<T>> implements PriorityQueue<T> {
	private static final int DEFAULT_INITIAL_CAPACITY = 100;
	private ArrayList<T> queue;

	public HeapPQ(int initialCapacity) throws IllegalAccessException {
		if (initialCapacity <= 0)
			throw new IllegalAccessException("initial capacity <=0");
		queue = new ArrayList<>(initialCapacity);
	}

	public HeapPQ() throws IllegalAccessException {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	private void swap(int indexa, int indexb) {
		T a = queue.get(indexa);
		queue.set(indexa, queue.get(indexb));
		queue.set(indexb, a);
	}

	// pitanje 10
	private void restoreHeapProperty(int sonIndex) {
		boolean heapRestored = false;
		int parentIndex = (sonIndex - 1) / 2;
		while (!heapRestored && sonIndex > 0) {
			T parent = queue.get(parentIndex);
			T son = queue.get(sonIndex);
			// da li je otac veci od sina
			if (parent.compareTo(son) > 0) {
				heapRestored = true;

			} else {
				// razmeni oca sa sinom
				swap(sonIndex, parentIndex);
				// nastavi dalje ka korenu: sin je sada na poziciji oca i ima novog oca
				sonIndex = parentIndex;
				parentIndex = (sonIndex - 1) / 2;
			}

		}
	}

	public void insert(T element) {
		queue.add(element);
		restoreHeapProperty(queue.size() - 1);
	}

	public T max() {
		if (queue.size() == 0)
			throw new NoSuchElementException("empty queue");
		return queue.get(0);
	}

	public boolean isEmpty() {
		return queue.size() == 0;
	}

	// pitanje 11
	private void restoreHeapProperty() {
		boolean heapRestored = false;
		int parentIndex = 0;
		while (!heapRestored) {
			int maxSonIndex = getMaxSon(parentIndex);
			// ne postoji ni jedan od sinova
			if (maxSonIndex == -1)
				heapRestored = true;
			else {
				T parent = queue.get(parentIndex);
				T maxSon = queue.get(maxSonIndex);
				// da li je otac veci od veceg sina?
				if (parent.compareTo(maxSon) > 0)
					heapRestored = true;
				else {
					// razmeni oca sa sinom
					swap(parentIndex, maxSonIndex);
					// otac je sada na poziciji sina (i ima nove sinove)
					parentIndex = maxSonIndex;
				}
			}
		}
	}
	private int getMaxSon(int parentIndex) {
		int son1Index = 2 * parentIndex + 1;
		int son2Index = 2 * parentIndex + 2;
		int maxSonIndex = -1;
		//postoji sin1?
		if(son1Index< queue.size())
			maxSonIndex = son1Index;
		//postoji sin2
		if(son2Index<queue.size()) {
			//da li drugi sin ima veci prioritet
			T s1 = queue.get(son1Index);
			T s2 = queue.get(son2Index);
			if(s2.compareTo(s1)>0)
				maxSonIndex = son2Index;
		}
		return maxSonIndex;
	}

	public int size() {
		return queue.size();
	}

	public T delMax() {
		if (queue.size() == 0)
			throw new NoSuchElementException("empty queue");
		T res = queue.get(0);
		swap(0, queue.size() - 1);
		queue.remove(queue.size() - 1);
		restoreHeapProperty();
		return res;
	}
}
