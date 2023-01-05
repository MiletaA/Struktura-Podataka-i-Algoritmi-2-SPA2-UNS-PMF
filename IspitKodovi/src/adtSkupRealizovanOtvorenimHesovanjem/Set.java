package adtSkupRealizovanOtvorenimHesovanjem;

public interface Set<T> {
	//dodaj elem u skup. Vraca false ukoliko elem vec posotoji u skupu
	boolean insert(T element);
	//brisem elem iz skupa. False- ako elem ne postoji.
	boolean remove(T element);
	//proverava da li je elem u skupu
	boolean member(T element);
}
