import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        long minSum = Long.MAX_VALUE;
        int startN = 0;
        int midN = 0;
        int endN = 0;
        
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            
            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                
                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = Math.abs(sum);
                    startN = arr[i];
                    midN = arr[left];
                    endN = arr[right];
                }
                
                if (sum == 0) {
                    break;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        
        System.out.print(startN + " " + midN + " " + endN);
    }
}