import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n, m, answer;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
       
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
                        
            if (n == 0 && m == 0) {
                break;
            }
            
            arr = new int[n];
            answer = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            for (int i = 0; i < m; i++) {
                int key = Integer.parseInt(br.readLine());
                if (binarySearch(key) == true) {
                    answer++;
                }
            }
            
            sb.append(answer).append('\n'); 
        }
        
        System.out.print(sb);
    }
    
    static boolean binarySearch(int key) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                return true;
            } else if (key < arr[mid]) {
                end = mid - 1;                
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}