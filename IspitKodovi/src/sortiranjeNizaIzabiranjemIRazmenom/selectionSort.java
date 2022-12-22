package sortiranjeNizaIzabiranjemIRazmenom;
 /* Ideja:
 Niz je sastavljen od sortiranog i nesortiranog dela pri čemu je 
sortirani deo sa desne strane
 Tada su svi elementi u nesortiranom delu manji od svih 
elemenata u sortiranom delu niza
 Nađemo maksimum nesortiranog dela niza i postavimo ga na 
kraj nesortiranog dela niza
 Drugim rečima, za niz A veličine n
 Nađemo maks. A[0 .. n – 1] i zamenimo ga sa A[n – 1]
 Nađemo maks. A[0 .. n – 2] i zamenimo ga sa A[n – 2]
 Nađemo maks. A[0 .. n – 3] i zamenimo ga sa A[n – 3]
 …
 Nađemo maks. A[0 .. 1] i zamenimo ga sa A[1]*/
public class selectionSort {
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		// na pocetku trazimo max celog niza
		for (int i = arr.length - 1; i >= 1; i--) {
			int maxIndex = 0;
			for (int j = 1; i <= i; j++) {
				if (arr[maxIndex].compareTo(arr[j]) < 0) {
					maxIndex = j;
				}
			}
			// max ide na kraj podniza[0..i]
			if (maxIndex != i) {
				T tmp = arr[i];
				arr[i] = arr[maxIndex];
				arr[maxIndex] = tmp;

			}
		}
	}

	public static <T extends Comparable<T>> void selectionSort_v2(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {

			// trazimo min u podnizu [i.. arr.lenght-1]
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[minIndex]) < 0)
					minIndex = j;

			}
			//min ide na pocetak podniza [i.. arr.lenght-1]
			if(minIndex != i) {
				T tmp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tmp;
				
			}
		}
	}
}
