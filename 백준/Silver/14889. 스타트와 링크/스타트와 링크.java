import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] skills;
    static boolean[] check;
    static int minDiff = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        skills = new int[N][N];
        check = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                skills[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0,0);
        System.out.println(minDiff);
    } 
    
    static void calcurate() {
        int stSum = 0;
        int lkSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i] && check[j]) {
                    stSum += skills[i][j];
                } else if (!check[i] && !check[j]) {
                    lkSum += skills[i][j];
                }
            }
        }
        
        int diff = Math.abs(stSum - lkSum);
        minDiff = Math.min(diff, minDiff);
        
        if (minDiff == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }
    
    static void dfs(int idx, int cnt) {
        if (cnt == N / 2) {
            calcurate();
            return;
        }
        
        for (int i = idx; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(i + 1, cnt + 1);
                check[i] = false;
            }
        }
    }
}