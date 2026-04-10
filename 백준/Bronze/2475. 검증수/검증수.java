import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        for (int i = 0; i < 5; i++) {
            long n = Integer.parseInt(st.nextToken());
            sum += (n * n);
        }
        
        System.out.print(sum % 10);

    }
}
