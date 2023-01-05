package adtPrioritetnaListaInsertMaxIsEmpty;

public interface PriorityQueue<T extends Comparable<T>> {
	// dodaj novi elem u PL
	void insert(T element);

	// vraca elem sa najvecim prioritetom
	T max();

	// da li je PL prazna
	boolean isEmpty();

	
	// vraca i brise iz PL elem sa najvecim prioritetom
	T delMax();
	// vraca velicinu PL
	int size();
}
