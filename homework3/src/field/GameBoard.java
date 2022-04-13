package field;

import constant.Constant;
import object.Computer;
import object.Player;

public class GameBoard {
    private Field[][] fields;

    public GameBoard () {
        this.fields = new Field[Constant.BOARD_HEIGHT][Constant.BOARD_WIDTH];
    }

    public void init() {
        for (int h = 0;h < Constant.BOARD_HEIGHT;++h) {
            for (int w = 0;w < Constant.BOARD_WIDTH;++w) {
                if (h == 0 || h == Constant.BOARD_HEIGHT-1) {
                    this.fields[h][w] = new Field(true);
                } else if (w == 0 || w == Constant.BOARD_WIDTH-1) {
                    this.fields[h][w] = new Field(true);
                } else {
                    this.fields[h][w] = new Field(false);
                }
            }
        }
    }

    public void setPlayerWithNull(int x, int y) {
        this.fields[y][x].setPlayer(null);
    }

    public void setComputerWithNull(int x, int y) {
        this.fields[y][x].setComputer(null);
    }

    public void setPlayer(Player player) {
        Field field = this.fields[player.getY()][player.getX()];
        field.setPlayer(player);
    }

    public void setComputer(Computer computer) {
        Field field = this.fields[computer.getY()][computer.getX()];
        field.setComputer(computer);
    }

    @Override
    public String toString() {
        String str = "";
        for (int h = 0;h < Constant.BOARD_HEIGHT;++h) {

            for (int w = 0;w < Constant.BOARD_WIDTH;++w) {
                str += this.fields[h][w].toString();
            }
            str += "\n";
        }

        return str;
    }
}
