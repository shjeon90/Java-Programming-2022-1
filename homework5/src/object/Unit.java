package object;

abstract public class Unit {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected int idx_x;
    protected int idx_y;

    public Unit(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.idx_x = this.idx_y = 0;
    }

    public int getIdx_x() {
        return idx_x;
    }

    public void setIdx_x(int idx_x) {
        this.idx_x = idx_x;
    }

    public int getIdx_y() {
        return idx_y;
    }

    public void setIdx_y(int idx_y) {
        this.idx_y = idx_y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
