
public class Singleton {
	private static Singleton s;

	private Singleton() {
		System.out.println("Object Created and object invoked");
	}

	public static Singleton createO() {
		if (s == null)
			s = new Singleton();
		return s;
	}

	public static void main(String[] args) {
		Singleton s = Singleton.createO();
		Singleton ss = Singleton.createO();
		System.out.println(s.getClass());
	}
}
