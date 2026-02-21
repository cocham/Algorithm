import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static long min = Long.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        dfs(A, 0);
        if (min == Long.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(min + 1);
        }
    }
    
    static void dfs(long num, int cnt) {
        if (num > B) {
            return;
        }
        
        if (num == B) {
            min = Math.min(min, cnt);
            return;
        }
        
        dfs(num * 2, cnt + 1);
        dfs(num * 10 + 1, cnt + 1);
    }
}
