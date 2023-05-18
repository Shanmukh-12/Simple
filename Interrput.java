class Timer extends Thread {
	public void run() {
		while (true) {
			System.out.println("Time " + new java.util.Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Timer was interrupted");
				return;
			}
		}
	}
}

public class Interrput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Timer t = new Timer();
		t.start();
		Thread.sleep(4000);
		t.interrupt();
	}

}
