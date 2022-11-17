import java.util.Comparator;

public class KomparatorId implements Comparator<Film>{

	@Override
	public int compare(Film o1, Film o2) {
		return o1.getId() - o2.getId();
	}

}
