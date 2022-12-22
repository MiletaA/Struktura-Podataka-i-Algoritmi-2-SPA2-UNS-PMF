package sortiranjeNizaCombSortom;
 /* Combsort se, slično Šelovom sortiranju, zasniva na razmeni 
nesusednih elemenata u nizu.
 Za razliku od Šelovog sortiranja, Combsort je unapređenje 
sortiranja razmenom (bubble sort).
 Posmatrajmo sortiranje razmenom kod kojeg isplivava 
maksimum na nizu A = (10, 9, 5, 6, 2, 1)
 (9, 5, 6, 2, 1, 10)
 (5, 6, 2, 1, 9, 10)
 (5, 2, 1, 6, 9, 10)
 (2, 1, 5, 6, 9, 10)
 (1, 2, 5, 6, 9, 10) 
 Primećujemo da mali elementi sa kraja niza “sporo 
prilaze” (kornjace) početku niza, dok veliki elementi sa početka 
niza “brzo prilaze” kraju niza (zecevi)
 */
public class CombSort {
	private static int nextGap(int k) {
		k /= 1.3;
		if (k == 9 || k == 10)
			k = 11;
		else if (k < 1)
			k = 1;
		return k;
	}

	public static <T extends Comparable<T>> void combSort(T[] arr) {
		boolean sorted = false;
		int k = arr.length;
		do {
			k = nextGap(k);
			boolean exchOccured = false;
			for (int i = 0; i < arr.length - k; i++) {
				if (arr[i].compareTo(arr[i + k]) > 0) {
					T tmp = arr[i];
					arr[i] = arr[i + k];
					exchOccured = true;
				}
			}
			sorted = k == 1 && !exchOccured;
		} while (!sorted);

	}
}
