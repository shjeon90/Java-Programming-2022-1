import java.io.*;
import java.net.Socket;

public class SocketClient {
    private Socket server;
    private SocketListener socketListener;

    public SocketClient() {

    }

    public void init(){

    }

    public void run() throws IOException {
        System.out.println("connect to server");
        this.server = new Socket(Constants.SERVER_IP, Constants.SERVER_PORT);
        System.out.println(this.server);

        System.out.println("create streams");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream oos = new ObjectOutputStream(this.server.getOutputStream());
//        FileWriter fw = new FileWriter("client.txt");
        PrintWriter pw = new PrintWriter(new FileOutputStream("client.txt"), true);

        System.out.println("create listener thread");
        this.socketListener = new SocketListener(this.server, pw);
        this.socketListener.start();

        while (true) {
            System.out.print("input> ");
            String msgStr = br.readLine();
            Message msg = new Message(msgStr);
            oos.writeObject(msg);

            synchronized (pw) {
                pw.println("to server> " + msgStr);
            }

            if (msgStr.equals("quit")) break;
        }

        pw.close();
        br.close();
        oos.close();
        this.socketListener.setRun(false);
    }

    public void close() throws IOException {
        this.server.close();
    }
}
