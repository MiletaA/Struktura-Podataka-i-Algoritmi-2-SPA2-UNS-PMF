package adtMapaRealzivanaOtvorenoHesovanjem;

public class Glavna {
	public static void main(String[] args) {
		OHashMap<String, Person> map = new OHashMap<String, Person>(5);
		map.insert("1235", new Person("Pera", 24));
		map.insert("2896", new Person("Mika", 21));
		map.insert("3521", new Person("Zika", 23));
		map.insert("3521", new Person("Fica", 26));
		map.insert("2225", new Person("Mica", 22));
		map.insert("9862", new Person("Tika", 28));
		map.print();
		System.out.println("Osoba 1235: " + map.get("1235"));
		map.print();
		}
}
