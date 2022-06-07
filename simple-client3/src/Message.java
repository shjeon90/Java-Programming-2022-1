import java.io.Serializable;

public class Message implements Serializable {
    private String ip;
    private int port;
    private String msg;

    public Message() {
        this.msg = null;
    }

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Message{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", msg='" + msg + '\'' +
                '}';
    }
}
