import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        
        dfs(plus, minus, mul, div, 1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int plus, int minus, int mul, int div, int idx, int sum) {
        if (idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        
        if (plus > 0) {
            dfs(plus - 1, minus, mul, div, idx + 1, sum + nums[idx]);
        }
        if (minus > 0) {
            dfs(plus, minus - 1, mul, div, idx + 1, sum - nums[idx]);
        }
        if (mul > 0) {
            dfs(plus, minus, mul - 1, div, idx + 1, sum * nums[idx]);
        }
        if (div > 0) {
            dfs(plus, minus, mul, div - 1, idx + 1, sum / nums[idx]);
        }
    }
}
