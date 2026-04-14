import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int i = 666;
        while (true) {

            String s = String.valueOf(i);
            
            if (s.contains("666")) {
                cnt++;
            }
            
            if (cnt == n) {
                break;
            }
            
                
            i++;
        }
        
        System.out.print(i);
    }
}
