import java.util.Objects;

import org.svetovid.io.SvetovidReader;

public class Dete extends InfoTip {
	private String ime, prezime;
	private int god;
	private boolean dl;
	private Lokacija g, k, d;

	public Dete(String ime, String prezime, int god, boolean dl, Lokacija g, Lokacija k, Lokacija d) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.god = god;
		this.dl = dl;
		this.g = g;
		this.k = k;
		this.d = d;
	}

	public Dete() {
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (o == null)
			return false;
		else if (!(o instanceof Dete))
			return false;
		else {
			Dete drugo = (Dete) o;
			if (Objects.equals(o, drugo) && this.god == drugo.god && this.dl == drugo.dl)
				return true;
		}
		return false;

	}

	public int hashCode() {
		int rez = 17;
		if (this.ime != null)
			rez = 17 * rez + ime.hashCode() * 17;
		if (this.prezime != null)
			rez = 7919 * rez + prezime.hashCode() * 17;
		int tmp = dl ? 1 : 0;
		rez = 17 * rez + tmp * 17;
		if (this.g != null)
			rez = 17 * rez + g.hashCode() * 17;
		if (this.k != null)
			rez = 17 * rez + k.hashCode() * 17;
		if (this.d != null)
			rez = 17 * rez + d.hashCode() * 17;

		return rez;
	}

	@Override
	public Dete ucitaj(SvetovidReader read) {
		String ime = read.readLine();
		String prez = read.readLine();
		boolean dl;
		String tmp = read.readToken();
		if(tmp.equals("da"))
			dl = true;
		else 
			dl = false;
		int god = read.readInt();
		Lokacija g = new Lokacija(read.readInt(),read.readInt(),read.readInt(),read.readInt());
		Lokacija k = new Lokacija(read.readInt(),read.readInt(),read.readInt(),read.readInt());
		Lokacija d = new Lokacija(read.readInt(),read.readInt(),read.readInt(),read.readInt());
		return new Dete(ime,prez,god,dl,g,k,d);
	}

	// pomocni metod za lakse testiranje
	public static void main(String[] args) {
		new TestHash(new Dete(), "res/", "d").run();
	}
}
