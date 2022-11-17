import java.util.Comparator;

public class KomparatorReditelj implements Comparator<Film>{

	@Override
	public int compare(Film o1, Film o2) {
		return o1.getReditelj().compareTo(o2.getReditelj());
	}

}
