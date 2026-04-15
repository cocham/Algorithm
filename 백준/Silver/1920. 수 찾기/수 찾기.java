import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (binarySearch(arr, target)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        
        System.out.print(sb);
    }
    
    static boolean binarySearch(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
           
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == n) {
                return true;
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else if (arr[mid] > n) {
                high = mid - 1;
            }
            
        }
        
        return false;
    }
}
