import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[20000001];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10000000]++;
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken()) + 10000000;
            
            sb.append(arr[n] + " ");
        }
        
        System.out.print(sb);
    }
}