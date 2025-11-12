import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int toMin(String hhmm) {
        String[] s = hhmm.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = toMin(st.nextToken());   
        int E = toMin(st.nextToken());   
        int Q = toMin(st.nextToken());   

        Set<String> entered = new HashSet<>();  
        Set<String> attended = new HashSet<>(); 

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line, " ");

            int t = toMin(st.nextToken());
            String name = st.nextToken();

            if (t <= S) {
                entered.add(name);
                continue;
            }
            if (t >= E && t <= Q && entered.contains(name)) {
                attended.add(name);
            }
        }

        System.out.println(attended.size());
    }
}