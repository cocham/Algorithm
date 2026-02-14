import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String g1 = br.readLine();
        String g2 = br.readLine();
        
        int len1 = solve(g1, g2);
        int len2 = solve(g2, g1);
        
        System.out.print(Math.min(len1, len2));
    }
    
    static int solve(String base, String move) {
        int minLen = base.length() + move.length();
        
        for (int i = 0; i < base.length(); i++) {
            if (check(base, move, i)) {
                 int len = Math.max(base.length(), move.length() + i);  
                 minLen = Math.min(len, minLen);
            }
        }
        
        return minLen;
    }
    
    static boolean check(String base, String move, int dist) {
        for (int j = 0; j < move.length(); j++) {
            int baseIdx = j + dist;
            
            if (baseIdx >= base.length()) break;
            
            if (base.charAt(baseIdx) == '2' && move.charAt(j) == '2') {
                return false;
            }
        }
        return true;
    }
}
