import org.svetovid.io.SvetovidReader;

public class Lokacija extends InfoTip {
	private int sirina, sirinaDec, duzina, duzinaDec;

	public Lokacija(int sirina, int sirinaDec, int duzina, int duzinaDec) {
		super();
		this.sirina = sirina;
		this.sirinaDec = sirinaDec;
		this.duzina = duzina;
		this.duzinaDec = duzinaDec;
	}

	public Lokacija() {
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (o == null)
			return false;
		else if (!(o instanceof Lokacija))
			return false;
		else {
			Lokacija l = (Lokacija) o;
			if (this.sirina == l.sirina && this.sirinaDec == l.sirinaDec && this.duzina == l.duzina
					&& this.duzinaDec == l.duzinaDec)
				return true;
		}
		return false;
	}

	public int hashCode() {
		int r = 17;
		r = 17 * r + sirina * 17;
		r = 17*r + sirinaDec * 17;
		r = 17 * r + duzina * 17;
		r = 17 * r + duzinaDec * 17;
		return r;
	}

	@Override
	public Lokacija ucitaj(SvetovidReader read) {
		return new Lokacija(read.readInt(),read.readInt(),read.readInt(),read.readInt());
	}

	// pomocni metod za lakse testiranje
	public static void main(String[] args) {
		new TestHash(new Lokacija(), "res/", "l").run();
	}
}
