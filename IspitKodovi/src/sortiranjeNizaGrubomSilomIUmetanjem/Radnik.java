package sortiranjeNizaGrubomSilomIUmetanjem;

public class Radnik implements Comparable<Radnik> {

	private String ime;
	private int plata;

	public Radnik(String ime, int plata) {
		super();
		this.ime = ime;
		this.plata = plata;
	}
	public String toString() {
		return ime + " " + "plata: " + plata;
	}

	public String getIme() {
		return ime;
	}

	public int getPlata() {
		return plata;
	}

	@Override
	public int compareTo(Radnik o) {
		return ime.compareTo(o.ime);
	}

}
