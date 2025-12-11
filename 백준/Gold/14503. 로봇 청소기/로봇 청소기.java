import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Room room = new Room(n, m);

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(r, c, d);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                room.setStatus(i, j, k);
            }
        }

        robot.startCleaning(room);

        System.out.println(robot.getCleanCount());
    }
}

class Robot {
    private int xPosition;
    private int yPosition;
    private Direction direction;
    private int cleanCount = 0;

    Robot(int xPosition, int yPosition, int direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = Direction.getDirection(direction);
    }

    public void startCleaning(Room room) {
        while (true) {
            if (!room.isCleand(xPosition, yPosition)) {
                room.clean(xPosition, yPosition);
                cleanCount++;
            }

            if (canCleanAround(room)) {
                direction = direction.turnLeft(direction.getD());

                int moveX = xPosition + direction.getRow();
                int moveY = yPosition + direction.getCol();

                if (!room.isWall(moveX, moveY) && !room.isCleand(moveX, moveY)) {
                    xPosition = moveX;
                    yPosition = moveY;
                }
            } else {
                int backX = xPosition - direction.getRow();
                int backY = yPosition - direction.getCol();

                if (room.isWall(backX, backY)) {
                    break;
                }

                xPosition = backX;
                yPosition = backY;
            }
        }
    }

    private boolean canCleanAround(Room room) {
        for (Direction dir : Direction.values()) {
            int moveX = xPosition + dir.getRow();
            int moveY = yPosition + dir.getCol();
            
            if (!room.isWall(moveX, moveY) && !room.isCleand(moveX, moveY)) {
                return true;
            }
        }

        return false;
    }

    public int getCleanCount() {
        return cleanCount;
    }
}

class Room {
    private int[][] room;

    public Room(int n, int m) {
        room = new int[n][m];
    }

    public void setStatus(int i, int j, int k) {
        room[i][j] = k;
    }

    public boolean isWall(int i, int j) {
        return room[i][j] == 1;
    }

    public boolean isCleand(int i, int j) {
        return room[i][j] == 2;
    }

    public void clean(int i, int j) {
        room[i][j] = 2;
    }
}

enum Direction {
    UP(0, -1, 0),
    RIGHT(1, 0, 1),
    DOWN(2, 1, 0),
    LEFT(3, 0, -1);

    private final int d;
    private final int row;
    private final int col;

    Direction(int d, int row, int col) {
        this.d = d;
        this.row = row;
        this.col = col;
    }

    public static Direction getDirection(int d) {
        return Arrays.stream(values())
                .filter(dir -> dir.d == d)
                .findFirst()
                .orElseThrow();
    }

    public Direction turnLeft(int d) {
        int dir = -1;
        if (d == 0) dir = 3;
        else if (d == 1) dir = 0;
        else if (d == 2) dir = 1;
        else if (d == 3) dir = 2;

        return Direction.getDirection(dir);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getD() {
        return d;
    }
}