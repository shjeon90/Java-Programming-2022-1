public class AppShape {

    public static void main(String[] args) {
        MyShape s = new MyShape();
        s.draw();
        s = new MyRect();
        s.draw();
        s = new MyCircle();
        s.draw();
    }
}
