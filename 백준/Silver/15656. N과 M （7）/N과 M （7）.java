import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] nums;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pick = new int[m];
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        
        Arrays.sort(nums);
        dfs(0);
        
        System.out.print(sb);
    }
    
    static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(pick[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for (int x = 0; x < n; x++) {
            pick[depth] = nums[x];
            
            dfs(depth + 1);
        }
    }
}