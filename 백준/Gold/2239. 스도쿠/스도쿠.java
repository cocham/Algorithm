import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    static int[][] arr = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        dfs(0,0);
    }
    
    static void dfs(int row, int col) {
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }   
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }
        
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        
        for (int n = 1; n <= 9; n++) {
            if (arr[row][col] == 0) {
                if (check(row, col, n)) {
                    arr[row][col] = n;
                    dfs(row, col + 1);
                    arr[row][col] = 0;
                }
            } else {
                dfs(row, col + 1);
                return;
            }
        }
    }
    
    static boolean check(int row, int col, int n) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == n) {
                return false;
            } 
            if (arr[row][i] == n) {
                return false;
            }
        }
        
        int startR = (row / 3) * 3;
        int startC = (col / 3) * 3;
        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (arr[i][j] == n) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
