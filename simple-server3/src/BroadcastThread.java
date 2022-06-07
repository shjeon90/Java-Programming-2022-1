import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class BroadcastThread extends Thread {
    private volatile List<Client> clientList;
    private volatile Queue<Message> messageQueue;

    public BroadcastThread(List<Client> clientList, Queue<Message> messageQueue) {
        this.clientList = clientList;
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (this.messageQueue) {
                Message msg = this.messageQueue.poll();

                if (msg != null) {
                    System.out.println("send " + msg);

                    for (Client client: this.clientList) {

                        if (!(client.getIp().equals(msg.getIp()) && client.getPort() == msg.getPort())) {
                            try {
                                client.getOos().writeObject(msg);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
