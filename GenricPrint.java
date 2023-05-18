
public class GenricPrint {
	private double val;

	<T extends Number> GenricPrint(T args) {
		val = args.doubleValue();
	}

	void showValue() {
		System.out.println(val);
	}

	public static <V> void printArray(V[] input) {
		for (V ele : input) {
			System.out.printf("%s ", ele);
		}
	}

	public static <t, v extends t> boolean pprint(t x, v[] z) {
		for (int i = 0; i < z.length; i++) {
			if (x.equals(z[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenricPrint g = new GenricPrint(100);
		GenricPrint f = new GenricPrint(2.0f);
		g.showValue();
		f.showValue();

		Integer[] a = { 1, 2, 3, 4, 5, 6 };
		printArray(a);
		System.out.println();

		if (pprint(1, a)) {
			System.out.println("one in Strs");
		} else {
			System.out.print("No");
		}

		String strs[] = { "one", "two", "three", "four", "five" };
		if (pprint("one", strs)) {
			System.out.println("one in Strs");
		} else {
			System.out.print("No");
		}
	}

}
