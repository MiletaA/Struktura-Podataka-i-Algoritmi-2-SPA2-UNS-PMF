import java.util.Comparator;

public class Glavna {
	public static void main(String[] args) {
		Film[] filmovi = Film.ucitaj(Svetovid.in.readToken("Unesite naziv fajla: "));

		Svetovid.out.println("Moguci komparatori :");
		Svetovid.out.println("1. id");
		Svetovid.out.println("2. naziv");
		Svetovid.out.println("3. reditelj");
		Svetovid.out.println("4. reditelj/naziv - prirodan komparator");
		Comparator<Film> c;
		// Ukoliko zelimo prirodni komparator(compareTo),
		// pozovemo ga kao u liniji 28 i prosledimo ga kao u linijama 40,42,48
		// samim tim nema potrebe za pisanjem razlicitih sortova, odnosno sorta sa compareTo
		switch (Svetovid.in.readInt("Odaberite komparator")) {
		case 1:
			c = new KomparatorId();
			break;

		case 2:
			c = new KomparatorNaziv();
			break;
		case 3:
			c = new KomparatorReditelj();
			break;
		case 4:
			c = Film::compareTo; //da se poziva prirodni poredak
			
			break;
		default:
			Svetovid.err.println("Greska pri odabiru komparatora");
			return;
		}
		Svetovid.out.println("Moguca sortiranja :");
		Svetovid.out.println("1. Sortiranje Razmenom");
		Svetovid.out.println("2. Sortiranje Izabiranjem");
		Svetovid.out.println("3. Sortiranje Umetanjem");
		int nacin;
		switch (nacin = Svetovid.in.readInt("unesite nacin sortiranja: ")) {
		case 1:
			SoritranjeRazmenom.sortiranjeRazmenom(filmovi, c);
			break;
		case 2:
			SortiranjeIzabiranjem.sortiranjeIzabiranjem(filmovi, c);
			break;
		case 3:
			SortiranjeUmetanjem.sortiranjeUmetanjem(filmovi, c);
			break;
		default:
			Svetovid.err.println("Greska pri odabiru sortiranja");
			return;

		}
		Film.ispis(filmovi);
		Film.sacuvaj(filmovi, Svetovid.in.readToken("Unesi naziv fajla"));

	}
}
