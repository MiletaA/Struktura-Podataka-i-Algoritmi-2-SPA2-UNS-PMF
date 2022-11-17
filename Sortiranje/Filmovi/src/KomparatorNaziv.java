import java.util.Comparator;

public class KomparatorNaziv implements Comparator<Film>{

	@Override
	public int compare(Film o1, Film o2) {
		return o1.getNaziv().compareTo(o2.getNaziv());
	}

}
