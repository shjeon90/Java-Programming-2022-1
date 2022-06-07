import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class ListenerThread extends Thread {
    private Client client;
    private volatile Queue<Message> messageQueue;
    private boolean flag;

    public ListenerThread(Client client, Queue<Message> messageQueue) {
        this.client = client;
        this.messageQueue = messageQueue;
        this.flag = true;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message msg = (Message) this.client.getOis().readObject();
                System.out.println("receive " + msg);

                if (msg.getMsg().equals("quit")) break;

                synchronized (this.messageQueue) {
                    this.messageQueue.add(msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        this.client.setDisconnected(true);
        this.flag = false;
    }
}
