package sortiranjeNizaQuickSortom;
/* Quicksort je u praksi najčešće primenjivan postupak za 
sortiranje nizova.
 Osmislio ga je Tony Hoare 1959. godine. 
 Quicksort je u proseku linearitamske, O(n∙logn), vremenske 
složenosti.
 Jedan od algoritama koji su zasnovani na principu zavadi pa 
vladaj (engl. divide and conquer)
 Ideja:
 Selektujemo jedan element u nizu koga zovemo pivot.
 Preuredimo niz tako da je oblika (LE pivot QE)
 LE – elementi niza koji su manji ili jednaki od pivota
 QE – elementi niza koji su veći ili jednaki od pivota
 Sortiramo LE i QE quick sortom (stoga se quick sort 
najčešće realizuje rekurzivno)

Selektovanje pivota i transformacija u formu (LE pivot QE) se 
još naziva i particionisanjem niza.
 Postoji više šema particionisanja, od kojih su najpoznatije 
Hoarova šema, Lomutova šema i šema u kojoj biramo element 
pozicioniran na sredini (pod)niza koji se sortira

Performanse quicksorta drastično opadaju ako niz ima veliki 
stepen sortiranosti
 */

public class quickSort {
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T[] arr, int l, int h) {
		if (l < h) {
			int j = partitionLomuto(arr, l, h); //partition
			quickSort(arr, l, j - 1);
			quickSort(arr, j + 1, h);
		}
	}

	private static <T extends Comparable<T>> int partitionHoare(T[] arr, int l, int h) {
		T pivot = arr[l];
		int i = l + 1;
		int j = h;
		while (i <= j) {
			while (i <= h && arr[i].compareTo(pivot) < 0)
				i++;
			while (j >= l + 1 && arr[j].compareTo(pivot) > 0)
				j--;
			if (i <= j) {
				T tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		T tmp = arr[l];
		arr[l] = arr[j];
		arr[j] = tmp;
		return j;
	}

	private static <T extends Comparable<T>> int partitionLomuto(T[] arr, int l, int h) {
		T pivot = arr[h];
		int ltePivot = l - 1; // indeks elem koji su <= pivota
		for (int i = l; i < h; i++) {
			if (arr[i].compareTo(pivot) <= 0) {
				++ltePivot;
				T tmp = arr[ltePivot];
				arr[ltePivot] = arr[i];
				arr[i] = tmp;
			}
		}
		int placeForPivot = ltePivot + 1;
		T tmp = arr[placeForPivot];
		arr[placeForPivot] = arr[h];
		arr[h] = tmp;
		return placeForPivot;
	}

	private static <T extends Comparable<T>> void pivotCentar(T[] arr, int l, int h) {
		T pivot = arr[(l + h) / 2];
		int i = l;
		int j = h;
		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0)
				i++;
			while (arr[j].compareTo(pivot) > 0)
				j--;
			if (i <= j) {
				T tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j++;
			}
		}
		if (l < j)
			quickSort(arr, l, j);
		if (i < h)
			quickSort(arr, i, h);

	}

	// Podnizove A[l..h] koji su male duzine(h-l<17) je efiksanije sortirati
	// elementarnim metodama
	private static <T extends Comparable<T>> void smallAr(T[] arr, int l, int h) {
		if (h - l < 17)
			System.out.println("ElementarySorts.insertionSort(arr, l, h)");
		else {
			int j = partitionLomuto(arr, l, h);
			quickSort(arr, l, j - 1);
			quickSort(arr, j + 1, h);
		}

	}

}
