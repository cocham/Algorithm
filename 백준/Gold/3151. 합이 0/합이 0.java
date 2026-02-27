import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        long team = 0;
        for (int i = 0; i < n; i++) {
            int stand = arr[i];
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = stand + arr[left] + arr[right];
                
                if (sum == 0) {
                    if (arr[left] == arr[right]) {
                        long sameCnt = right - left + 1;
                        team += sameCnt * (sameCnt - 1) / 2;
                        break;
                    }
                    
                    int l = 1;
                    int r = 1;
                   
                    while (arr[left] == arr[left + 1]) {
                        left++;
                        l++;
                    }
                    
                    while (arr[right] == arr[right - 1]) {
                        right--;
                        r++;
                    }
                    
                    team += l * r;
                    left++;
                    right--;
                }
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        
        System.out.print(team);
    }
}
