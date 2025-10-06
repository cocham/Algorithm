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
        
        List<String> numSkills = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        int lCnt = 0;
        int sCnt = 0;
        int cnt = 0;
        for (String s : skills) {
            if (numSkills.contains(s)) {
                cnt += 1;
            } else {
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
                }
            }
        }
        
        System.out.print(cnt);
    }
}
