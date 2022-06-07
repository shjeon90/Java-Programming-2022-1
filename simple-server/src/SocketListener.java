import java.net.Socket;

public class SocketListener extends Thread {
    private Socket client;

    public SocketListener(Socket client) {
        this.client = client;
    }
}
