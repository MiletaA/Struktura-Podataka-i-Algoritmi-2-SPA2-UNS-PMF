package sortiranjeNizaGrubomSilomIUmetanjem;

public class Glavna {
	public static void main(String[] args) {
		Radnik[] radnici = new Radnik[4];
		radnici[0] = new Radnik("Mika",54000);
		radnici[1] = new Radnik("Zika",14000);
		radnici[2] = new Radnik("Tika",16000);
		radnici[3] = new Radnik("Pera",9000);
		bruteForceSort.sort(radnici);
		for(int i = 0;i<radnici.length;i++) {
			System.out.println(radnici[i]);	
		}
		System.out.println("Radnici sortirani po plati(komparator):");
		bruteForceSort.sortKomparator(radnici,new KomparatorPoPlati());
		for(int i = 0;i<radnici.length;i++) {
			System.out.println(radnici[i]);
		}
		insertionSort.insertionSort(radnici);
		
	}
}
