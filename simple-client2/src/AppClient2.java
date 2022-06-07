import java.io.IOException;

public class AppClient2 {

    public static void main(String[] args) throws IOException {
        SocketClient sc = new SocketClient();
        sc.init();
        sc.run();
        sc.close();
    }
}
