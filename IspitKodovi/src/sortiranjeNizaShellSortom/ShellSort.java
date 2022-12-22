package sortiranjeNizaShellSortom;
 /*  Osnovna ideja: 
 Ukupan broj parova elemenata u inverziji se moţe 
posmatrati kao mera neuređenosti niza.
 Kod elementarnih metoda sortiranja, pri svakom 
poređenju susednih elemenata, ukupan broj inverzija se 
smanjuje za jedan.
 Razmena nesusednih elemenata u nizu moţe smanjiti 
više od jedne inverzije. */
public class ShellSort {
	private static int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

	public static <T extends Comparable<T>> void shellSort(T[] arr) {
		for (int k : gaps) {
			if (k > arr.length)
				continue;

			// sortiraj svaki od k podnizova
			for (int i = 0; i < k; i++) {
				// sortiramo podniz (i, i+k,i + 2k, i + 3k...) umetanjem
				for (int j = i + k; j < arr.length; j += k) {
					T curr = arr[j];
					int prevIndex = j - k;
					while (prevIndex >= i && arr[prevIndex].compareTo(curr) > 0) {
						arr[prevIndex + k] = arr[prevIndex];
						prevIndex -= k;
					}
					arr[prevIndex + k] = curr;

				}
			}
		}
	}
}
