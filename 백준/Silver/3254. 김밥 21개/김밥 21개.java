import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[][] board = new int[6][7];
        for (int i = 0; i < 6; i++) {
            Arrays.fill(board[i], 0);
        } 

        for (int i = 0; i < 21; i++) {
            st = new StringTokenizer(br.readLine());
            int si = Integer.parseInt(st.nextToken());
            int ji = Integer.parseInt(st.nextToken());
            
            int rowSk = -1;
            int colSk = si - 1;
            for (int row = 5; row >= 0; row--) {
                if (board[row][colSk] == 0) {
                    board[row][colSk] = 1;
                    rowSk = row;                    
                    break;
                }
            }

            
            if (rowSk != -1 && checkWin(board, rowSk, colSk, 1)) {
                int sangTurn = i + 1;
                System.out.println("sk " + sangTurn);
                return;
            }

            int rowJi = -1;
            int colJi = ji - 1;
            for (int row = 5; row >= 0; row--) {
                if (board[row][colJi] == 0) {
                    board[row][colJi] = 2;
                    rowJi = row;                    
                    break;
                }
            }

            
            if (rowJi != -1 && checkWin(board, rowJi, colJi, 2)) {
                int jiTurn = i + 1;
                System.out.println("ji " + jiTurn);
                return;
            }
        }

        System.out.println("ss");
    }

    public static boolean checkWin(int[][] board, int row, int col, int player) {
        int[] dx = {0, 1, 1, 1};
        int[] dy = {1, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int count = 1;

            int moveX = row + dx[d];
            int moveY = col + dy[d];

            while(moveX >= 0 && moveX < 6 && moveY >= 0 && moveY < 7 
                && board[moveX][moveY] == player) {
                
                count++;
                moveX += dx[d];
                moveY += dy[d];
            } 

            moveX = row - dx[d];
            moveY = col - dy[d];
            
            
            while(moveX >= 0 && moveX < 6 && moveY >= 0 && moveY < 7 
                && board[moveX][moveY] == player) {
                
                count++;
                moveX -= dx[d];
                moveY -= dy[d];
            } 

            if (count >= 4) {
                return true;
            }
        }

        return false;
    }

}