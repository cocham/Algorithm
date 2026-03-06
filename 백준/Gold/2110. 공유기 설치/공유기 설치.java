import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        long left = 1;
        long right = arr[N - 1] - arr[0];
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            int install = 1;
            int lastInstalled = arr[0];
            
            for (int i = 1; i < N; i++) {
                int distance = Math.abs(arr[i] - lastInstalled);
                
                if (distance >= mid) {
                    install++;
                    lastInstalled = arr[i];
                }
            }
            
            if (install >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}
