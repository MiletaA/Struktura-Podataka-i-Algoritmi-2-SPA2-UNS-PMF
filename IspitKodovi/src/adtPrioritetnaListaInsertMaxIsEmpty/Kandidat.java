package adtPrioritetnaListaInsertMaxIsEmpty;

public class Kandidat implements Comparable<Kandidat> {
	private String ime;
	private int brBodovaSk;
	private int brBodavaPrijemni;

	public Kandidat(String ime, int brBodovaSk, int brBodavaPrijemni) {
		super();
		this.ime = ime;
		this.brBodovaSk = brBodovaSk;
		this.brBodavaPrijemni = brBodavaPrijemni;
	}
	

	@Override
	public String toString() {
		return "Kandidat [ime=" + ime + ", brBodovaSk=" + brBodovaSk + ", brBodavaPrijemni=" + brBodavaPrijemni + "]";
	}


	@Override
	public int compareTo(Kandidat dr) {
		int uk1 = brBodavaPrijemni + brBodovaSk;
		int uk2 = dr.brBodavaPrijemni + dr.brBodovaSk;
		return uk1 - uk2;
	}
	
}
