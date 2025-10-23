import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();

        while((s = br.readLine()) != null && !s.equals("*")) {
            String[] strs = s.split("");
            int len = strs.length;
            int d = len - 2;
            boolean unique = true;

            for (int i = 0; i <= d; i++) {
                Set<String> pairs = new HashSet<>();
                for (int idx = 0; idx < len - 1; idx++) {
                    String c1 = strs[idx];
                    if (idx + i + 1 > len - 1) {
                        break;
                    }
                    String c2 = strs[idx + i + 1];
                    String pair = c1 + c2;
                    if (!pairs.add(pair)) {
                        unique = false;
                        break;
                    }
                }
                
                if (!unique) {
                    sb.append(s).append(" is NOT surprising.").append('\n');
                    break;
                }
            }
            
            if(unique) {
                sb.append(s).append(" is surprising.").append('\n');
            }
            
        }

        System.out.print(sb);
    }
}