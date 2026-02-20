import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int maxCnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0);
        System.out.print(maxCnt);
    }
    
    static void dfs(int pick) {
        if (pick == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][0] <= 0) {
                    cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
            return;
        }
        
        if (arr[pick][0] <= 0) {
            dfs(pick + 1);
            return;
        }
        
        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == pick) continue;
            if (arr[i][0] <= 0) continue;
            
            hit = true;
            
            int tmp1 = arr[pick][1];
            int tmp2 = arr[i][1];
            arr[pick][0] -= tmp2;
            arr[i][0] -= tmp1;

            dfs(pick + 1);
            arr[pick][0] += tmp2;
            arr[i][0] += tmp1;
        }
        
        if (!hit) {
            dfs(pick + 1);
        }
    }
}
