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
    private List<ListenerThread> clientThreadList;
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

            ListenerThread thread = new ListenerThread(client, messageQueue);

            synchronized (this.clientList) {
                this.clientList.add(client);
            }
            synchronized (this.clientThreadList) {
                this.clientThreadList.add(thread);
                thread.start();
            }

            synchronized (this.clientThreadList) {
                Iterator<ListenerThread> listenerThreadIterator = this.clientThreadList.iterator();
                while (listenerThreadIterator.hasNext()) {
                    ListenerThread lThread = listenerThreadIterator.next();
                    if (!lThread.isFlag()) {
                        listenerThreadIterator.remove();
                    }
                }
            }

            synchronized (this.clientList) {
                Iterator<Client> clientIterator = this.clientList.iterator();
                while (clientIterator.hasNext()) {
                    Client c = clientIterator.next();
                    if (c.isDisconnected()) {
                        clientIterator.remove();
                    }
                }
            }
        }
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }
}
