import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
	Reflect() {
		System.out.println("Sample");
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class<?> c = Class.forName("Main");
		// System.out.println(c.getName());
		//
		Constructor<?>[] cc = c.getConstructors();
		// System.out.println(cc);
		for (Constructor<?> scc : cc) {
			// System.out.println(scc.getParameters().getClass());
			for (Class<?> p : scc.getParameterTypes()) {
				// System.out.println(p.getName());
			}
		}

		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("startGame");
		m.invoke(o);
	}

}
