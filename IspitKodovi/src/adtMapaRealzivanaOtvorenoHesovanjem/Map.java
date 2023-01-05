package adtMapaRealzivanaOtvorenoHesovanjem;

public interface Map<K,V> {
	//dodaj novi par K,V u mapu. Vraca false ukoliko key vec postoji u mapi
	boolean insert(K key, V value);
	//brise par K,V iz mape. False- ukoliko ne postoji u mapi
	boolean delete(K key);
	//vraca value vezan za key
	V get(K key);
	//Modifikuje value vezan za key. Vraca false uklk key ne postoji u mapi
	boolean modify(K key, V value);

}
