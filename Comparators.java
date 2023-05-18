import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Comparators {

	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
		T candidate = coll.iterator().next();
		for (T f : coll) {
			if (cmp.compare(candidate, f) < 0) {
				candidate = f;
			}
		}
		return candidate;
	}

	public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
		return max(coll, Comparators.<T>naturalOrder());
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparator<String> sizeOrder = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() < s2.length() ? -1 : s1.length() > s2.length() ? 1 : s1.compareTo(s2);
			}
		};
		Collection<String> strings = Arrays.asList("AAA", "aaa", "CCC", "f");

		System.out.println(Comparators.max(strings));
		System.out.println(Comparators.max(strings, sizeOrder));

	}

}
