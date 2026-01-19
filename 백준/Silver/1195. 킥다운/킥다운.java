import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fst = br.readLine();
        String sec = br.readLine();
        int minLength = fst.length() + sec.length();
        
        for (int i = 0; i < fst.length(); i++) {
            if(canFit(fst, sec, i)) {
                int width = Math.max(fst.length(), i + sec.length());
                minLength = Math.min(minLength, width);
            }
        }
        
        for (int i = 0 ; i < sec.length(); i++) {
            if(canFit(sec, fst, i)) {
                int width = Math.max(sec.length(), i + fst.length());
                minLength = Math.min(minLength, width);
            }
        }
        
        System.out.println(minLength);
    } 
    
    static boolean canFit(String base, String move, int offset) {
        for (int j = 0; j < move.length(); j++) {
            int baseIdx = offset + j;
            
            if (baseIdx >= base.length()) {
                break;
            }
            
            if (base.charAt(baseIdx) == '2' && move.charAt(j) == '2') {
                return false;
            }
        }
        
        return true;
    }
}