import java.util.ArrayList;

public class OverrideString {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();
		a.add("abc");
		a.add("qwe");
		a.add("yio");
		a.add("hda");
		a.add("abc");
		a.add("oai");
		for (int i = 0; i < a.size(); i++) {
			String s = a.get(i);

			if (s.equals(a)) {
				System.out.println("Hello");
			}
		}
	}
}
