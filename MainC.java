import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainC {
	private static final String SERVER_ADDRESS = "localhost";
	private static final int SERVER_PORT = 12345;

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
			System.out.println("Connected to chat server at " + SERVER_ADDRESS + ":" + SERVER_PORT);

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

			String message;
			while ((message = consoleReader.readLine()) != null) {
				writer.println(message);
				System.out.println("Sent: " + message);

				String response = reader.readLine();
				if (response != null) {
					System.out.println("Received: " + response);
				} else {
					System.out.println("Server closed the connection.");
					break;
				}
			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
