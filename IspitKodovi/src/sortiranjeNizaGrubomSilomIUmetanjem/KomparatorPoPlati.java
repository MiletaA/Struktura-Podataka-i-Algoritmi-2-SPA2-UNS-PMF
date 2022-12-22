package sortiranjeNizaGrubomSilomIUmetanjem;

import java.util.Comparator;

public class KomparatorPoPlati implements Comparator<Radnik> {

	@Override
	public int compare(Radnik o1, Radnik o2) {
		return o2.getPlata() - o1.getPlata();
	}
	

}
