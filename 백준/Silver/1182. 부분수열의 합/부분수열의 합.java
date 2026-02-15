import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0,0);
        if (S == 0) {
            cnt--;
        }
        System.out.print(cnt);
    }
    
    static void dfs(int idx, int sum) {
        if (sum == S) {
            cnt++;
        }
        
        for (int i = idx; i < N; i++) {
            dfs(i + 1, sum + arr[i]);
        }
    }
}