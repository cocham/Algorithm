import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        
        for (int i = 0; i < n ; i++) {
            arr[i] = br.readLine();
        }    
        Arrays.sort(arr, (a,b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append('\n');
        for (int i = 1; i < n; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                sb.append(arr[i]).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}
