import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int bCnt = 0;
        int sCnt = 0;
        char last = ' ';
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                if (last == 'B') {
                    bCnt--;
                    sCnt += 2;
                    last = 'S';
                } else {
                    sCnt++;
                    last = 'S';
                }
            } else {
                bCnt++;
                last = 'B';
            }
        }


        System.out.print(bCnt + " " + sCnt);
    } 
}