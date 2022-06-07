import java.io.*;
import java.net.Socket;

public class SocketClient {
    private Socket server;

    public SocketClient() {

    }

    public void init(){

    }

    public void run() throws IOException {
        System.out.println("connent to server");
        this.server = new Socket(Constants.SERVER_IP, Constants.SERVER_PORT);
        System.out.println(this.server);

        System.out.println("create streams");
        PrintWriter pw = new PrintWriter(this.server.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(this.server.getInputStream()));

        System.out.println("send msg");
        pw.println("hello, world");

        System.out.println("receive msg");
        String msg = br.readLine();
        System.out.println("from server: " + msg);

        pw.close();
        br.close();

    }

    public void close() throws IOException {
        this.server.close();
    }
}
