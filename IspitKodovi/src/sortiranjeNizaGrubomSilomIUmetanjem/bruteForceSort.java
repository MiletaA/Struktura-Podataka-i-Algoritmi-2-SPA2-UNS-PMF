package sortiranjeNizaGrubomSilomIUmetanjem;

import java.util.Comparator;
/* 
 Niz A od n elemenata je sortiran (neopadajuće) akko
	za svako 0 ≤ i < j < n: A[i] ≤ A[j]
 Za dva elementa niza A sa indeksima i i j, i < j, kaţemo da su 
	u inverziji ako je A[i] > A[j].
 Sortiranje grubom silom (engl. brute force) se svodi na 
	poređenje svaka dva elementa u nizu, pri čemu elemente u 
	inverziji razmenjujemo
 Za niz od n elemenata, ukupno imamo n(n-1)/2 poređenja ->vremenska slozenost sortiranja grubom silom je O(n2)
 Stoga je sortiranje, u najlošijem slučaju, operacija kvadratne 
sloţenosti veličine ulaznog niza*/
public class bruteForceSort {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		for(int j = 1;j<arr.length;j++) {
			for(int i = 0;i<j;i++) {
				if(arr[i].compareTo(arr[j])>0) {
					T tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	public static <T> void sortKomparator(T[] arr, Comparator<T> cmp) {
		for(int j = 1;j<arr.length;j++) {
			for(int i = 0;i<j;i++) {
				if(cmp.compare(arr[i],arr[j])>0) {
					T tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
} 
