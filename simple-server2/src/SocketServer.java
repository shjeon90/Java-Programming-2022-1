import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ServerSocket serverSocket;

    public SocketServer() {

    }

    public void init() throws IOException {
        System.out.println("open the server socket");
        this.serverSocket = new ServerSocket(Constants.Server_PORT);
        this.serverSocket.setReuseAddress(true);
    }

    public void run() throws IOException, ClassNotFoundException {
        System.out.println("take a client");
        Socket client = this.serverSocket.accept();
        System.out.println(client);

        System.out.println("create streams");
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

        while (true) {
            try {
                Message msg = (Message) ois.readObject();
                System.out.println("from client: " + msg.toString());

                if (msg.getMsg().equals("quit")) break;

                msg.setMsg(msg.getMsg() + "-from server");
                oos.writeObject(msg);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }

        ois.close();
        oos.close();
        client.close();
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }
}
