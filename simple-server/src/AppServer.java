import java.io.IOException;

public class AppServer {

    public static void main(String[] args) throws IOException {
        SocketServer ss = new SocketServer();
        ss.init();
        ss.run();
        ss.close();
    }
}
