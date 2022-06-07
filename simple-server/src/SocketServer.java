import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    public void run() throws IOException {
        Socket client = this.serverSocket.accept();
        System.out.println(client);

        System.out.println("create stream");
        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        System.out.println("receive msg");
        String msg = br.readLine();
        System.out.println("from client: " + msg);

        System.out.println("send msg");
        pw.println(msg);

        pw.close();
        br.close();

        client.close();
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }
}
