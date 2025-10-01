import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int len = st.countTokens();
        int cntByte = 0;
        for (int i = 0; i < len; i++) {
            String s = st.nextToken();

            if (s.equals("]")) {
                continue;
            }
            if (s.equals("[")) {
                cntByte += 8;
            } else if (is32BitInteger(s)) {
                cntByte += 8;
            } else {
                cntByte += s.length() + 12;
            }
        }
        
        System.out.print(cntByte);        
    }

    static boolean is32BitInteger(String num) {
        try {
            long n = Long.parseLong(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}