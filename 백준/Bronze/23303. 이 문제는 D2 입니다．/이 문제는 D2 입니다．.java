import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (st.hasMoreTokens()) {
            String s = st.nextToken().toLowerCase();
            if (s.contains("d2")) {
                sb.append("D2");
                break;
            }
        }
        
        if (sb.length() == 0) {
            System.out.print("unrated");
        } else {
            System.out.print(sb);
        }
    }
}