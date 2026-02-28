import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M, L;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + 2];
        arr[0] = 0;
        arr[N + 1] = L;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            
            for (int i = 1; i <= N + 1; i++) {
                int dist = arr[i] - arr[i - 1];
                cnt += (dist - 1) / mid;
            }
            
            if (cnt > M) {
                left = mid + 1; 
            } else if (cnt <= M) {
                right = mid - 1;
            }
            
        }
        
        System.out.print(left);
    }
}
