package adtSkupRealizovanZatvorenimHesovanjem;
//moguce da nesto nije dobro
public class Glavna {
	public static void main(String[] args) {
		CHashSet<Integer> set = new CHashSet<>(11);
		//formiramo brojeve koji imaju istu hash vrednost - 2
		for(int i = 0;i<5;i++) {
			int num = 2+ 11 *i;
			System.out.println("dodajem: " + num);
			set.insert(num);
			set.print();
		}
	}
}
