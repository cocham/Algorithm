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
        
        long ans = 0;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            
            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                
                if (sum == 0) {
                    if (arr[left] != arr[right]) {
                        int leftCount = 0;
                        int rightCount = 0;
                        
                        int leftValue = arr[left];
                        while (left < right && arr[left] == leftValue) {
                            leftCount++;
                            left++;
                        }
                        
                        int rightValue = arr[right];
                        while (right >= left && arr[right] == rightValue) {
                            rightCount++;
                            right--;
                        }
                        
                        ans += leftCount * rightCount;
                    } else if (arr[left] == arr[right]) {
                        int sameCnt = right - left + 1;
                        ans += (long) sameCnt * (sameCnt - 1) / 2;
                        break;
                    }
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }

        }
        
        System.out.print(ans);
    }
}
