package sortiranjeNizaHeapSortom;
/*unapredjeno sortiranje izabiranjem O(nlogn)
 Opis algoritma:
 Neka je A niz dužine n.
 Transformišemo A tako da ima strukturu hipa: maksimalni 
element niza je tada prvi element u nizu.
 Razmenimo maksimum sa elementom na kraju niza.
 Uspostavimo strukturu hipa na podnizu A[0 .. n – 2] i maksimum 
zamenimo sa elementom na poziciji n - 2
 Uspostavimo strukturu hipa na podnizu A[0 .. n – 3] i maksimum 
zamenimo sa elementom na poziciji n – 3
 …
 Uspostavimo strukturu hipa na podnizu A[0 .. 1] i maksimum 
zamenimo sa elementom na poziciji 1
*
*/
public class sortiranjeNizaHeapSortom {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		int lastIndex = arr.length - 1;
		int lastParent = (lastIndex - 1) / 2;
		// uspostavi strukturu heapa
		while (lastParent >= 0) {
			makeHeap(arr, lastParent, lastIndex);
			lastParent--;
		}
		// indeks poslednjeg el u nesortiranom delu niza
		int end = lastIndex;
		while (end > 0) {
			// razmeni prvi el sa poslednjim el iz nesortiranog dela niza
			T tmp = arr[0];
			arr[0] = arr[end];
			arr[end] = tmp;
			// nesortirani deo je sada kraci za jedan el
			end--;
			// uspostavi strukturu hipa u nesortiranom delu
			makeHeap(arr, 0, end);
		}
	}

	private static <T extends Comparable<T>> void makeHeap(T[] arr, int start, int end) {
		int parentIndex = start;
		boolean heapRestored = false;
		while (!heapRestored) {
			int maxSonIndex = getMaxSon(arr, parentIndex, end);
			// ne postoji ni jedan od sinova
			if (maxSonIndex == -1)
				heapRestored = true;
			else {
				// uporedi oca sa vecim sinom
				if (arr[parentIndex].compareTo(arr[maxSonIndex]) < 0) {
					// razmeni oca sa vecim sinom
					T tmp = arr[maxSonIndex];
					arr[maxSonIndex] = arr[parentIndex];
					arr[parentIndex] = tmp;
					// otac ke sada na poziciji veceg sina
					parentIndex = maxSonIndex;
				} else {
					heapRestored = true;
				}

			}
		}
	}
	private static <T extends Comparable<T>> int getMaxSon(T[] arr, int parentIndex, int end) {
		int son1Index = 2 * parentIndex + 1;
		int son2Index = 2 * parentIndex + 2;
		int maxSonIndex = -1;
		//postoji sin1?
		if(son1Index <=end)
			maxSonIndex = son1Index;
		//postoji sin2
		if(son2Index <= end) {
			//postoje oba sina, uporedi ih
			if(arr[son2Index].compareTo(arr[son1Index]) >0) {
				maxSonIndex = son2Index;
			}
		}
		return maxSonIndex;
	}
}
