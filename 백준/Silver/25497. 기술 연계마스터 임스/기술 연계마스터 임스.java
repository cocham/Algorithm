import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] skills = br.readLine().split("");
        
        int lCnt = 0;
        int sCnt = 0;
        int cnt = 0;
        for (String s : skills) {
            if (s.equals("L")) {
                lCnt++;
            } else if (s.equals("S")) {
                sCnt++;
            } else if (s.equals("R")) {
                if (lCnt > 0) {
                    lCnt--;
                    cnt++;
                } else {
                    break;
                }
            } else if (s.equals("K")) {
                if (sCnt > 0) {
                    sCnt--;
                    cnt++;
                } else {
                    break;
                }
            } else {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
