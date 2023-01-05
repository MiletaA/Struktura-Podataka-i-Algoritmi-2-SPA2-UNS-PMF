package adtPrioritetnaListaInsertMaxIsEmpty;

public class Glavna {	
	public static void main(String[] args) throws IllegalAccessException {
		PriorityQueue<Kandidat>pq = new HeapPQ<Kandidat>(3);
		pq.insert(new Kandidat("Pera", 10, 20));
		pq.insert(new Kandidat("Zika", 15, 35));
		pq.insert(new Kandidat("Mika", 8, 38));
		pq.insert(new Kandidat("Ana", 19, 0));
		while (!pq.isEmpty()) {
			Kandidat k = pq.delMax();
			System.out.println("Upisujem kandidata "+ k);
		}
	}

}
