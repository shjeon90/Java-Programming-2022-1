import java.io.IOException;

public class AppClient3 {

    public static void main(String[] args) throws IOException {
        SocketClient sc = new SocketClient();
        sc.init();
        sc.run();
        sc.close();
    }
}
