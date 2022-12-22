package sortiranjeNizaIzabiranjemIRazmenom;
 /* 
Verzija 1:
Neka je sortirani deo niza sa desne strane
Radimo isplivavanje maksimalnog elementa u 
nesortiranom delu niza
 Verzija 2:
Neka je sortirani deo niza sa leve strane
Radimo isplivavanje minimalnog elementa u 
nesortiranom delu niza

*Verzija 1:
*Neka je n duţina niza A i neka je
 A[0 .. i] nesortirani deo niza
 A[i + 1 .. n - 1] sortirani deo niza
 Radimo isplivavanje maksimalnog elementa u nesortiranom 
delu
 Poredimo A[j] i A[j + 1] za j koje varira od 0 do i – 1
 Tada kraj nesortiranog dela niza (i) varira 
 od n – 1 (nesortirani deo niza je ceo niz) 
 do 1 (nesortirani deo niza čine prva dva elementa)

*Verzija 2:
Neka je n duţina niza A i neka je
 A[0 .. i - 1] sortirani deo niza
 A[i .. n - 1] nesortirani deo niza
 Radimo isplivavanje minimalnog elementa u nesortiranom 
delu niza
 Poredimo A[j] i A[j - 1] za j koje varira od n - 1 do i + 1
 Tada kraj početak dela niza (i) varira 
 od 0 (nesortirani deo niza je ceo niz) 
 do n - 2 (nesortirani deo niza čine poslednja dva 
elementa)

*/
//bubbleSort

public class exchangeSort {
	public static <T extends Comparable<T>> void exchangeSort(T[] arr) {
		// isplivavanje max
		// arr[0..i] je nesortiran deo niza stoga i varra od arr.lenght -1 do 1
		for (int i = arr.length - 1; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void exchangeSort_v2(T[] arr) { 
		// isplivavanje min
		// arr[i..n-1] je nesortirani deo niza, stoga i varira od 0 do arr.lenght -2
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j].compareTo(arr[j - 1]) < 0) {
					T tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void exchangeSort_v3(T[] arr) { // napredno
		// isplivavenj max
		// arr[0..i] je nesortirani deo, stoga i varira od arr.lenght-1 do 1
		for (int i = arr.length - 1; i >= 1; i--) {
			boolean exchangeOccured = false;
			for (int j = 0; j < i; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					exchangeOccured = true;
				}
			}
			if (!exchangeOccured)
				break;
		}

	}

}
