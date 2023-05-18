import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GetClass {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Class<?> s = Class.forName("Main");
		// Method[] mthd = s.getDeclaredMethods();
		Method[] mthd = s.getMethods();
		for (int i = 0; i < mthd.length; i++) {
			System.out.println(mthd[i].getReturnType());
		}
		Constructor con = s.getConstructor();
		// System.out.println(con);
		// System.out.println(s.getSuperclass());

		// for (Method me : mthd) {
		// String m = me.getName();
		// System.out.println("Name of the Method " + m);
		// }
	}

}
