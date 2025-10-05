import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Set<String> cheeses = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String toping = st.nextToken();

            if (toping.endsWith("Cheese")) {
                cheeses.add(toping);
            }
        }
        
        if (cheeses.size() >= 4) {
            System.out.print("yummy");
        } else {
            System.out.print("sad");
        }
    }
}