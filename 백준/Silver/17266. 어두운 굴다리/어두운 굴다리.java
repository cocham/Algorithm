import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxH = Math.max(arr[0], N - arr[M - 1]);
        for (int i = 1; i < M; i++) {
            int dist = arr[i] - arr[i - 1];
            
            int needH = (dist + 1)/ 2;
            
            maxH = Math.max(needH, maxH);
        }
        
        System.out.println(maxH);
    }
}
