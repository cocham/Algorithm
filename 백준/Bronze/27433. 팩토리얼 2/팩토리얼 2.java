import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n == 0) {
            System.out.println(1);
            return;
        } else {
            long p = 1;
            for (int i = 2; i <= n; i++) {
                p *= i;
            }
            System.out.println(p);
        }
    }
}
