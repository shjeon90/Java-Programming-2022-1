import java.io.IOException;

public class AppServer3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SocketServer ss = new SocketServer();
        ss.init();
        ss.run();
        ss.close();
    }
}
