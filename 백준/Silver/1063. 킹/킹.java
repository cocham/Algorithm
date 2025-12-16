import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        King king = new King(st.nextToken());
        Stone stone = new Stone(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            Direction direction = Direction.valueOf(br.readLine().trim());
            king.moveKing(direction, stone);
        }

        System.out.println(king);
        System.out.println(stone);
    }

    static class King {
        private Position position;

        public King(String startPos) {
            int col = startPos.charAt(0) - 'A';
            int row = startPos.charAt(1) - '1';

            this.position = new Position(row, col);
        }

        public void moveKing(Direction direction, Stone stone) {
            Position nextPos = position.move(direction);

            if (!nextPos.canMove()) {
                return;
            }

            if (nextPos.isSamePosition(stone.getPosition())) {
                Position stoneNextPos = stone.getPosition().move(direction);

                if (!stoneNextPos.canMove()) {
                    return;
                }

                stone.setPosition(stoneNextPos);
            }

            this.position = nextPos;
        }

        @Override
        public String toString() {
            return position.toString();
        }
    }

    static class Stone {
        private Position position;

        public Stone(String startPos) {
            int col = startPos.charAt(0) - 'A';
            int row = startPos.charAt(1) - '1';

            this.position = new Position(row, col);
        }

        public Position getPosition() {
            return this.position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return position.toString();
        }
    }

    static class Position {
        private int row;
        private int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Position move(Direction direction) {
            return new Position(row + direction.getRow(), col + direction.getCol());
        }

        public boolean canMove() {
            return row >= 0 && row < 8 && col >= 0 && col < 8;
        }

        public boolean isSamePosition(Position pos) {
            return this.row == pos.row && this.col == pos.col;
        }

        @Override
        public String toString() {
            return (char) (col + 'A') + "" + (row + 1);
        }
    }

    static enum Direction {
        R(0, 1),
        L(0, -1),
        B(-1, 0),
        T(1, 0),
        RT(1, 1),
        LT(1, -1),
        RB(-1, 1),
        LB(-1, -1);

        private final int row;
        private final int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}