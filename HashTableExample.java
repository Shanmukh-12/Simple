import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTableExample {
	public static void main(String args[]) {
		Hashtable<String, String> inner = new Hashtable<>();
		Map<String, Map<String, String>> outerMap = new HashMap<>();

		inner.put("ISBN", "Title");
		inner.put("ISBN123456", "JAVA");
		inner.put("ISBN879987", "Python");
		inner.put("ISBN546780", "C++");

		outerMap.put("CSE", inner);

		outerMap.put("ECE", inner);
		outerMap.put("EEE", inner);
		outerMap.put("MECH", inner);

		// System.out.println(outerMap);

		Set<String> ss = outerMap.keySet();
		for (String s : ss) {
			System.out.println(s + " " + "Department");
			System.out.println();
			Set<String> d = inner.keySet();
			for (String f : d) {
				System.out.println(f + " " + inner.get(f));
			}
			System.out.println();
		}
		System.out.println(outerMap);

	}
}
