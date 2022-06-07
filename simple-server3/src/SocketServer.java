import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class SocketServer {
    private ServerSocket serverSocket;
    private volatile List<Client> clientList;
    private volatile List<ListenerThread> clientThreadList;
    private BroadcastThread broadcastThread;

    public SocketServer() {
        this.clientList = new ArrayList<>();
        this.clientThreadList = new ArrayList<>();
    }

    public void init() throws IOException {
        System.out.println("open the server socket");
        this.serverSocket = new ServerSocket();
        this.serverSocket.bind(new InetSocketAddress("192.168.10.100", Constants.Server_PORT));
        this.serverSocket.setReuseAddress(true);
    }

    public void run() throws IOException, ClassNotFoundException {
        Queue<Message> messageQueue = new LinkedList<>();
        this.broadcastThread = new BroadcastThread(this.clientList, messageQueue);
        this.broadcastThread.start();

        while (true) {
            Socket socket = this.serverSocket.accept();
            Client client = new Client(socket);
            System.out.println("new client: " + client);

            ListenerThread thread = new ListenerThread(client, messageQueue);

            synchronized (this.clientList) {
                this.clientList.add(client);
                thread.setClientList(this.clientList);
            }
            synchronized (this.clientThreadList) {
                this.clientThreadList.add(thread);
                thread.setClientThreadList(this.clientThreadList);
                thread.start();
            }
        }
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }
}
