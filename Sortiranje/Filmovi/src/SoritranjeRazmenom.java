import java.util.Comparator;

/* EXCHANGE SORT (BUBBLE SORT)
Sortiranje razmenom u opstem slucaju daje najgore rezultate.

 IDEJA SORTIRANJA:
Pretpostavimo da je pocetak niza, prvih K elemenata,
sortiran i da je u njemu K najmanjih elemenata. Prolazimo
kroz nesortirani deo, od kraja prema pocetku i za svaka dva
elementa razmenimo mesta ako "stoje pogresno".
 */
public class SoritranjeRazmenom {

	public static <Film extends Comparable<Film>> void sortiranjeRazmenom(Film[] arr, Comparator<Film> c) {

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (c.compare(arr[j], arr[j + 1]) > 0) {
					Film tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
}
