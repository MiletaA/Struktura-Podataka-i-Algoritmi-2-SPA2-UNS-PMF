
import java.util.Comparator;

/*   INSERTION SORT
Sortiranje umetanjem daje najbolje rezultate ukoliko su
elementi niza mali ili je poredjenje komplikovano, tj ako
je premestanje brze od poredjenja.

IDEJA SORTIRANJA:
Pretpostavimo da je pocetak niza sortiran. Prvi element iz
nesortiranog dela niza ubacujemo u sortirani deo na
odgovarajuce mesto i to ponavljamo dokle god ne dodjemo do
kraja niza.
*/

public class SortiranjeUmetanjem {

	public static <Film extends Comparable<Film>> void sortiranjeUmetanjem(Film[] arr, Comparator<Film> c) {
		for (int i = 1; i < arr.length; i++) {
			/*
			 * if(arr[i].compareTo(arr[i-1])<0) { Film curr = arr[i]; moze i bez ove provere
			 * }
			 */

			Film curr = arr[i];
			// trazimo najvece j t.d. je arr[j] <= curr
			int j = i - 1;
			while (j >= 0 && c.compare(arr[j], curr) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = curr;
		}
	}
}
