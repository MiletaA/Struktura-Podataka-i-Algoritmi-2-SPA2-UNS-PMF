import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

public class Film implements Comparable<Film> {
	private final int id;
	private final String naziv;
	private final String reditelj;

	public Film(int id, String naziv, String reditelj) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.reditelj = reditelj;
	}

	public int getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getReditelj() {
		return reditelj;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", reditelj=" + reditelj + "]";
	}

	@Override
	public int compareTo(Film o) {
		int r = this.getReditelj().compareTo(o.getReditelj());
		if (r == 0)
			return r = this.getNaziv().compareTo(o.getNaziv());
		return r;
	}

	public static Film[] ucitaj(String fajl) {
		if (!Svetovid.testIn(fajl)) {
			Svetovid.err.println("Ucitavanje nije moguce");
			return null;
		}
		SvetovidReader in = Svetovid.in(fajl);
		int n = in.readInt();
		Film[] filmovi = new Film[n];
		for (int i = 0; i < n; i++) {
			filmovi[i] = new Film(in.readInt(), in.readLine(), in.readLine());
		}
		in.close();
		return filmovi;

	}

	public static void sacuvaj(Film[] filmovi, String fajl) {
		if (!Svetovid.testOut(fajl)) {
			Svetovid.err.println("Upis nije uspeo");
			return;
		}
		SvetovidWriter out = Svetovid.out(fajl);
		out.println(filmovi.length);
		for (Film film : filmovi) {
			out.println(film.id);
			out.println(film.naziv);
			out.println(film.reditelj);
		}
		out.close();

	}

	public static void ispis(Film[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
