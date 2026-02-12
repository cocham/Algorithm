import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        dfs(0);
        System.out.println(cnt);
    }
    
    static void dfs(int row) {
        if (row == N) {
            cnt++;
            return;
        }
        
        for (int c = 0; c < N; c++) {
            arr[row] = c;
            
            if (isSafe(row)) {
                dfs(row + 1);
            }
        }
    }
    
    static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[row] == arr[i]) {
                return false;
            } else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        
        return true;
    }
}
