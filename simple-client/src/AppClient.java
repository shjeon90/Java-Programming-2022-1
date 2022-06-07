import java.io.IOException;

public class AppClient {

    public static void main(String[] args) throws IOException {
        SocketClient sc = new SocketClient();
        sc.init();
        sc.run();
        sc.close();
    }
}
