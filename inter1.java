public interface inter1 {
	public void method1();
}

class one implements inter1 {
	public void method1() {
		System.out.println("Method1 implemented in class one");
	}
}

class s1 {
	public static void main(String args[]) {
		one o = new one();
		o.method1();
	}
}
