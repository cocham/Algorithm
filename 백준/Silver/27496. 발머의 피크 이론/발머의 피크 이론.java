import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            
            if (i >= L) {
                sum -= arr[i - L];
            }
            
            if (sum >= 129 && sum <= 138) {
                count++;
            }
        }
        
        System.out.print(count);
    }
}
