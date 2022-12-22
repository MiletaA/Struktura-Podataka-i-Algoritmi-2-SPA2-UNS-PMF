package sortiranjeNizaGrubomSilomIUmetanjem;
 /*  Ideja: 
 niz je sastavljen od sortiranog i nesortiranog dela pri 
čemu je sortirani deo sa leve strane
 prvi element iz nesortiranog dela ubaci u sortirani 
deo na odgovarajuće mesto (sortirani deo niza se 
tako povećava za jedan element)
 ponavljaj prethodni korak dok ceo niz ne postane 
sortiran
 početak: sortirani deo je prvi element niza, ostatak 
niza je nesortirani deo
 Pomeranje elemenata vršimo dok tražimo indeks j
*/
public class insertionSort {
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			T curr = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].compareTo(curr) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = curr;
		}
	}

	public static <T extends Comparable<T>> void insertionSort_v2(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[i - 1]) < 0) {
				T curr = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j].compareTo(curr) > 0) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = curr;
			}
		}
	}

	public static <T extends Comparable<T>> void insertionSort_v3(T[] arr) {
		int minIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[minIndex]) < 0) {
				minIndex = i;
			}
		}
		if (minIndex != 0) {
			T tmp = arr[minIndex];
			arr[minIndex] = arr[0];
			arr[0] = tmp;
		}
		for (int i = 2; i < arr.length; i++) {
			T curr = arr[i];
			// trazimo j t.d. je arr[j] <= curr
			int j = i - 1;
			while (arr[j].compareTo(curr) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = curr;
		}
	}

}
