import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                System.out.print(cnt);
                return;
            }
            
            N -= 3;
            cnt++;
        }
        
        System.out.print(-1);

    }
}
