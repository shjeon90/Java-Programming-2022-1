import java.io.*;
import java.net.Socket;

public class SocketListener extends Thread {
    private Socket server;
    private ObjectInputStream ois;
    private PrintWriter pw;
    private boolean isRun;

    public SocketListener(Socket server, PrintWriter pw) throws IOException {
        this.server = server;
        this.ois = new ObjectInputStream(server.getInputStream());
        this.pw = pw;
        this.isRun = true;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    @Override
    public void run() {

        while (this.isRun) {
            try {
                Message msg = (Message) this.ois.readObject();
                System.out.println("from server: " + msg);
                synchronized (this.pw) {
                    this.pw.println("from server> " + msg.getMsg());
                }
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            }
        }

        try {
            this.ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
