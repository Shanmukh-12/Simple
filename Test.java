class Testob {
	int a, b;

	Testob(int i, int j) {
		a = i;
		b = j;
	}

	boolean eual(Testob o) {
		if (o.a == a && o.b == b)
			return true;
		else
			return false;
	}
}

class Test1 {
	int a, b;

	Test1(int x, int y) {
		a = x;
		b = y;
		this.add(a, b);
	}

	Test1() {
		a = -1;
		b = -1;
	}

	int add(int w, int v) {
		int c = w + v;
		System.out.print(c);
		return c;
	}

	static Test1 Me(int a, int b) {
		// add(a, b);
		return null;
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testob ob1 = new Testob(100, 22);
		Testob ob2 = new Testob(100, 22);
		Testob ob3 = new Testob(-1, -1);

		Test1 ob4 = new Test1();
		// System.out.println(ob1.eual(ob2));
		// System.out.println(ob1.eual(ob3));

		// System.out.println(ob4.Me());
		// int s = ob4.Me(10, 20);
	}

}
