import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SimplePortScanner {

    public static void main(String[] args) {
        String targetHost = "127.0.0.1"; // Replace with the target IP address
        int startPort = 1; // Starting port
        int endPort = 1024; // Ending port
        int timeout = 200; // Timeout in milliseconds

        System.out.println("Scanning ports on: " + targetHost);
        
        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                // Try to connect to the specified port
                socket.connect(new InetSocketAddress(targetHost, port), timeout);
                System.out.println("Port " + port + " is open.");
            } catch (IOException e) {
                // Port is closed or connection timed out
                // You can uncomment the next line if you want to see closed ports
                // System.out.println("Port " + port + " is closed.");
            }
        }

        System.out.println("Scanning completed.");
    }
}