import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int minAbsSum = Integer.MAX_VALUE;
        int left = 0;
        int right = N - 1;
        int ansLeft = 0;
        int ansRight = 0;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if(Math.abs(sum) < minAbsSum) {
                minAbsSum = Math.abs(sum);
                ansLeft = arr[left];
                ansRight = arr[right];
            }
            
            if (sum == 0) {
                break;
            } else if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            }
        }
        
        System.out.print(ansLeft + " " + ansRight);
    }
}
