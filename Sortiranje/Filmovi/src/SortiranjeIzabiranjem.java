import java.util.Comparator;

/*  SELECTION SORT
Sortiranje izabiranjem je najbolje ukoliko su elementi niza
veliki, odnosno ako je operacija poredjenja brza od
premestanja elemenata u nizu.

 IDEJA SORTIRANJA:
Pretpostavimo da je pocetak niza, prvih K elemenata,
sortiran i da je u njemu K najmanjih elemenata. U
nesortiranom delu niza nadjemo najmanji element i postavimo
ga na pocetak nesortiranog dela.

*/
public class SortiranjeIzabiranjem {

	public static <Film extends Comparable<Film>> void sortiranjeIzabiranjem(Film[] arr, Comparator<Film> c) {
		for (int i = arr.length - 1; i > 0; i--) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if (c.compare(arr[max], arr[j]) < 0)
					max = j;
			}
			Film tmp = arr[max];
			arr[max] = arr[i];
			arr[i] = tmp;
		}
	}
}
